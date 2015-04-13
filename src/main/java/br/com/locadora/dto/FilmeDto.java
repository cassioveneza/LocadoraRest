package br.com.locadora.dto;

import br.com.locadora.model.Filme;
import br.com.locadora.model.Genero;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FilmeDto {

    private Long id;

    private String nome;

    private Genero genero;

    private BigDecimal precoUnitario;

    public FilmeDto() {
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
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

        private FilmeDto filmeDto;

        private DtoBuilder() {
            this.filmeDto = new FilmeDto();
        }

        private DtoBuilder(FilmeDto filmeDto) {
            this.filmeDto = filmeDto;
        }

        public DtoBuilder id(Long id) {
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

        public static DtoBuilder create() {
            return new DtoBuilder();
        }

        public static DtoBuilder from(FilmeDto filmeDto) {
            return new DtoBuilder(filmeDto);
        }

        public FilmeDto build() {
            return filmeDto;
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
}
