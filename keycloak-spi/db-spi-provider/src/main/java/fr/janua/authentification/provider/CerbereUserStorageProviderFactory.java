package fr.janua.authentification.provider;

import org.jboss.logging.Logger;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.storage.UserStorageProviderFactory;

import javax.naming.InitialContext;

public class CerbereUserStorageProviderFactory implements UserStorageProviderFactory<CerbereUserStorageProvider> {

	private static final Logger logger = Logger.getLogger(CerbereUserStorageProviderFactory.class);

	@Override
	public String getId() {
		return "cerbere-user-storage-jpa";
	}

	@Override
	public CerbereUserStorageProvider create(KeycloakSession session, ComponentModel model) {
		try {
			InitialContext ctx = new InitialContext();
			CerbereUserStorageProvider provider = (CerbereUserStorageProvider) ctx.lookup(
					"java:global/keycloak-cerbere-provider/" + CerbereUserStorageProvider.class.getSimpleName());
			provider.setModel(model);
			provider.setSession(session);
			return provider;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String getHelpText() {
		return "JPA Cerbere User Storage Provider";
	}

	@Override
	public void close() {
		logger.info("<<<<<< Closing factory");

	}

}
