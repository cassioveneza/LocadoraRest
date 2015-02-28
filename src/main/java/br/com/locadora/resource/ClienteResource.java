package br.com.locadora.resource;

import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import br.com.locadora.dto.ClienteDto;
import br.com.locadora.model.Cliente;
import br.com.locadora.util.AbstractResource;

@Produces("application/json")
@Consumes("application/json")
@Stateless
@Path("clientes")
public class ClienteResource extends AbstractResource<Cliente, ClienteDto> {

    public ClienteResource() {
        super(Cliente.class);
    }

    @GET
    @Path("{id}")
    public Cliente find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    public List<Cliente> findAll() {
        return super.findAll();
    }

    @POST
    @Override
    public ClienteDto create(ClienteDto dto) {
        final Cliente cliente = dto.fromRepresentation();
        em.persist(cliente);
        return dto.toRepresentation(cliente);
    }

    @PUT
    @Path("{id}")
    public ClienteDto update(@PathParam("id") Long id, ClienteDto dto) {
        final Cliente cliente = dto.fromRepresentation();
        return dto.toRepresentation(em.merge(cliente));
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.removeById(id);
    }

}
