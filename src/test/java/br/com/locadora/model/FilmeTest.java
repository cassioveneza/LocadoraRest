/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model;

import java.math.BigDecimal;
import org.testng.Assert;
import org.testng.annotations.*;

public class FilmeTest {

    public FilmeTest() {
    }

    @Test //(enabled = false)
    public void testCriacao() {
        final String nome = "JOAO E MARIA";
        final Genero genero = Genero.LANCAMENTO;
        final BigDecimal preco = BigDecimal.TEN;

//        Filme filme = new Filme()
//                .setNome(nome)
//                .setGenero(genero)
//                .setPrecoUnitario(preco);
//        Filme filme = Filme.()
//                .setNome(nome)
//                .setGenero(genero)
//                .setPrecoUnitario(preco);

//        Assert.assertEquals(filme.getNome(), nome);
//        Assert.assertEquals(filme.getGenero(), genero);
//        Assert.assertEquals(filme.getPrecoUnitario(), preco);
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
