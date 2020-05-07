package fr.janua.authentification.provider;

import fr.janua.authentification.adapter.UserAdapter;
import fr.janua.authentification.model.Actor;
import org.jboss.logging.Logger;
import org.keycloak.component.ComponentModel;
import org.keycloak.credential.CredentialInput;
import org.keycloak.credential.CredentialInputValidator;
import org.keycloak.models.*;
import org.keycloak.models.cache.CachedUserModel;
import org.keycloak.models.cache.OnUserCache;
import org.keycloak.models.credential.PasswordCredentialModel;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.UserStorageProvider;
import org.keycloak.storage.user.UserLookupProvider;

import javax.ejb.Local;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateful
@Local(CerbereUserStorageProvider.class)
public class CerbereUserStorageProvider
		implements UserStorageProvider, UserLookupProvider, CredentialInputValidator, OnUserCache {

	private static final Logger logger = Logger.getLogger(CerbereUserStorageProvider.class);

	public static final String PASSWORD_CACHE_KEY = UserAdapter.class.getName() + ".password";

	@PersistenceContext
	private EntityManager em;

	private ComponentModel model;

	private KeycloakSession session;

	public CerbereUserStorageProvider() {
	}

	public CerbereUserStorageProvider(KeycloakSession session, ComponentModel model) {
		this.session = session;
		this.model = model;
	}

	public void setModel(ComponentModel model) {
		this.model = model;
	}

	public void setSession(KeycloakSession session) {
		this.session = session;
	}

	@Override
	public void preRemove(RealmModel realm) {

	}

	@Override
	public void preRemove(RealmModel realm, GroupModel group) {

	}

	@Override
	public void preRemove(RealmModel realm, RoleModel role) {

	}

	@Remove
	@Override
	public void close() {
	}

	@Override
	public UserModel getUserById(String id, RealmModel realm) {
		logger.info("getUserById: " + id);
		String persistenceId = StorageId.externalId(id);
		Actor entity = em.find(Actor.class, persistenceId);
		if (entity == null) {
			logger.info("could not find user by id: " + id);
			return null;
		}
		return new UserAdapter(session, realm, model, entity);
	}

	@Override
	public UserModel getUserByUsername(String username, RealmModel realm) {
		logger.info("getUserByUsername: " + username);
		TypedQuery<Actor> query = em.createNamedQuery("getUserByUsername", Actor.class);
		query.setParameter("username", username);
		List<Actor> result = query.getResultList();
		if (result.isEmpty()) {
			logger.info("could not find username: " + username);
			return null;
		}

		return new UserAdapter(session, realm, model, result.get(0));
	}

	@Override
	public UserModel getUserByEmail(String email, RealmModel realm) {
		logger.info("getUserByEmail: " + email);
		TypedQuery<Actor> query = em.createNamedQuery("getUserByEmail", Actor.class);
		query.setParameter("email", email);
		List<Actor> result = query.getResultList();
		if (result.isEmpty())
			return null;
		return new UserAdapter(session, realm, model, result.get(0));
	}

	@Override
	public boolean supportsCredentialType(String credentialType) {
		return PasswordCredentialModel.TYPE.equals(credentialType);
	}

	@Override
	public boolean isConfiguredFor(RealmModel realm, UserModel user, String credentialType) {
		return supportsCredentialType(credentialType) && getPassword(user) != null;
	}

	@Override
	public boolean isValid(RealmModel realm, UserModel user, CredentialInput input) {
		if (!supportsCredentialType(input.getType()) || !(input instanceof UserCredentialModel))
			return false;
		PasswordCredentialModel cred = (PasswordCredentialModel) input;
		String password = getPassword(user);
		return password != null && password.equals(cred.getPasswordSecretData().getValue());
	}

	private String getPassword(UserModel user) {
		String password = null;
		if (user instanceof CachedUserModel) {
			password = (String) ((CachedUserModel) user).getCachedWith().get(PASSWORD_CACHE_KEY);
		}
		else if (user instanceof UserAdapter) {
			password = ((UserAdapter) user).getPassword();
		}
		return password;
	}

	@Override
	public void onCache(RealmModel realm, CachedUserModel user, UserModel delegate) {
		String password = ((UserAdapter) delegate).getPassword();
		if (password != null) {
			user.getCachedWith().put(PASSWORD_CACHE_KEY, password);
		}
	}

}
