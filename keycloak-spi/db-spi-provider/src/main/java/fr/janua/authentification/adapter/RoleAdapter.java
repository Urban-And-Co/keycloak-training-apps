package fr.janua.authentification.adapter;

import fr.janua.authentification.model.CliRole;
import org.keycloak.models.KeycloakSession;
import org.keycloak.models.RealmModel;
import org.keycloak.models.RoleContainerModel;
import org.keycloak.models.RoleModel;
import org.keycloak.models.jpa.JpaModel;
import org.keycloak.models.utils.KeycloakModelUtils;

import java.util.*;

public class RoleAdapter implements RoleModel, JpaModel<CliRole> {

	private CliRole role;

	private RealmModel realm;

	private KeycloakSession session;

	public RoleAdapter(KeycloakSession session, RealmModel realm, CliRole role) {
		this.realm = realm;
		this.role = role;
		this.session = session;
	}

	@Override
	public CliRole getEntity() {
		return this.role;
	}

	@Override
	public String getName() {
		return this.role.getName();
	}

	@Override
	public String getDescription() {
		return this.role.getDescription();
	}

	@Override
	public void setDescription(String description) {
		role.setDescription(description);
	}

	@Override
	public String getId() {
		return this.role.getId();
	}

	@Override
	public void setName(String name) {
		this.role.setName(name);
	}

	@Override
	public boolean isComposite() {
		return false;
	}

	@Override
	public void addCompositeRole(RoleModel role) {
	}

	@Override
	public void removeCompositeRole(RoleModel role) {
	}

	@Override
	public Set<RoleModel> getComposites() {
		return null;
	}

	@Override
	public boolean hasRole(RoleModel role) {
		return this.equals(role) || KeycloakModelUtils.searchFor(role, this, new HashSet<>());
	}

	@Override
	public boolean isClientRole() {
		return true;
	}

	@Override
	public String getContainerId() {
		return this.role.getClient().getId();
	}

	@Override
	public RoleContainerModel getContainer() {
		return new ClientAdapter(this.session, this.realm, this.role.getClient());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || !(o instanceof RoleModel))
			return false;

		RoleModel that = (RoleModel) o;
		return that.getId().equals(getId());
	}

	@Override
	public void setSingleAttribute(String name, String value) {
	}

	@Override
	public void setAttribute(String name, Collection<String> values) {
	}

	@Override
	public void removeAttribute(String name) {
	}

	@Override
	public String getFirstAttribute(String name) {
		return null;
	}

	@Override
	public List<String> getAttribute(String name) {
		List<String> attributes = new ArrayList<>();
		return attributes;
	}

	@Override
	public Map<String, List<String>> getAttributes() {
		Map<String, List<String>> map = new HashMap<>();
		return map;
	}

}
