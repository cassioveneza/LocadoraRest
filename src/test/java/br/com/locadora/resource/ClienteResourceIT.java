package br.com.locadora.resource;

import br.com.locadora.dto.ClienteDto;
import br.com.locadora.model.Cliente;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.hibernate.boot.model.relational.Database;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClienteResourceIT {

//    private final String URL = "http://localhost:8080/app/webresources/clientes";
    private static WebTarget target;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class).
                addClass(ClienteDto.class).
                addClass(Database.class);
    }

    @ArquillianResource
    private URL base;

    @BeforeClass
    public void before() throws MalformedURLException {
        Client client = ClientBuilder.newClient();
//        target = client.target(URI.create(new URL(base, "webresources/clientes").toExternalForm()));
        target = client.target(URI.create("http://localhost:8080/app/webresources/clientes"));
    }

    @AfterClass
    public static void after() {
//        client.close();
    }

    @Test
    @RunAsClient
    public void testCreate() throws Exception {

        final String nome = "JOAO SILVA";
        final String telefone = "9944-5588";
        final String endereco = "RUA GERAL";

        final ClienteDto clienteDto = ClienteDto.DtoBuilder.create()
                .nome(nome)
                .telefone(telefone)
                .endereco(endereco)
                .build();
        
        Response response = target.request().post(Entity.entity(clienteDto, MediaType.APPLICATION_JSON_TYPE));
//        Assert.assertEquals(response.getStatus(), 201);
//
//        Cliente clienteCreated = target.request().get(Cliente.class);
//        Assert.assertNotNull(clienteCreated);

    }

}
