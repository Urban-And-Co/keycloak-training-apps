saml-group-mapper: Keycloak SPI with custom SAML group mapper 
=============================================================

Summary: User Storage Provider with EJB and JPA  
Target Product: <span>Keycloak</span>  

What is it?
-----------

We extend the Identity Broker to allow a custom Keycloak mapper for groups. This mapper will take a SAML request attribute and assign
a user to a group on a condition the field properties match. In our custom implementation of the SAML attribute mapper, we have access
to the SAML assertion where we can add our own rules for creating, joining, or leaving a keycloak group. We are able to match our assertions
against a user provided input in the configuration of the identity broker.

System Requirements
-------------------

You need to have <span>Keycloak</span> running.

All you need to build this project is Java 8.0 (Java SDK 1.8) or later and Maven 3.1.1 or later.


Build and Deploy the Quickstart
-------------------------------

To deploy the provider, run the following maven command:

    ````
     mvn clean spring-javaformat:apply install wildfly:deploy -DskipTests
    ````

If you want to play with and modify the example, simply rerun the maven deploy command above and the new version will be hot deployed.


Miscellaneous Maven commands
----------------------------
To check all the plugins and reports used in your project and display a list of those plugins with newer versions available

    mvn versions:display-plugin-updates

To check all the dependencies used in your project and display a list of those dependencies with newer versions available

    mvn versions:display-dependency-updates


