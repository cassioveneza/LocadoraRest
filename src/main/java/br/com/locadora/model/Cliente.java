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

    private Cliente() {
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

    public String getTelefone() {
        return telefone;
    }

    private void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    private void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public static class Builder {
        private final Cliente cliente;
        
        private Builder() {
            this.cliente = new Cliente();
        }

        private Builder(Cliente cliente) {
            this.cliente = cliente;
        }

        public static Builder create() {
            return new Builder();
        }
        
        public static Builder from(Cliente cliente) {
            return new Builder(cliente);
        }

        public Cliente build() {
            return cliente;
        }

        public Builder id(Long id) {
            cliente.setId(id);
            return this;
        }

        public Builder nome(String nome) {
            cliente.setNome(nome);
            return this;
        }

        public Builder telefone(String telefone) {
            cliente.setTelefone(telefone);
            return this;
        }

        public Builder endereco(String endereco) {
            cliente.setEndereco(endereco);
            return this;
        }
    }
}
