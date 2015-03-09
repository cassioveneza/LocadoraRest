package br.com.locadora.resource;

import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import br.com.locadora.dto.ClienteDto;
import br.com.locadora.model.Cliente;
import br.com.locadora.util.AbstractRepository;

@Produces("application/json")
@Consumes("application/json")
@Stateless
@Path("clientes")
public class ClienteResource extends AbstractRepository<Cliente> {

    private ClienteDto clienteDto;

    public ClienteResource() {
        super(Cliente.class);
        clienteDto = new ClienteDto();
    }

    @GET
    @Path("{id}")
    public ClienteDto find(@PathParam("id") Long id) {
        return clienteDto.toRepresentation(super.find(id));
    }

    @GET
    public List<ClienteDto> findAllDTO() {
        return clienteDto.toRepresentation(super.findAll());
    }

    @POST
    public ClienteDto create(ClienteDto dto) {
        final Cliente cliente = clienteDto.fromRepresentation(dto);
        em.persist(cliente);
        return clienteDto.toRepresentation(cliente);
    }

    @PUT
    @Path("{id}")
    public ClienteDto update(@PathParam("id") Long id, ClienteDto dto) {
        final Cliente cliente = clienteDto.fromRepresentation(dto);
        return clienteDto.toRepresentation(em.merge(cliente));
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.removeById(id);
    }

}
