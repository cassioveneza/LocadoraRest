package br.com.locadora.dto;

import br.com.locadora.model.Filme;
import br.com.locadora.model.Genero;
import br.com.locadora.util.AbstractDto;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class FilmeDto /*implements AbstractDto<Filme, FilmeDto>*/ {
/*
    @NotNull
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private Genero genero;
    @NotNull
    private BigDecimal precoUnitario;

    public Long getId() {
        return id;
    }

    public FilmeDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public FilmeDto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Genero getGenero() {
        return genero;
    }

    public FilmeDto setGenero(Genero genero) {
        this.genero = genero;
        return this;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public FilmeDto setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
        return this;
    }

    public FilmeDto toRepresentation(Filme entity) {
        return new FilmeDto()
                .setId(id)
                .setNome(entity.getNome())
                .setGenero(entity.getGenero())
                .setPrecoUnitario(entity.getPrecoUnitario());
    }

    public Filme fromRepresentation(FilmeDto dto) {
        return new Filme()
                .setNome(this.getNome())
                .setGenero(this.getGenero())
                .setPrecoUnitario(this.getPrecoUnitario());
    }
*/
}
