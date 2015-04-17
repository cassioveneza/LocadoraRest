package br.com.locadora.model;

import br.com.locadora.dto.ClienteDto;
import br.com.locadora.dto.LocacaoDto;
import java.time.LocalDate;
import java.time.Month;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

public class LocacaoTest {

    public ClienteDto criarCliente() {
        final String nome = "JOAO SILVA";
        final Sexo sexo = Sexo.MASCULINO;
        final String endereco = "RUA GERAL";

        final ClienteDto cliente = ClienteDto.DtoBuilder.create()
                .nome(nome)
                .sexo(sexo)
                .endereco(endereco)
                .build();
        assertNotNull(cliente);
        return cliente;
    }

    @Test(enabled = false)
    public void testCreateUpdate() {
        final ClienteDto cliente = criarCliente();
        final LocalDate data = LocalDate.of(2014, Month.MARCH, 1);

        final LocacaoDto locacao = LocacaoDto.DtoBuilder.create()
//                .cliente(cliente)
                .data(data)
                .build();
        assertNotNull(locacao);
        assertEquals(locacao.getCliente().getId(), cliente.getId());
        assertEquals(locacao.getData(), data);

        final LocalDate dataAlterada = LocalDate.of(2014, Month.MARCH, 2);
        LocacaoDto locacaoAlterada = LocacaoDto.DtoBuilder.from(locacao)
                .data(dataAlterada)
                .build();
        assertNotNull(locacaoAlterada);
        assertEquals(locacao.getCliente().getId(), cliente.getId());
        assertEquals(locacao.getData(), dataAlterada);
    }

}
