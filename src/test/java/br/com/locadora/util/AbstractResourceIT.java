package br.com.locadora.util;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import org.testng.annotations.BeforeClass;

public abstract class AbstractResourceIT {

    protected Client client;

    @BeforeClass
    protected void createClient() {
        client = ClientBuilder.newClient();
    }

}
