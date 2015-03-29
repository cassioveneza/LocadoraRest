package br.com.locadora.model;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

public class ClienteTest {

    @Test
    public void testCreateUpdate() {
        final String nome = "JOAO SILVA";
        final String telefone = "9944-5588";
        final String endereco = "RUA GERAL";

        final Cliente cliente = Cliente.Builder.create()
                .nome(nome)
                .telefone(telefone)
                .endereco(endereco)
                .build();
        assertNotNull(cliente);
        assertEquals(cliente.getNome(), nome);
        assertEquals(cliente.getTelefone(), telefone);
        assertEquals(cliente.getEndereco(), endereco);

        final String nomeAlterado = "MARIA DA SILVA";
        Cliente clienteAlterado = Cliente.Builder.from(cliente)
                .nome(nomeAlterado)
                .build();
        assertNotNull(clienteAlterado);
        assertEquals(cliente.getNome(), nomeAlterado);
        assertEquals(cliente.getTelefone(), telefone);
        assertEquals(cliente.getEndereco(), endereco);
    }

}
