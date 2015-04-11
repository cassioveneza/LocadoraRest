package br.com.locadora.model;

import java.math.BigDecimal;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import org.testng.annotations.Test;

public class FilmeTest {

    @Test
    public void testCreateUpdate() {
        final String nome = "LAGOA AZUL";
        final Genero genero = Genero.DRAMA;
        final BigDecimal precoUnitario = BigDecimal.ONE;

        final Filme filme = Filme.Builder.create()
                .nome(nome)
                .genero(genero)
                .precoUnitario(precoUnitario)
                .build();
        assertNotNull(filme);
        assertEquals(filme.getNome(), nome);
        assertEquals(filme.getGenero(), genero);
        assertEquals(filme.getPrecoUnitario(), precoUnitario);

        final String nomeAlterado = "DE VOLTA PARA A LAGOA AZUL";
        Filme filmeAlterado = Filme.Builder.from(filme)
                .nome(nomeAlterado)
                .build();
        assertNotNull(filmeAlterado);
        assertEquals(filme.getNome(), nomeAlterado);
        assertEquals(filme.getGenero(), genero);
        assertEquals(filme.getPrecoUnitario(), precoUnitario);
    }

}
