package br.com.locadora.resource;

import java.util.List;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import br.com.locadora.dto.LocacaoDto;
import br.com.locadora.model.Locacao;
import br.com.locadora.util.AbstractResource;

@Produces("application/json")
@Consumes("application/json")
@Stateless
@Path("locacoes")
public class LocacaoResource extends AbstractResource<Locacao, LocacaoDto> {

    public LocacaoResource() {
        super(Locacao.class);
    }

    @GET
    @Path("{id}")
    public LocacaoDto find(@PathParam("id") Long id) {
        final Locacao locacao = super.find(id);
        final LocacaoDto locacaoDto = new LocacaoDto().toRepresentation(locacao);
        return locacaoDto;
    }

    @GET
    public List<Locacao> findAll() {
        return super.findAll();
    }

    @POST
    @Override
    public LocacaoDto create(LocacaoDto dto) {
        final Locacao locacao = dto.fromRepresentation();
        em.persist(locacao);
        return dto.toRepresentation(locacao);
    }

    @PUT
    @Path("{id}")
    public LocacaoDto update(@PathParam("id") Long id, LocacaoDto dto) {
        final Locacao locacao = dto.fromRepresentation();
        return dto.toRepresentation(em.merge(locacao));
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.removeById(id);
    }

}
