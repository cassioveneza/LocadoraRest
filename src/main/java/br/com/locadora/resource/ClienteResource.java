package br.com.locadora.resource;

import br.com.locadora.dto.ClienteDto;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.ClienteRepository;
import br.com.locadora.util.AbstractResource;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

@Path("clientes")
@Stateless
public class ClienteResource extends AbstractResource {

    @Inject
    private ClienteRepository clienteRepository;
    @Inject
    private ClienteDto.DtoBuilder clienteDtoBuilder;

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") long id) {
        final Cliente cliente = clienteRepository.find(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(clienteDtoBuilder.toRepresentation(cliente)).build();
    }

    @GET
    public Response findAll() {
        final List<ClienteDto> clientes = clienteDtoBuilder.toRepresentation(clienteRepository.findAll());
        return Response.ok(clientes).build();
    }

    @POST
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response create(ClienteDto dto) {
        final Cliente cliente = clienteDtoBuilder.fromRepresentation(dto);
        em.persist(cliente);
        return Response.created(null).entity(clienteDtoBuilder.toRepresentation(cliente)).build();
    }

    @PUT
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Path("{id}")
    public Response update(@PathParam("id") long id, ClienteDto dto) {
        final Cliente cliente = clienteDtoBuilder.fromRepresentation(dto);
        return Response.created(null).entity(clienteDtoBuilder.toRepresentation(em.merge(cliente))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") long id) {
        clienteRepository.removeById(id);
        return Response.noContent().build();
    }

}
