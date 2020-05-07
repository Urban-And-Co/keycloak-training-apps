package fr.gouv.snum.authentification.provider;

import org.keycloak.broker.provider.AbstractIdentityProviderMapper;
import org.jboss.logging.Logger;
import org.keycloak.broker.provider.BrokeredIdentityContext;
import org.keycloak.broker.provider.IdentityBrokerException;
import org.keycloak.broker.provider.IdentityProviderMapper;
import org.keycloak.broker.saml.SAMLEndpoint;
import org.keycloak.broker.saml.SAMLIdentityProviderFactory;
import org.keycloak.dom.saml.v2.assertion.AssertionType;
import org.keycloak.dom.saml.v2.assertion.AttributeStatementType;
import org.keycloak.dom.saml.v2.assertion.AttributeType;
import org.keycloak.models.*;
import org.keycloak.models.utils.KeycloakModelUtils;
import org.keycloak.provider.ProviderConfigProperty;

import java.util.ArrayList;
import java.util.List;

public class AttributeToGroupMapper extends AbstractIdentityProviderMapper implements IdentityProviderMapper {

	public static final String[] COMPATIBLE_PROVIDERS = { SAMLIdentityProviderFactory.PROVIDER_ID };

	private static final List<ProviderConfigProperty> configProperties = new ArrayList<ProviderConfigProperty>();

	public static final String ATTRIBUTE_NAME = "attribute.name";

	public static final String ATTRIBUTE_FRIENDLY_NAME = "attribute.friendly.name";

	public static final String ATTRIBUTE_VALUE = "attribute.value";

	static {
		ProviderConfigProperty property;
		property = new ProviderConfigProperty();
		property.setName(ATTRIBUTE_NAME);
		property.setLabel("Attribute Name");
		property.setHelpText(
				"Name of attribute to search for in assertion.  You can leave this blank and specify a friendly name instead.");
		property.setType(ProviderConfigProperty.STRING_TYPE);
		configProperties.add(property);
		property = new ProviderConfigProperty();
		property.setName(ATTRIBUTE_FRIENDLY_NAME);
		property.setLabel("Friendly Name");
		property.setHelpText(
				"Friendly name of attribute to search for in assertion.  You can leave this blank and specify a name instead.");
		property.setType(ProviderConfigProperty.STRING_TYPE);
		configProperties.add(property);
		property = new ProviderConfigProperty();
		property.setName(ATTRIBUTE_VALUE);
		property.setLabel("Attribute Value");
		property.setHelpText(
				"Value the attribute must have.  If the attribute is a list, then the value must be contained in the list.");
		property.setType(ProviderConfigProperty.STRING_TYPE);
		configProperties.add(property);
		property = new ProviderConfigProperty();
		property.setName("group");
		property.setLabel("Group");
		property.setHelpText("Group to grant to user. i.e. /Group1/SubGroup2");
		property.setType(ProviderConfigProperty.STRING_TYPE);
		configProperties.add(property);
	}

	public static final String PROVIDER_ID = "saml-group-idp-mapper";

	@Override
	public List<ProviderConfigProperty> getConfigProperties() {
		return configProperties;
	}

	@Override
	public String getId() {
		return PROVIDER_ID;
	}

	@Override
	public String[] getCompatibleProviders() {
		return COMPATIBLE_PROVIDERS;
	}

	@Override
	public String getDisplayCategory() {
		return "Group Mapper";
	}

	@Override
	public String getDisplayType() {
		return "SAML Attribute to Group";
	}

	@Override
	public void importNewUser(KeycloakSession session, RealmModel realm, UserModel user,
			IdentityProviderMapperModel mapperModel, BrokeredIdentityContext context) {
		String groupName = mapperModel.getConfig().get("group");
		if (isAttributePresent(mapperModel, context)) {
			GroupModel group = KeycloakModelUtils.findGroupByPath(realm, groupName);
			if (group == null)
				throw new IdentityBrokerException("Unable to find group: " + groupName);
			user.joinGroup(group);
		}
	}

	private static final Logger logger = Logger.getLogger(AttributeToGroupMapper.class);

	protected boolean isAttributePresent(IdentityProviderMapperModel mapperModel, BrokeredIdentityContext context) {
		String name = mapperModel.getConfig().get(ATTRIBUTE_NAME);
		if (name != null && name.trim().equals(""))
			name = null;
		String friendly = mapperModel.getConfig().get(ATTRIBUTE_FRIENDLY_NAME);
		if (friendly != null && friendly.trim().equals(""))
			friendly = null;
		String desiredValue = mapperModel.getConfig().get(ATTRIBUTE_VALUE);
		AssertionType assertion = (AssertionType) context.getContextData().get(SAMLEndpoint.SAML_ASSERTION);
		for (AttributeStatementType statement : assertion.getAttributeStatements()) {
			for (AttributeStatementType.ASTChoiceType choice : statement.getAttributes()) {
				AttributeType attr = choice.getAttribute();
				if (name != null && !name.equals(attr.getName()))
					continue;
				if (friendly != null && !friendly.equals(attr.getFriendlyName()))
					continue;
				for (Object val : attr.getAttributeValue()) {
					if (val.equals(desiredValue))
						return true;
				}
			}
		}
		return false;
	}

	@Override
	public void updateBrokeredUser(KeycloakSession session, RealmModel realm, UserModel user,
			IdentityProviderMapperModel mapperModel, BrokeredIdentityContext context) {
		String groupName = mapperModel.getConfig().get("group");
		GroupModel group = KeycloakModelUtils.findGroupByPath(realm, groupName);
		if (group == null)
			throw new IdentityBrokerException("Unable to find group: " + groupName);
		if (!isAttributePresent(mapperModel, context)) {
			user.leaveGroup(group);
		}
		else {
			user.joinGroup(group);
		}
	}

	@Override
	public String getHelpText() {
		return "If a claim exists, grant the user the specified realm or application group.";
	}

	@Override
	public AttributeToGroupMapper create(KeycloakSession session) {
		return new AttributeToGroupMapper();
	}

}
