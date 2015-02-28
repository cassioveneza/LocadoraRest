package br.com.locadora.model;

import br.com.locadora.util.AbstractModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity(name = "CLIENTES")
public class Cliente implements AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "NOME")
    private String nome;

    @NotNull
    @Column(name = "TELEFONE")
    private String telefone;

    @NotNull
    @Column(name = "ENDERECO")
    private String endereco;

    @Override
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Cliente setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public Cliente setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public Cliente setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

}
