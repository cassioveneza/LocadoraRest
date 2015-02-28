package br.com.locadora.model;

public enum Genero {

    ACAO("Ação"),
    COMEDIA("Comédia"),
    DRAMA("Drama"),
    LANCAMENTO("Lançamento");

    private final String descricao;

    private Genero( String descricao) {
        this.descricao = descricao;
    }
}
