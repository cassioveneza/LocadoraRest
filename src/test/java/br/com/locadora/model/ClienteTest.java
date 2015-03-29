/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model;

import java.math.BigDecimal;
import static org.testng.Assert.*;
import org.testng.annotations.*;

public class ClienteTest {

    public ClienteTest() {
    }

    @Test
    public void testCreateUpdate() {
        final String nome = "JOAO SILVA";
        final String telefone = "9944-5588";
        final String endereco = "RUA GERAL";

        Cliente cliente = Cliente.Builder.create()
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

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
