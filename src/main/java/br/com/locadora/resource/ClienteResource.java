package br.com.locadora.resource;

import br.com.locadora.dto.ClienteDto;
import br.com.locadora.model.Cliente;
import br.com.locadora.model.ClienteRepository;
import br.com.locadora.util.AbstractResource;
import java.util.List;
import javax.ejb.Stateless;
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
    private ClienteDto clienteDto;

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id) {
        final Cliente cliente = clienteRepository.find(id);
        if (cliente == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(clienteDto.toRepresentation(cliente)).build();
    }

    @GET
    public Response findAll() {
        final List<ClienteDto> clientes = clienteDto.toRepresentation(clienteRepository.findAll());
        return Response.ok(clientes).build();
    }

    @POST
    public Response create(ClienteDto dto) {
        final Cliente cliente = clienteDto.fromRepresentation(dto);
        em.persist(cliente);
        return Response.created(null).entity(clienteDto.toRepresentation(cliente)).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, ClienteDto dto) {
        final Cliente cliente = clienteDto.fromRepresentation(dto);
        return Response.created(null).entity(clienteDto.toRepresentation(em.merge(cliente))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        clienteRepository.removeById(id);
        return Response.noContent().build();
    }

}
