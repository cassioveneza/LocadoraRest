package br.com.locadora.model;

public enum Genero {

    ACAO("AC", "Ação"),
    COMEDIA("CO", "Comédia"),
    LANCAMENTO("LA", "Lançamento");

    private final String sigla;
    private final String descricao;

    private Genero(final String sigla, final String descricao) {
        this.sigla = sigla;
        this.descricao = descricao;
    }
}
