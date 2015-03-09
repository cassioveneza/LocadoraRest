package br.com.locadora.dto;

import br.com.locadora.model.Cliente;
import br.com.locadora.util.AbstractDto;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ItemLocacaoDto /* implements AbstractDto<Cliente, ItemLocacaoDto>*/ {
/*
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

    public ItemLocacaoDto setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public ItemLocacaoDto setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getTelefone() {
        return telefone;
    }

    public ItemLocacaoDto setTelefone(String telefone) {
        this.telefone = telefone;
        return this;
    }

    public String getEndereco() {
        return endereco;
    }

    public ItemLocacaoDto setEndereco(String endereco) {
        this.endereco = endereco;
        return this;
    }

    public ItemLocacaoDto toRepresentation(Cliente entity) {
        return new ItemLocacaoDto()
                .setId(id)
                .setNome(entity.getNome())
                .setTelefone(entity.getTelefone())
                .setEndereco(entity.getEndereco());
    }

    public Cliente fromRepresentation(ItemLocacaoDto dto) {
        return new Cliente()
                .setNome(this.getNome())
                .setTelefone(this.getTelefone())
                .setEndereco(this.getEndereco());
    }
*/
}
