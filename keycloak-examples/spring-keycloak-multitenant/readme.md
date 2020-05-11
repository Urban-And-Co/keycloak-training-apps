# Spring / Keycloak Multitenant Tutorial

This is a sample project to illustrate the multi-tenant with Keycloak and Spring Boot

## How to start

> Start your Keycloak server before running the app
> * How to create a realm for this project :
>   * Click on "Import" in Keycloak main menu
>   * Click on "Select file", and find realm-ORGA1-export.json.
>   * Turn on "Import clients", "Import realm roles" and "Import client roles".
>   * Click on "Import"
>   * Repeat previous steps for realm-ORGA2-export.json

```shell
mvn spring-boot:run
```
