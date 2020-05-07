# Environment setup

## Keycloak

Install the latest Keycloak : https://www.keycloak.org/downloads.html
Launch Keycloak with the following commnand from Keycloak bin directory :

    $ ./standalone.sh -Djboss.socket.binding.port-offset=100

## Tomcat

Install the latest Tomcat 9 : https://tomcat.apache.org/download-90.cgi
Launch Tomcat with the following command from Tomcat bin directory :

    $ ./startup.sh
    
Supervise the Tomcat logs with the following command from Tomcat log directory :  

    $ tail -f catalina.out

# Build

To build the application, launch from the parent directory :

    $ mvn clean spring-javaformat:apply install

The Wars "pkce.war" and "frontend.war" are deployed in the Tomcat webapps dicrectory.

# Test

To access the application, acces thorugh a browser to :

    $ mvn clean spring-javaformat:apply install

The Wars "pkce.war" and "frontend.war" are deployed in the Tomcat webapps dicrectory.


# Miscellaneous Maven commands
    
To check all the plugins and reports used in your project and display a list of those plugins with newer versions available

    $ mvn versions:display-plugin-updates

To check all the dependencies used in your project and display a list of those dependencies with newer versions available

    $ mvn versions:display-dependency-updates

Once your spring boot application is started you can track the latest 100 http requests by calling this url: http://localhost:9090/actuator/httptrace
