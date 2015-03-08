package br.com.locadora.resource;

import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import br.com.locadora.dto.FilmeDto;
import br.com.locadora.model.Filme;
import br.com.locadora.model.FilmeRepository;
import javax.inject.Inject;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("filmes")
@Produces("application/json")
@Consumes("application/json")
@Stateless
public class FilmeResource {
    
//    @Inject
//    private FilmeRepository filmeRepository;

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id) {
//        final Filme filme = filmeRepository.find(id);
        final Filme filme = new FilmeRepository().find(id);
        return Response.ok(new FilmeDto().toRepresentation(filme), MediaType.APPLICATION_JSON).build();
    }

//    @GET
//    public List<Filme> findAll() {
//        return super.findAll();
//    }
//
//    @POST
//    @Override
//    public FilmeDto create(FilmeDto dto) {
//        final Filme filme = dto.fromRepresentation();
//        em.persist(filme);
//        return dto.toRepresentation(filme);
//    }
//
//    @PUT
//    @Path("{id}")
//    public FilmeDto update(@PathParam("id") Long id, FilmeDto dto) {
//        final Filme filme = dto.fromRepresentation();
//        return dto.toRepresentation(em.merge(filme));
//    }
//
//    @DELETE
//    @Path("{id}")
//    public void remove(@PathParam("id") Long id) {
//        super.removeById(id);
//    }

}
