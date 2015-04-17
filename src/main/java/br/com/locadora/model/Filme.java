package br.com.locadora.model;

import br.com.locadora.util.AbstractModel;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "FILMES")
public class Filme implements AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "NOME")
    private String nome;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "GENERO")
    private Genero genero;

    @NotNull
    @Column(name = "PRECO")
    private BigDecimal precoUnitario;

    private Filme() {
    }

    @Override
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

    public static class Builder {

        private final Filme filme;

        private Builder() {
            this.filme = new Filme();
        }

        private Builder(Filme filme) {
            this.filme = filme;
        }

        public static Builder create() {
            return new Builder();
        }

        public Filme build() {
            return filme;
        }

        public Builder id(Long id) {
            filme.setId(id);
            return this;
        }

        public Builder nome(String nome) {
            filme.setNome(nome);
            return this;
        }

        public Builder genero(Genero genero) {
            filme.setGenero(genero);
            return this;
        }

        public Builder precoUnitario(BigDecimal precoUnitario) {
            filme.setPrecoUnitario(precoUnitario);
            return this;
        }
    }
}
