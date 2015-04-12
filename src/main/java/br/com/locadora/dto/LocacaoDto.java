package br.com.locadora.dto;

import br.com.locadora.model.Cliente;
import br.com.locadora.model.ItemLocacao;
import br.com.locadora.model.Locacao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LocacaoDto {

    @NotNull
    private long id;
    @NotNull
    private LocalDate data;
    @NotNull
    private ClienteDto cliente;
    @NotNull
    private List<ItemLocacaoDto> itens;

    public LocacaoDto() {
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    private void setData(LocalDate data) {
        this.data = data;
    }

    public ClienteDto getCliente() {
        return cliente;
    }

    private void setCliente(ClienteDto cliente) {
        this.cliente = cliente;
    }

    public List<ItemLocacaoDto> getItens() {
        return itens;
    }

    private void adicionaItem(ItemLocacaoDto item) {
        this.itens.add(item);
    }

    private void removeItem(ItemLocacaoDto item) {
        this.itens.remove(item);
    }

    public static class DtoBuilder {

        @Inject
        private ClienteDto.DtoBuilder clienteDtoBuilder;
        @Inject
        private ItemLocacaoDto.DtoBuilder itemDtoBuilder;

        private static LocacaoDto locacaoDto;

        private DtoBuilder() {
            this.locacaoDto = new LocacaoDto();
        }

        private DtoBuilder(LocacaoDto locacaoDto) {
            this.locacaoDto = locacaoDto;
        }

        public static DtoBuilder create() {
            return new DtoBuilder();
        }

        public static DtoBuilder from(LocacaoDto locacao) {
            return new DtoBuilder(locacao);
        }

        public LocacaoDto build() {
            return locacaoDto;
        }

        public DtoBuilder id(long id) {
            locacaoDto.setId(id);
            return this;
        }

        public DtoBuilder data(LocalDate data) {
            locacaoDto.setData(data);
            return this;
        }

        public DtoBuilder cliente(Cliente cliente) {
            locacaoDto.setCliente(clienteDtoBuilder.toRepresentation(cliente));
            return this;
        }

        public DtoBuilder adicionaItem(ItemLocacao item) {
            locacaoDto.adicionaItem(itemDtoBuilder.toRepresentation(item));
            return this;
        }

        public DtoBuilder removeItem(ItemLocacao item) {
            locacaoDto.removeItem(itemDtoBuilder.toRepresentation(item));
            return this;
        }

        public LocacaoDto toRepresentation(Locacao locacao) {
            final DtoBuilder locacaoDtoBuilder = LocacaoDto.DtoBuilder.create()
                    .id(locacao.getId())
                    .data(locacao.getData())
                    .cliente(locacao.getCliente());

            //TODO Refatorar
//            for (ItemLocacaoDto item : locacaoDto.getItens()) {
//                locacaoDtoBuilder.removeItem(item);
//            }
//            for (ItemLocacao item : locacao.getItensLocacao()) {
//                locacaoDtoBuilder.adicionaItem(item);
//            }
            return locacaoDtoBuilder.build();
        }

        public Locacao fromRepresentation(LocacaoDto dto) {
            final Locacao.Builder locacaoBuilder = Locacao.Builder.create()
                    .id(dto.getId())
                    .data(dto.getData());
//                .cliente(clienteDtoBuilder.fromRepresentation(dto.getCliente()));

            //TODO Itens
            return locacaoBuilder.build();
        }

        public List<LocacaoDto> toRepresentation(List<Locacao> lista) {
            final List<LocacaoDto> listaDto = new ArrayList<>();
            lista.stream().forEach(registro -> {
                listaDto.add(this.toRepresentation(registro));
            });
            return listaDto;
        }
    }
}
