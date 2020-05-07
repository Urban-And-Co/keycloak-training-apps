package fr.janua.authentification.adapter;

import fr.janua.authentification.model.Actor;
import fr.janua.authentification.model.CliRole;
import fr.janua.authentification.model.GeoGroup;
import org.keycloak.common.util.MultivaluedHashMap;
import org.keycloak.component.ComponentModel;
import org.keycloak.models.GroupModel;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.RoleModel;
import org.keycloak.storage.StorageId;
import org.keycloak.storage.adapter.AbstractUserAdapterFederatedStorage;

import java.util.*;

public class UserAdapter extends AbstractUserAdapterFederatedStorage {

	private final Actor actor;

	private final String keycloakId;

	public UserAdapter(KeycloakSession session, RealmModel realm, ComponentModel model, Actor actor) {
		super(session, realm, model);
		this.actor = actor;
		this.keycloakId = StorageId.keycloakId(model, actor.getId());
	}

	public String getPassword() {
		return this.actor.getPassword();
	}

	public void setPassword(String password) {
		this.actor.setPassword(password);
	}

	@Override
	public String getId() {
		return this.keycloakId;
	}

	@Override
	public String getUsername() {
		return this.actor.getUsername();
	}

	@Override
	public void setUsername(String username) {
		this.actor.setUsername(username);
	}

	@Override
	public void setEmail(String email) {
		this.actor.setEmail(email);
	}

	@Override
	public String getEmail() {
		return this.actor.getEmail();
	}

	@Override
	public String getFirstName() {
		return this.actor.getFirstName();
	}

	@Override
	public void setFirstName(String firstName) {
		this.actor.setFirstName(firstName);
	}

	@Override
	public String getLastName() {
		return this.actor.getLastName();
	}

	@Override
	public void setLastName(String lastName) {
		this.actor.setLastName(lastName);
	}

	@Override
	public void setSingleAttribute(String name, String value) {
		if (name.equals("phone")) {
			this.actor.setPhoneNumber(value);
		}
		else {
			super.setSingleAttribute(name, value);
		}
	}

	@Override
	public void removeAttribute(String name) {
		if (name.equals("phone")) {
			this.actor.setPhoneNumber(null);
		}
		else {
			super.removeAttribute(name);
		}
	}

	@Override
	public void setAttribute(String name, List<String> values) {
		if (name.equals("phone")) {
			this.actor.setPhoneNumber(values.get(0));
		}
		else {
			super.setAttribute(name, values);
		}
	}

	@Override
	public String getFirstAttribute(String name) {
		if (name.equals("phone")) {
			return this.actor.getPhoneNumber();
		}
		else {
			return super.getFirstAttribute(name);
		}
	}

	@Override
	public Map<String, List<String>> getAttributes() {
		Map<String, List<String>> attrs = super.getAttributes();
		MultivaluedHashMap<String, String> all = new MultivaluedHashMap<>();
		all.putAll(attrs);
		all.add("phone", this.actor.getPhoneNumber());
		return all;
	}

	@Override
	public List<String> getAttribute(String name) {
		List<String> returnedList = new LinkedList<>();
		if (name.equals("phone")) {
			returnedList.add(this.actor.getPhoneNumber());
		}
		else {
			returnedList = super.getAttribute(name);
		}
		return (returnedList == null) ? new LinkedList<>() : returnedList;
	}

	@Override
	public Set<GroupModel> getGroups() {
		Set<GroupModel> set = new HashSet<>();
		for (GeoGroup grp : this.actor.getGroups()) {
			set.add(new GroupAdapter(grp));
		}
		return set;
	}

	// @Override
	public Set<RoleModel> getRoleMappings() {
		Set<RoleModel> set = new HashSet<>();
		for (CliRole rol : this.actor.getRoles()) {
			set.add(new RoleAdapter(this.session, this.realm, rol));
		}
		return set;
	}

}
