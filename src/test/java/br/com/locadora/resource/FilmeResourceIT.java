package br.com.locadora.resource;

import br.com.locadora.util.AbstractResourceIT;
import br.com.locadora.dto.FilmeDto;
import br.com.locadora.model.Filme;
import br.com.locadora.model.Genero;
import java.math.BigDecimal;
import java.net.URI;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class FilmeResourceIT extends AbstractResourceIT {

    @Test
    @RunAsClient
    public void testMethods() throws Exception {

        final String nome = "LAGOA AZUL";
        final Genero genero = Genero.DRAMA;
        final BigDecimal precoUnitario = BigDecimal.ONE;

        //POST
        final FilmeDto filmeDto = FilmeDto.DtoBuilder.create()
                .nome(nome)
                .genero(genero)
                .precoUnitario(precoUnitario)
                .build();

        WebTarget target = client.target(URI.create(Api.Filmes.SELF));
        final Entity<FilmeDto> entity = Entity.entity(filmeDto, MediaType.APPLICATION_JSON);
        Response response = target.request().post(entity, Response.class);
        Assert.assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());

        FilmeDto filmeResponse = response.readEntity(FilmeDto.class);
        Assert.assertNotNull(filmeResponse);

        //GET ALL
        response = target.request().get();
        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

        //PUT
        final String nomeAlterado = "DE VOLTA PARA A LAGOA AZUL";
        FilmeDto filmeAlterado = FilmeDto.DtoBuilder.from(filmeResponse)
                .nome(nomeAlterado)
                .build();

        //TODO: Ajustar para buscar pelo parametro {id}
        WebTarget targetResource = client.target(target.getUriBuilder()).path("/" + filmeResponse.getId());

        response = targetResource.request().put(Entity.entity(filmeAlterado, MediaType.APPLICATION_JSON));
        Assert.assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());

        Filme filmeResponseUpdated = response.readEntity(Filme.class);
        Assert.assertNotNull(filmeResponseUpdated);
        Assert.assertEquals(filmeResponseUpdated.getNome(), nomeAlterado);

        //DELETE
        response = targetResource.request().delete();
        Assert.assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());

        //GET
        response = targetResource.request().get();
        Assert.assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode());
    }

}
