package br.com.locadora.dto;

import br.com.locadora.model.Cliente;
import br.com.locadora.model.Sexo;
import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ClienteDto /*extends AbstractDto<Cliente, ClienteDto>*/ {

    @NotNull
    private Long id;
    @NotNull
    private String nome;
    @NotNull
    private Sexo sexo;
    private String telefone;
    @NotNull
    private String endereco;

    public ClienteDto() {
    }

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

    public Sexo getSexo() {
        return sexo;
    }

    private void setSexo(Sexo sexo) {
        this.sexo = sexo;
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

        private static ClienteDto clienteDto;

        private DtoBuilder() {
            this.clienteDto = new ClienteDto();
        }

        private DtoBuilder(ClienteDto clienteDto) {
            this.clienteDto = clienteDto;
        }

        public DtoBuilder id(Long id) {
            clienteDto.setId(id);
            return this;
        }

        public DtoBuilder nome(String nome) {
            clienteDto.setNome(nome);
            return this;
        }

        public DtoBuilder sexo(Sexo sexo) {
            clienteDto.setSexo(sexo);
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

        public static DtoBuilder create() {
            return new DtoBuilder();
        }

        public static DtoBuilder from(Cliente cliente) {
            return new DtoBuilder(toRepresentation(cliente));
        }

        public ClienteDto build() {
            return clienteDto;
        }

        public static ClienteDto toRepresentation(Cliente cliente) {
            return ClienteDto.DtoBuilder.create()
                    .id(cliente.getId())
                    .nome(cliente.getNome())
                    .sexo(cliente.getSexo())
                    .telefone(cliente.getTelefone())
                    .endereco(cliente.getEndereco())
                    .build();
        }

        public static Cliente fromRepresentation(ClienteDto dto) {
            return Cliente.Builder.create()
                    .id(dto.getId())
                    .nome(dto.getNome())
                    .sexo(dto.getSexo())
                    .telefone(dto.getTelefone())
                    .endereco(dto.getEndereco())
                    .build();
        }

        public static List<ClienteDto> toRepresentation(List<Cliente> lista) {
            final List<ClienteDto> listaDto = new ArrayList<>();
            lista.stream().forEach(registro -> {
                listaDto.add(toRepresentation(registro));
            });
            return listaDto;
        }

    }

}
