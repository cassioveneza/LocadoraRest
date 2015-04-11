package br.com.locadora.dto;

import br.com.locadora.model.Filme;
import br.com.locadora.model.Genero;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FilmeDto {

    @NotNull
    private long id;
    @NotNull
    private String nome;
    @NotNull
    private Genero genero;
    @NotNull
    private BigDecimal precoUnitario;

    public FilmeDto() {
    }

    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public Genero getGenero() {
        return genero;
    }

    private void setGenero(Genero genero) {
        this.genero = genero;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    private void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public static class DtoBuilder {

        private static FilmeDto filmeDto;

        private DtoBuilder() {
            this.filmeDto = new FilmeDto();
        }

        private DtoBuilder(FilmeDto filmeDto) {
            this.filmeDto = filmeDto;
        }

        public static DtoBuilder create() {
            return new DtoBuilder();
        }

        public static DtoBuilder from(FilmeDto filme) {
            return new DtoBuilder(filme);
        }

        public FilmeDto build() {
            return filmeDto;
        }

        public DtoBuilder id(long id) {
            filmeDto.setId(id);
            return this;
        }

        public DtoBuilder nome(String nome) {
            filmeDto.setNome(nome);
            return this;
        }

        public DtoBuilder genero(Genero genero) {
            filmeDto.setGenero(genero);
            return this;
        }

        public DtoBuilder precoUnitario(BigDecimal precoUnitario) {
            filmeDto.setPrecoUnitario(precoUnitario);
            return this;
        }
    }

    public FilmeDto toRepresentation(Filme filme) {
        return FilmeDto.DtoBuilder.create()
                .id(filme.getId())
                .nome(filme.getNome())
                .genero(filme.getGenero())
                .precoUnitario(filme.getPrecoUnitario())
                .build();
    }

    public Filme fromRepresentation(FilmeDto dto) {
        return Filme.Builder.create()
                .id(dto.getId())
                .nome(dto.getNome())
                .genero(dto.getGenero())
                .precoUnitario(dto.getPrecoUnitario())
                .build();
    }

    public List<FilmeDto> toRepresentation(List<Filme> lista) {
        final List<FilmeDto> listaDto = new ArrayList<>();
        lista.stream().forEach(registro -> {
            listaDto.add(this.toRepresentation(registro));
        });
        return listaDto;
    }

}
