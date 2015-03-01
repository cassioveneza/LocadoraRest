package br.com.locadora.dto;

import br.com.locadora.model.Cliente;
import br.com.locadora.model.ItemLocacao;
import br.com.locadora.model.Locacao;
import br.com.locadora.util.AbstractDto;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LocacaoDto implements AbstractDto<Locacao, LocacaoDto> {

    private Long id;
    private LocalDate data;
    private Cliente cliente;
    private List<ItemLocacao> itens = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public LocacaoDto setId(Long id) {
        this.id = id;
        return this;
    }

    public LocalDate getData() {
        return data;
    }

    public LocacaoDto setData(LocalDate data) {
        this.data = data;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocacaoDto setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public List<ItemLocacao> getItensLocacao() {
        return itens;
    }

    public LocacaoDto adicionaItemLocacao(ItemLocacao item) {
        this.itens.add(item);
        return this;
    }

    public LocacaoDto removeItemLocacao(ItemLocacao item) {
        this.itens.remove(item);
        return this;
    }

    @Override
    public LocacaoDto toRepresentation(Locacao entity) {
        final LocacaoDto locacao = new LocacaoDto()
                .setId(id)
                .setData(entity.getData())
                .setCliente(entity.getCliente());

//        entity.getItensLocacao().stream().forEach(
//                item -> locacao.adicionaItemLocacao(item)
//        );

        return locacao;
    }

    @Override
    public Locacao fromRepresentation() {
        final Locacao locacao = new Locacao()
                .setData(this.getData())
                .setCliente(this.getCliente());

//        getItensLocacao().stream().forEach(item
//                -> locacao.adicionaItemLocacao(item)
//        );

        return locacao;
    }

}
