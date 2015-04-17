package br.com.locadora.model;

import br.com.locadora.dto.FilmeDto;
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

        final FilmeDto filme = FilmeDto.DtoBuilder.create()
                .nome(nome)
                .genero(genero)
                .precoUnitario(precoUnitario)
                .build();
        assertNotNull(filme);
        assertEquals(filme.getNome(), nome);
        assertEquals(filme.getGenero(), genero);
        assertEquals(filme.getPrecoUnitario(), precoUnitario);

        final String nomeAlterado = "DE VOLTA PARA A LAGOA AZUL";
        FilmeDto filmeAlterado = FilmeDto.DtoBuilder.from(filme)
                .nome(nomeAlterado)
                .build();
        assertNotNull(filmeAlterado);
        assertEquals(filme.getNome(), nomeAlterado);
        assertEquals(filme.getGenero(), genero);
        assertEquals(filme.getPrecoUnitario(), precoUnitario);
    }

}
