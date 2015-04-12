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
    private FilmeDto.DtoBuilder filmeDtoBuilder;

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id) {
        final Filme filme = filmeRepository.find(id);
        if (filme == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(filmeDtoBuilder.toRepresentation(filme)).build();
    }

    @GET
    public Response findAll() {
        final List<FilmeDto> filmes = filmeDtoBuilder.toRepresentation(filmeRepository.findAll());
        return Response.ok(filmes).build();
    }

    @POST
    public Response create(FilmeDto dto) {
        final Filme filme = filmeDtoBuilder.fromRepresentation(dto);
        em.persist(filme);
        return Response.created(null).entity(filmeDtoBuilder.toRepresentation(filme)).build();
    }

    @PUT
    @Path("{id}")
    public Response update(@PathParam("id") Long id, FilmeDto dto) {
        final Filme filme = filmeDtoBuilder.fromRepresentation(dto);
        return Response.created(null).entity(filmeDtoBuilder.toRepresentation(em.merge(filme))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") Long id) {
        filmeRepository.removeById(id);
        return Response.noContent().build();
    }

}
