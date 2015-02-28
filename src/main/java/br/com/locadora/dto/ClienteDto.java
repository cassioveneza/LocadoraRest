package br.com.locadora.dto;

import br.com.locadora.model.Cliente;
import br.com.locadora.util.AbstractDto;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteDto implements AbstractDto<Cliente, ClienteDto> {

    @NotNull
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private String telefone;
    @NotNull
    private String endereco;

    public Long getId() {
        return id;
    }

    public ClienteDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public ClienteDto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public ClienteDto setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public ClienteDto setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public ClienteDto toRepresentation(Cliente entity) {
        return new ClienteDto()
                .setId(id)
                .setNome(entity.getNome())
                .setTelefone(entity.getTelefone())
                .setEndereco(entity.getEndereco());
    }

    public Cliente fromRepresentation() {
        return new Cliente()
                .setNome(this.getNome())
                .setTelefone(this.getTelefone())
                .setEndereco(this.getEndereco());
    }

}
