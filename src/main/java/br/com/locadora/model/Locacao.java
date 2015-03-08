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
    private Long id;

    @JsonDeserialize(using = JsonDateDeserializer.class)
    @JsonSerialize(using = JsonDateSerializer.class)
    @Column(name = "DATA_LOCACAO")
    private LocalDate data;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "I_CLIENTES")
    private Cliente cliente;

    @Transient
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "locacao")
    private List<ItemLocacao> itens = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public Locacao setData(LocalDate data) {
        this.data = data;
        return this;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Locacao setCliente(Cliente cliente) {
        this.cliente = cliente;
        return this;
    }

    public List<ItemLocacao> getItensLocacao() {
        return itens;
    }

    public Locacao adicionaItemLocacao(ItemLocacao item) {
        this.itens.add(item);
        return this;
    }

    public Locacao removeItemLocacao(ItemLocacao item) {
        this.itens.remove(item);
        return this;
    }

}
