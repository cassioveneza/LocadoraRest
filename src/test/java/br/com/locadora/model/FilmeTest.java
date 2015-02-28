/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.locadora.model;

import br.com.locadora.model.Filme;
import junit.framework.Assert;
import org.testng.annotations.*;

/**
 *
 * @author user
 */
public class FilmeTest {

    public FilmeTest() {
    }

    @Test
    public void testCriacao() {
        Filme filme = new Filme()
                .setNome("JOAO E MARIA")
                .setGenero("LA")
                .setPrecoUnitario(10d);
        Assert.assertEquals(filme.getNome(), "JOAO E MARIA");
        Assert.assertEquals(filme.getGenero(), "LA");
        
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
