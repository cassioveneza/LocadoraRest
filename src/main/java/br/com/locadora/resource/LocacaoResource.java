package br.com.locadora.resource;

import br.com.locadora.dto.LocacaoDto;
import br.com.locadora.model.Locacao;
import br.com.locadora.model.LocacaoRepository;
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

@Path("locacoes")
@Stateless
public class LocacaoResource extends AbstractResource {

    @Inject
    private LocacaoRepository locacaoRepository;
    @Inject
    private LocacaoDto.DtoBuilder locacaoDtoBuilder;

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") long id) {
        final Locacao locacao = locacaoRepository.find(id);
        if (locacao == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(locacaoDtoBuilder.toRepresentation(locacao)).build();
    }

    @GET
    public Response findAll() {
        final List<LocacaoDto> locacoes = locacaoDtoBuilder.toRepresentation(locacaoRepository.findAll());
        return Response.ok(locacoes).build();
    }

    @POST
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response create(LocacaoDto dto) {
        final Locacao locacao = locacaoDtoBuilder.fromRepresentation(dto);
        em.persist(locacao);
        return Response.created(null).entity(locacaoDtoBuilder.toRepresentation(locacao)).build();
    }

    @PUT
    @Path("{id}")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Response update(@PathParam("id") long id, LocacaoDto dto) {
        final Locacao locacao = locacaoDtoBuilder.fromRepresentation(dto);
        return Response.created(null).entity(locacaoDtoBuilder.toRepresentation(em.merge(locacao))).build();
    }

    @DELETE
    @Path("{id}")
    public Response remove(@PathParam("id") long id) {
        locacaoRepository.removeById(id);
        return Response.noContent().build();
    }

}
