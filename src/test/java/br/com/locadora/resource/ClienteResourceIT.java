package br.com.locadora.resource;

import br.com.locadora.dto.ClienteDto;
import br.com.locadora.model.Cliente;
import java.net.MalformedURLException;
import java.net.URI;
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

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class).
                addClasses(Cliente.class, ClienteDto.class, ClienteResource.class);
    }

    @BeforeClass
    public void before() throws MalformedURLException {
        target = ClientBuilder.newClient().target(URI.create("http://localhost:8080/app/webresources/clientes"));
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

        final Entity<ClienteDto> entity = Entity.entity(clienteDto, MediaType.APPLICATION_JSON);

        Response response = target.request().post(entity, Response.class);
        Assert.assertEquals(response.getStatus(), 201);
    }

}
