package br.com.locadora.resource;

import br.com.locadora.dto.ClienteDto;
import br.com.locadora.util.AbstractResourceIT;
import br.com.locadora.dto.LocacaoDto;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.Locacao;
import br.com.locadora.model.Sexo;
import java.net.URI;
import java.time.LocalDate;
import java.time.Month;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.jboss.arquillian.container.test.api.RunAsClient;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class LocacaoResourceIT extends AbstractResourceIT {
//
//    private Cliente criarCliente(String nome) {
//        final Sexo sexo = Sexo.MASCULINO;
//        final String endereco = "RUA GERAL";
//
//        final ClienteDto clienteDto = ClienteDto.ClienteDtoBuilder.create()
//                .nome(nome)
//                .sexo(sexo)
//                .endereco(endereco)
//                .build();
//
//        WebTarget target = client.target(URI.create(Api.Clientes.SELF));
//        Response response = target.request().post(Entity.entity(clienteDto, MediaType.APPLICATION_JSON), Response.class);
//        Assert.assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());
//
//        Cliente clienteResponse = response.readEntity(Cliente.class);
//        Assert.assertNotNull(clienteResponse);
//
//        return clienteResponse;
//    }
//
//    @Test(enabled = false)
//    @RunAsClient
//    public void testMethods() throws Exception {
//
//        final LocalDate data = LocalDate.of(2014, Month.MARCH, 1);
//        final Cliente cliente = criarCliente("JOAO DA SILVA");
//        final String observacao = "LOCACAO PARA TESTES";
//
//        //POST
//        final LocacaoDto locacaoDto = LocacaoDto.DtoBuilder.create()
//                .data(data)
//                .cliente(cliente)
//                .observacao(observacao)
//                .build();
//
//        WebTarget target = client.target(URI.create(Api.Locacoes.SELF));
//        Response response = target.request().post(Entity.entity(locacaoDto, MediaType.APPLICATION_JSON), Response.class);
//        Assert.assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());
//
//        LocacaoDto locacaoResponse = response.readEntity(LocacaoDto.class);
//        Assert.assertNotNull(locacaoResponse);
//        Assert.assertNotNull(locacaoResponse.getId());
//        Assert.assertEquals(locacaoResponse.getCliente().getId(), cliente.getId());
//        Assert.assertEquals(locacaoResponse.getData(), data);
//        Assert.assertEquals(locacaoResponse.getObservacao(), observacao);
//
//        //GET ALL
//        response = target.request().get();
//        Assert.assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
//
//        //PUT
//        final String observacaoAlterada = "OBSERVACAO ALTERADA";
//
//        LocacaoDto locacaoAlterado = LocacaoDto.DtoBuilder.from(locacaoResponse)
//                .observacao(observacaoAlterada)
//                .build();
//
//        //TODO: Ajustar para buscar pelo parametro {id}
//        WebTarget targetResource = client.target(target.getUriBuilder()).path("/" + locacaoResponse.getId());
//
//        response = targetResource.request().put(Entity.entity(locacaoAlterado, MediaType.APPLICATION_JSON));
//        Assert.assertEquals(response.getStatus(), Response.Status.CREATED.getStatusCode());
//
//        Locacao locacaoResponseUpdated = response.readEntity(Locacao.class);
//        Assert.assertNotNull(locacaoResponseUpdated);
//        Assert.assertEquals(locacaoResponseUpdated.getCliente().getId(), cliente.getId());
//        Assert.assertEquals(locacaoResponseUpdated.getData(), data);
//        Assert.assertEquals(locacaoResponseUpdated.getObservacao(), observacaoAlterada);
//
//        //DELETE
//        response = targetResource.request().delete();
//        Assert.assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());
//
//        //GET
//        response = targetResource.request().get();
//        Assert.assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode());
//    }

}
