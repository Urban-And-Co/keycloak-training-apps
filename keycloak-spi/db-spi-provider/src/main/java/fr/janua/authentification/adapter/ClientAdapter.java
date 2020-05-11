package fr.janua.authentification.adapter;

import fr.janua.authentification.model.Client;
import org.keycloak.models.*;
import org.keycloak.models.jpa.JpaModel;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ClientAdapter implements ClientModel, JpaModel<Client> {

	private Client client;

	private KeycloakSession session;

	private RealmModel realm;

	private boolean alwaysDisplayInConsole;

	public ClientAdapter(KeycloakSession session, RealmModel realm, Client client) {
		this.session = session;
		this.realm = realm;
		this.client = client;
	}

	@Override
	public Client getEntity() {
		return this.client;
	}

	@Override
	public String getId() {
		return this.client.getId();
	}

	@Override
	public RealmModel getRealm() {
		return this.realm;
	}

	@Override
	public String getClientId() {
		return this.client.getName();
	}

	@Override
	public void setClientId(String clientId) {
		this.client.setName(clientId);
	}

	@Override
	public String getName() {
		return this.client.getName();
	}

	@Override
	public void setName(String name) {
		this.client.setName(name);
	}

	@Override
	public String getDescription() {
		return this.client.getDescription();
	}

	@Override
	public void setDescription(String description) {
		this.client.setDescription(description);
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public void setEnabled(boolean enabled) {
	}

	@Override
	public boolean isAlwaysDisplayInConsole() {
		return alwaysDisplayInConsole;
	}

	@Override
	public void setAlwaysDisplayInConsole(boolean alwaysDisplayInConsole) {
		this.alwaysDisplayInConsole = alwaysDisplayInConsole;
	}

	@Override
	public boolean isPublicClient() {
		return false;
	}

	@Override
	public void setPublicClient(boolean flag) {

	}

	@Override
	public void updateClient() {
	}

	@Override
	public RoleModel getRole(String name) {
		return session.realms().getClientRole(realm, this, name);
	}

	@Override
	public RoleModel addRole(String name) {
		return session.realms().addClientRole(realm, this, name);
	}

	@Override
	public RoleModel addRole(String id, String name) {
		return session.realms().addClientRole(realm, this, id, name);
	}

	@Override
	public boolean removeRole(RoleModel roleModel) {
		return session.realms().removeRole(realm, roleModel);
	}

	@Override
	public Set<RoleModel> getRoles() {
		return session.realms().getClientRoles(realm, this);
	}

	@Override
	public Set<RoleModel> getRoles(Integer firstResult, Integer maxResults) {
		return session.realms().getClientRoles(realm, this, firstResult, maxResults);
	}

	@Override
	public Set<RoleModel> searchForRoles(String search, Integer first, Integer max) {
		return session.realms().searchForClientRoles(realm, this, search, first, max);
	}

	@Override
	public List<String> getDefaultRoles() {
		return null;
	}

	@Override
	public void addDefaultRole(String name) {

	}

	@Override
	public void updateDefaultRoles(String... defaultRoles) {

	}

	@Override
	public void removeDefaultRoles(String... defaultRoles) {

	}

	@Override
	public boolean isSurrogateAuthRequired() {
		return false;
	}

	@Override
	public void setSurrogateAuthRequired(boolean surrogateAuthRequired) {

	}

	@Override
	public Set<String> getWebOrigins() {
		return null;
	}

	@Override
	public void setWebOrigins(Set<String> webOrigins) {

	}

	@Override
	public void addWebOrigin(String webOrigin) {

	}

	@Override
	public void removeWebOrigin(String webOrigin) {

	}

	@Override
	public Set<String> getRedirectUris() {
		return null;
	}

	@Override
	public void setRedirectUris(Set<String> redirectUris) {

	}

	@Override
	public void addRedirectUri(String redirectUri) {

	}

	@Override
	public void removeRedirectUri(String redirectUri) {

	}

	@Override
	public String getManagementUrl() {
		return null;
	}

	@Override
	public void setManagementUrl(String url) {

	}

	@Override
	public String getRootUrl() {
		return null;
	}

	@Override
	public void setRootUrl(String url) {

	}

	@Override
	public String getBaseUrl() {
		return null;
	}

	@Override
	public void setBaseUrl(String url) {

	}

	@Override
	public boolean isBearerOnly() {
		return false;
	}

	@Override
	public void setBearerOnly(boolean only) {

	}

	@Override
	public int getNodeReRegistrationTimeout() {
		return 0;
	}

	@Override
	public void setNodeReRegistrationTimeout(int timeout) {

	}

	@Override
	public String getClientAuthenticatorType() {
		return null;
	}

	@Override
	public void setClientAuthenticatorType(String clientAuthenticatorType) {

	}

	@Override
	public boolean validateSecret(String secret) {
		return false;
	}

	@Override
	public String getSecret() {
		return null;
	}

	@Override
	public void setSecret(String secret) {

	}

	@Override
	public String getRegistrationToken() {
		return null;
	}

	@Override
	public void setRegistrationToken(String registrationToken) {

	}

	@Override
	public String getProtocol() {
		return null;
	}

	@Override
	public void setProtocol(String protocol) {

	}

	@Override
	public void setAttribute(String name, String value) {

	}

	@Override
	public void removeAttribute(String name) {

	}

	@Override
	public String getAttribute(String name) {
		return null;
	}

	@Override
	public Map<String, String> getAttributes() {
		return null;
	}

	@Override
	public String getAuthenticationFlowBindingOverride(String binding) {
		return null;
	}

	@Override
	public Map<String, String> getAuthenticationFlowBindingOverrides() {
		return null;
	}

	@Override
	public void removeAuthenticationFlowBindingOverride(String binding) {

	}

	@Override
	public void setAuthenticationFlowBindingOverride(String binding, String flowId) {

	}

	@Override
	public boolean isFrontchannelLogout() {
		return false;
	}

	@Override
	public void setFrontchannelLogout(boolean flag) {

	}

	@Override
	public boolean isFullScopeAllowed() {
		return false;
	}

	@Override
	public void setFullScopeAllowed(boolean value) {

	}

	@Override
	public boolean isConsentRequired() {
		return false;
	}

	@Override
	public void setConsentRequired(boolean consentRequired) {

	}

	@Override
	public boolean isStandardFlowEnabled() {
		return false;
	}

	@Override
	public void setStandardFlowEnabled(boolean standardFlowEnabled) {

	}

	@Override
	public boolean isImplicitFlowEnabled() {
		return false;
	}

	@Override
	public void setImplicitFlowEnabled(boolean implicitFlowEnabled) {

	}

	@Override
	public boolean isDirectAccessGrantsEnabled() {
		return false;
	}

	@Override
	public void setDirectAccessGrantsEnabled(boolean directAccessGrantsEnabled) {

	}

	@Override
	public boolean isServiceAccountsEnabled() {
		return false;
	}

	@Override
	public void setServiceAccountsEnabled(boolean serviceAccountsEnabled) {

	}

	@Override
	public void addClientScope(ClientScopeModel clientScope, boolean defaultScope) {

	}

	@Override
	public void removeClientScope(ClientScopeModel clientScope) {

	}

	@Override
	public Map<String, ClientScopeModel> getClientScopes(boolean defaultScope, boolean filterByProtocol) {
		return null;
	}

	@Override
	public int getNotBefore() {
		return 0;
	}

	@Override
	public void setNotBefore(int notBefore) {

	}

	@Override
	public Map<String, Integer> getRegisteredNodes() {
		return null;
	}

	@Override
	public void registerNode(String nodeHost, int registrationTime) {

	}

	@Override
	public void unregisterNode(String nodeHost) {

	}

	@Override
	public Set<ProtocolMapperModel> getProtocolMappers() {
		return null;
	}

	@Override
	public ProtocolMapperModel addProtocolMapper(ProtocolMapperModel model) {
		return null;
	}

	@Override
	public void removeProtocolMapper(ProtocolMapperModel mapping) {

	}

	@Override
	public void updateProtocolMapper(ProtocolMapperModel mapping) {

	}

	@Override
	public ProtocolMapperModel getProtocolMapperById(String id) {
		return null;
	}

	@Override
	public ProtocolMapperModel getProtocolMapperByName(String protocol, String name) {
		return null;
	}

	@Override
	public Set<RoleModel> getScopeMappings() {
		return null;
	}

	@Override
	public void addScopeMapping(RoleModel role) {

	}

	@Override
	public void deleteScopeMapping(RoleModel role) {

	}

	@Override
	public Set<RoleModel> getRealmScopeMappings() {
		return null;
	}

	@Override
	public boolean hasScope(RoleModel role) {
		return false;
	}

	@Override
	public String toString() {
		return "ClientAdapter{" + "client=" + client.getName() + '}';
	}

}
