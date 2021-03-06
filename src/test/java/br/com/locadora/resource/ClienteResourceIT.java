package br.com.locadora.resource;

import br.com.locadora.dto.ClienteDto;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.ClienteRepository;
import br.com.locadora.model.Sexo;
import br.com.locadora.util.AbstractResourceIT;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ClienteResourceIT extends AbstractResourceIT {

    @Deployment
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addPackage(Cliente.class.getPackage())
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Override
    public String getURI() {
        return Api.Clientes.SELF;
    }

    @Test
    @RunAsClient
    public void testMethods() throws Exception {

        final String nome = "JOAO SILVA";
        final Sexo sexo = Sexo.MASCULINO;
        final String telefone = "9944-5588";
        final String endereco = "RUA GERAL";

        //POST
        final ClienteDto clienteDto = ClienteDto.RepresentationBuilder.builder()
                .nome(nome)
                .sexo(sexo)
                .telefone(telefone)
                .endereco(endereco)
                .build();

        Response response = target.request().post(Entity.entity(clienteDto, MediaType.APPLICATION_JSON), Response.class);
        Assert.assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());

        Cliente clienteCreated = response.readEntity(Cliente.class);
        Assert.assertNotNull(clienteCreated);

        //GET ALL
        response = target.request().get();
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

        //PUT
        final String nomeAlterado = "JOAO DA SILVA E SILVA";
        Cliente clienteAlterado = Cliente.Builder.from(clienteCreated)
                .nome(nomeAlterado)
                .build();

        //TODO: Ajustar para buscar pelo parametro {id}
        WebTarget targetResource = target.path(clienteCreated.getId().toString());

        response = targetResource.request().put(Entity.entity(clienteAlterado, MediaType.APPLICATION_JSON));
        Assert.assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());

        Cliente clienteResponseUpdated = response.readEntity(Cliente.class);
        Assert.assertNotNull(clienteResponseUpdated);
        Assert.assertEquals(clienteResponseUpdated.getNome(), nomeAlterado);

        //DELETE
        response = targetResource.request().delete();
        Assert.assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());

        //GET
        response = targetResource.request().get();
        Assert.assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode());
    }

}
