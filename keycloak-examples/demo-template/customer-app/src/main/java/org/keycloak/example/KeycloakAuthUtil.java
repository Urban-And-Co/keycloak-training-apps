package org.keycloak.example;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import javax.servlet.http.HttpServletRequest;

public final class KeycloakAuthUtil {
  public static String getKeycloakUrl(HttpServletRequest req) {

    GsonBuilder builder = new GsonBuilder();

    try {
      InputStream in = req.getServletContext().getResourceAsStream("/WEB-INF/keycloak.json");
      Reader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
      JsonObject json = builder.create().fromJson(reader, JsonObject.class);
      return json.get("auth-server-url").getAsString();
    } catch (Exception e) {
      throw new RuntimeException(e);      
    }

  }
}
