package br.com.locadora.dto;

import br.com.locadora.model.Cliente;
import br.com.locadora.util.AbstractDto;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteDto extends AbstractDto<Cliente, ClienteDto> {

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

    public static class DtoBuilder {

        private final ClienteDto clienteDto;

        private DtoBuilder() {
            clienteDto = new ClienteDto();
        }

        public static DtoBuilder create() {
            return new DtoBuilder();
        }

        public ClienteDto build() {
            return clienteDto;
        }

        public DtoBuilder id(Long id) {
            clienteDto.setId(id);
            return this;
        }

        public DtoBuilder nome(String nome) {
            clienteDto.setNome(nome);
            return this;
        }

        public DtoBuilder telefone(String telefone) {
            clienteDto.setTelefone(telefone);
            return this;
        }

        public DtoBuilder endereco(String endereco) {
            clienteDto.setEndereco(endereco);
            return this;
        }
    }

    @Override
    public ClienteDto toRepresentation(Cliente cliente) {
        return ClienteDto.DtoBuilder.create()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .telefone(cliente.getTelefone())
                .endereco(cliente.getEndereco())
                .build();
    }

    @Override
    public Cliente fromRepresentation(ClienteDto dto) {
        return Cliente.Builder.create()
                .nome(dto.getNome())
                .telefone(dto.getTelefone())
                .endereco(dto.getEndereco())
                .build();
    }

}
