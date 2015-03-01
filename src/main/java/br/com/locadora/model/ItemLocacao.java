package br.com.locadora.model;

import br.com.locadora.util.AbstractModel;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity(name = "ITENS_LOCACAO")
public class ItemLocacao implements AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "I_LOCACOES", nullable = false)
    private Locacao locacao;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "I_FILMES", nullable = false)
    private Filme filme;

    @Override
    public Long getId() {
        return id;
    }

    public Locacao getLocacao() {
        return locacao;
    }

    public ItemLocacao setLocacao(Locacao locacao) {
        this.locacao = locacao;
        return this;
    }

    public Filme getFilme() {
        return filme;
    }

    public ItemLocacao setFilme(Filme filme) {
        this.filme = filme;
        return this;
    }

}
