package br.com.locadora.model;

import br.com.locadora.util.AbstractModel;
import javax.persistence.Column;
import javax.persistence.Entity;
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
    @Column(name = "GENERO")
    private String genero;

    @NotNull
    @Column(name = "PRECO")
    private Double precoUnitario;

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

    public String getGenero() {
        return genero;
    }

    public Filme setGenero(String genero) {
        this.genero = genero;
        return this;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public Filme setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
        return this;
    }

}
