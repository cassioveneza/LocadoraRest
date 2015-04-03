package br.com.locadora.resource;

import br.com.locadora.dto.ClienteDto;
import br.com.locadora.model.Cliente;
import java.net.MalformedURLException;
import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ClienteResourceIT {

    private static WebTarget target;
    private static Client client;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class).
                addClasses(Cliente.class, ClienteDto.class, ClienteResource.class);
    }

    @BeforeClass
    public void before() throws MalformedURLException {
        client = ClientBuilder.newClient();
        target = client.target(URI.create("http://localhost:8080/app/webresources/clientes"));
    }

    @Test
    @RunAsClient
    public void testMethods() throws Exception {

        final String nome = "JOAO SILVA";
        final String telefone = "9944-5588";
        final String endereco = "RUA GERAL";

        //POST
        final ClienteDto clienteDto = ClienteDto.DtoBuilder.create()
                .nome(nome)
                .telefone(telefone)
                .endereco(endereco)
                .build();

        Response response = target.request().post(Entity.entity(clienteDto, MediaType.APPLICATION_JSON), Response.class);
        Assert.assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());

        Cliente clienteResponse = response.readEntity(Cliente.class);
        Assert.assertNotNull(clienteResponse);

        //GET ALL
        response = target.request().get();
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

        //PUT
        final String nomeAlterado = "JOAO DA SILVA E SILVA";
        ClienteDto clienteAlterado = ClienteDto.DtoBuilder.from(clienteDto.toRepresentation(clienteResponse))
                .nome(nomeAlterado)
                .build();

        target = client.target(target.getUriBuilder()).path("/" + clienteResponse.getId());
        response = target.request().put(Entity.entity(clienteAlterado, MediaType.APPLICATION_JSON));
        Assert.assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());

        Cliente clienteResponseUpdated = response.readEntity(Cliente.class);
        Assert.assertNotNull(clienteResponseUpdated);
        Assert.assertEquals(clienteResponseUpdated.getNome(), nomeAlterado);

        //DELETE
        response = target.request().delete();
        Assert.assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());

        //GET
        response = target.request().get();
        Assert.assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode());
    }

}
