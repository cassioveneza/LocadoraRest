package br.com.locadora.model;

import br.com.locadora.util.AbstractModel;
import br.com.locadora.util.JsonDateDeserializer;
import br.com.locadora.util.JsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity(name = "LOCACOES")
public class Locacao implements AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @Column(name = "DATA_LOCACAO")
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "I_CLIENTES")
    private Cliente cliente;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "locacao")
    private List<ItemLocacao> itens = new ArrayList<>();

    @Override
    public long getId() {
        return id;
    }
    
    private void setId(long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    private void setData(LocalDate data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    private void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemLocacao> getItensLocacao() {
        return itens;
    }

    private void adicionaItem(ItemLocacao item) {
        this.itens.add(item);
    }

    private void removeItem(ItemLocacao item) {
        this.itens.remove(item);
    }

    public static class Builder {

        private final Locacao locacao;

        private Builder() {
            this.locacao = new Locacao();
        }

        private Builder(Locacao locacao) {
            this.locacao = locacao;
        }

        public static Builder create() {
            return new Builder();
        }

        public static Builder from(Locacao locacao) {
            return new Builder(locacao);
        }

        public Locacao build() {
            return locacao;
        }

        public Builder id(long id) {
            locacao.setId(id);
            return this;
        }

        public Builder data(LocalDate data) {
            locacao.setData(data);
            return this;
        }

        public Builder cliente(Cliente cliente) {
            locacao.setCliente(cliente);
            return this;
        }

        public Builder adicionaItem(ItemLocacao item) {
            locacao.adicionaItem(item);
            return this;
        }
        
        public Builder removeItem(ItemLocacao item) {
            locacao.removeItem(item);
            return this;
        }

    }
}
