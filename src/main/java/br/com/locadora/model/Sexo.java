package br.com.locadora.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Sexo {

    MASCULINO("Masculino"), 
    FEMININO("Feminino");

    private final String descricao;

    private Sexo(String descricao) {
        this.descricao = descricao;
    }

    @JsonValue
    public String getDescricao() {
        return toString();
    }

}
