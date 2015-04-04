package br.com.locadora.resource;

import java.net.MalformedURLException;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public abstract class AbstractResourceIT {

    private final String URL_BASE = "http://localhost:8080/app/webresources";

    protected WebTarget target;
    protected Client client;

    protected void createTarget(String path) {
        
        try {
            client = ClientBuilder.newClient();
            target = client.target(URI.create(URL_BASE + path));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
