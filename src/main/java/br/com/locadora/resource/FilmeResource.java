package br.com.locadora.resource;

import br.com.locadora.dto.FilmeDto;
import br.com.locadora.model.Filme;
import br.com.locadora.model.FilmeRepository;
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

@Path("filmes")
@Stateless
public class FilmeResource extends AbstractResource {

    @Inject
    private FilmeRepository filmeRepository;
    @Inject
    private FilmeDto filmeDto;

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") long id) {
        final Filme filme = filmeRepository.find(id);
        if (filme == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(filmeDto.toRepresentation(filme)).build();
    }

    @GET
    public Response findAll() {
        final List<FilmeDto> filmes = filmeDto.toRepresentation(filmeRepository.findAll());
        return Response.ok(filmes).build();
    }

    @POST
    public Response create(FilmeDto dto) {
        final Filme filme = filmeDto.fromRepresentation(dto);
        em.persist(filme);
        return Response.created(null).entity(filmeDto.toRepresentation(filme)).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") long id, FilmeDto dto) {
        final Filme filme = filmeDto.fromRepresentation(dto);
        return Response.created(null).entity(filmeDto.toRepresentation(em.merge(filme))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") long id) {
        filmeRepository.removeById(id);
        return Response.noContent().build();
    }

}
