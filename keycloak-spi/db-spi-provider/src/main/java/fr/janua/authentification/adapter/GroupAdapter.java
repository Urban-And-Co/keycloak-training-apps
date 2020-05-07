package fr.janua.authentification.adapter;

import fr.janua.authentification.model.GeoGroup;
import org.keycloak.models.ClientModel;
import org.keycloak.models.GroupModel;
import org.keycloak.models.RoleModel;
import org.keycloak.models.jpa.JpaModel;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GroupAdapter implements GroupModel, JpaModel<GeoGroup> {

	private GeoGroup group;

	public GroupAdapter(GeoGroup group) {
		this.group = group;
	}

	@Override
	public GeoGroup getEntity() {
		return this.group;
	}

	@Override
	public String getId() {
		return this.group.getId();
	}

	@Override
	public String getName() {
		return this.group.getName();
	}

	@Override
	public void setName(String name) {
		this.group.setName(name);
	}

	@Override
	public void setSingleAttribute(String name, String value) {
	}

	@Override
	public void setAttribute(String name, List<String> values) {
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
		return null;
	}

	@Override
	public Map<String, List<String>> getAttributes() {
		return null;
	}

	@Override
	public GroupModel getParent() {
		return null;
	}

	@Override
	public String getParentId() {
		return null;
	}

	@Override
	public Set<GroupModel> getSubGroups() {
		return Collections.EMPTY_SET;
	}

	@Override
	public void setParent(GroupModel group) {
	}

	@Override
	public void addChild(GroupModel subGroup) {
	}

	@Override
	public void removeChild(GroupModel subGroup) {
	}

	@Override
	public Set<RoleModel> getRealmRoleMappings() {
		return Collections.EMPTY_SET;
	}

	@Override
	public Set<RoleModel> getClientRoleMappings(ClientModel app) {
		return Collections.EMPTY_SET;
	}

	@Override
	public boolean hasRole(RoleModel role) {
		return false;
	}

	@Override
	public void grantRole(RoleModel role) {
	}

	@Override
	public Set<RoleModel> getRoleMappings() {
		return Collections.EMPTY_SET;
	}

	@Override
	public void deleteRoleMapping(RoleModel role) {
	}

	@Override
	public String toString() {
		return "GroupAdapter{" + "group=" + group.getName() + '}';
	}

}
