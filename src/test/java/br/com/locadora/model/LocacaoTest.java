package br.com.locadora.model;

import java.time.LocalDate;
import java.time.Month;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

public class LocacaoTest {

    public Cliente criarCliente() {
        final String nome = "JOAO SILVA";
        final Sexo sexo = Sexo.MASCULINO;
        final String endereco = "RUA GERAL";

        final Cliente cliente = Cliente.Builder.create()
                .nome(nome)
                .sexo(sexo)
                .endereco(endereco)
                .build();
        assertNotNull(cliente);
        return cliente;
    }

    @Test
    public void testCreateUpdate() {
        final Cliente cliente = criarCliente();
        final LocalDate data = LocalDate.of(2014, Month.MARCH, 1);

        final Locacao locacao = Locacao.Builder.create()
                .cliente(cliente)
                .data(data)
                .build();
        assertNotNull(locacao);
        assertEquals(locacao.getCliente().getId(), cliente.getId());
        assertEquals(locacao.getData(), data);

        final LocalDate dataAlterada = LocalDate.of(2014, Month.MARCH, 2);
        Locacao locacaoAlterada = Locacao.Builder.from(locacao)
                .data(dataAlterada)
                .build();
        assertNotNull(locacaoAlterada);
        assertEquals(locacao.getCliente().getId(), cliente.getId());
        assertEquals(locacao.getData(), dataAlterada);
    }

}
