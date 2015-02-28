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

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Filme setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public Genero getGenero() {
        return genero;
    }

    public Filme setGenero(Genero genero) {
        this.genero = genero;
        return this;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public Filme setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
        return this;
    }

}
