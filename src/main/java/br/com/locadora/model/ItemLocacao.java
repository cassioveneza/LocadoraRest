package br.com.locadora.model;

import br.com.locadora.util.AbstractModel;
import java.time.LocalDate;
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
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "I_LOCACOES", nullable = false)
    private Locacao locacao;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "I_FILMES", nullable = false)
    private Filme filme;

    @NotNull
    @Column(name = "DATA_DEVOLUCAO")
    private LocalDate dataDevolucao;

    private ItemLocacao() {
    }
    
    @Override
    public long getId() {
        return id;
    }

    private void setId(long id) {
        this.id = id;
    }
    
    public Locacao getLocacao() {
        return locacao;
    }

    private void setLocacao(Locacao locacao) {
        this.locacao = locacao;
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

    public static class Builder {

        private final ItemLocacao itemLocacao;

        private Builder() {
            this.itemLocacao = new ItemLocacao();
        }

        private Builder(ItemLocacao itemLocacao) {
            this.itemLocacao = itemLocacao;
        }

        public static Builder create() {
            return new Builder();
        }

        public static Builder from(ItemLocacao itemLocacao) {
            return new Builder(itemLocacao);
        }

        public ItemLocacao build() {
            return itemLocacao;
        }

        public Builder id(long id) {
            itemLocacao.setId(id);
            return this;
        }
        
        public Builder locacao(Locacao locacao) {
            itemLocacao.setLocacao(locacao);
            return this;
        }

        public Builder filme(Filme filme) {
            itemLocacao.setFilme(filme);
            return this;
        }

        public Builder dataDevolucao(LocalDate dataDevolucao) {
            itemLocacao.setDataDevolucao(dataDevolucao);
            return this;
        }

    }
}
