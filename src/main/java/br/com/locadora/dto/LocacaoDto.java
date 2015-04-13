package br.com.locadora.dto;

import br.com.locadora.model.Locacao;
import br.com.locadora.util.JsonDateDeserializer;
import br.com.locadora.util.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class LocacaoDto {

    private Long id;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    private LocalDate data;

    private ClienteDto cliente;

    private String observacao;

    private List<ItemLocacaoDto> itens;

    public LocacaoDto() {
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
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

    public String getObservacao() {
        return observacao;
    }

    private void setObservacao(String observacao) {
        this.observacao = observacao;
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

        private LocacaoDto locacaoDto;

        private DtoBuilder() {
            this.locacaoDto = new LocacaoDto();
        }

        private DtoBuilder(LocacaoDto locacaoDto) {
            this.locacaoDto = locacaoDto;
        }

        public DtoBuilder id(Long id) {
            locacaoDto.setId(id);
            return this;
        }

        public DtoBuilder observacao(String observacao) {
            locacaoDto.setObservacao(observacao);
            return this;
        }

        public DtoBuilder data(LocalDate data) {
            locacaoDto.setData(data);
            return this;
        }

        public DtoBuilder cliente(ClienteDto clienteDto) {
            locacaoDto.setCliente(clienteDto);
            return this;
        }

        public DtoBuilder adicionaItem(ItemLocacaoDto itemDto) {
            locacaoDto.adicionaItem(itemDto);
            return this;
        }

        public DtoBuilder removeItem(ItemLocacaoDto itemDto) {
            locacaoDto.removeItem(itemDto);
            return this;
        }

        public static DtoBuilder create() {
            return new DtoBuilder();
        }

        public static DtoBuilder from(LocacaoDto locacaoDto) {
            return new DtoBuilder(locacaoDto);
        }

        public LocacaoDto build() {
            return locacaoDto;
        }

        public LocacaoDto toRepresentation(Locacao locacao) {
            final DtoBuilder locacaoDtoBuilder = LocacaoDto.DtoBuilder.create()
                    .id(locacao.getId())
                    .data(locacao.getData())
                    //                    .cliente(locacao.getCliente())
                    .observacao(locacao.getObservacao());

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
                    .data(dto.getData())
                    //                    .cliente(dto.getCliente())
                    .observacao(dto.getObservacao());

            //TODO Itens
            return locacaoBuilder.build();
        }

        public List<LocacaoDto> toRepresentation(List<Locacao> lista) {
            final List<LocacaoDto> listaDto = new ArrayList<>();
            lista.stream().forEach(registro -> {
                listaDto.add(toRepresentation(registro));
            });
            return listaDto;
        }
    }
}
