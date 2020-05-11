package org.keycloak.example.multitenant.boundary;

import org.keycloak.KeycloakPrincipal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/*")
public class ProtectedServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String realm = req.getPathInfo().split("/")[1];
        if (realm.contains("?")) {
            realm = realm.split("\\?")[0];
        }

        if (req.getPathInfo().contains("logout")) {
            req.logout();
            resp.sendRedirect(req.getContextPath() + "/" + realm);
            return;
        }

        KeycloakPrincipal principal = (KeycloakPrincipal) req.getUserPrincipal();

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        writer.write("Realm: ");
        writer.write(principal.getKeycloakSecurityContext().getRealm());

        writer.write("<br/>User: ");
        writer.write(principal.getKeycloakSecurityContext().getIdToken().getPreferredUsername());

        writer.write(String.format("<br/><a href=\"/multitenant/%s/logout\">Logout</a>", realm));
    }
 }
