package br.com.locadora.resource;

import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import br.com.locadora.dto.FilmeDto;
import br.com.locadora.model.Filme;
import br.com.locadora.util.AbstractResource;

@Produces("application/json")
@Consumes("application/json")
@Stateless
@Path("filmes")
public class FilmeResource extends AbstractResource<Filme, FilmeDto> {

    public FilmeResource() {
        super(Filme.class);
    }

    @GET
    @Path("{id}")
    public Filme find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    public List<Filme> findAll() {
        return super.findAll();
    }

    @POST
    @Override
    public FilmeDto create(FilmeDto dto) {
        final Filme filme = dto.fromRepresentation();
        em.persist(filme);
        return dto.toRepresentation(filme);
    }

    @PUT
    @Path("{id}")
    public FilmeDto update(@PathParam("id") Long id, FilmeDto dto) {
        final Filme filme = dto.fromRepresentation();
        return dto.toRepresentation(em.merge(filme));
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.removeById(id);
    }

}
