package fr.janua.spring.keycloak.multitenant.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultitenantController {

    @GetMapping(value = "/admin", produces = MediaType.APPLICATION_JSON_VALUE)
    public String adminSecuredEndpoint() {
        return "Documents admin";
    }

    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
    public String userSecuredEndpoint() { return "Documents user"; }
}
