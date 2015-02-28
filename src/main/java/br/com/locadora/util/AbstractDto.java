package br.com.locadora.util;

public interface AbstractDto<T, DTO> {

    DTO toRepresentation(T t);

    T fromRepresentation();
}
