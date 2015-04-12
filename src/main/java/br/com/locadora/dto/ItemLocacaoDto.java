package br.com.locadora.dto;

import br.com.locadora.model.Filme;
import br.com.locadora.model.ItemLocacao;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemLocacaoDto {

    @NotNull
    private Filme filme;
    @NotNull
    private LocalDate dataDevolucao;

    public ItemLocacaoDto() {
    }

    public Filme getFilme() {
        return filme;
    }

    private void setFilme(Filme filme) {
        this.filme = filme;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    private void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public static class DtoBuilder {

        private static ItemLocacaoDto itemDto;

        private DtoBuilder() {
            this.itemDto = new ItemLocacaoDto();
        }

        private DtoBuilder(ItemLocacaoDto itemDto) {
            this.itemDto = itemDto;
        }

        public DtoBuilder filme(Filme filme) {
            itemDto.setFilme(filme);
            return this;
        }

        public DtoBuilder dataDevolucao(LocalDate dataDevolucao) {
            itemDto.setDataDevolucao(dataDevolucao);
            return this;
        }

        public static DtoBuilder create() {
            return new DtoBuilder();
        }

        public static DtoBuilder from(ItemLocacaoDto itemDto) {
            return new DtoBuilder(itemDto);
        }

        public ItemLocacaoDto build() {
            return itemDto;
        }

        public ItemLocacaoDto toRepresentation(ItemLocacao item) {
            return ItemLocacaoDto.DtoBuilder.create()
                    .filme(item.getFilme())
                    .dataDevolucao(item.getDataDevolucao())
                    .build();
        }

        public ItemLocacao fromRepresentation(ItemLocacaoDto dto) {
            return ItemLocacao.Builder.create()
                    .filme(dto.getFilme())
                    .dataDevolucao(dto.getDataDevolucao())
                    .build();
        }

        public List<ItemLocacaoDto> toRepresentation(List<ItemLocacao> lista) {
            final List<ItemLocacaoDto> listaDto = new ArrayList<>();
            lista.stream().forEach(registro -> {
                listaDto.add(this.toRepresentation(registro));
            });
            return listaDto;
        }
    }
}
