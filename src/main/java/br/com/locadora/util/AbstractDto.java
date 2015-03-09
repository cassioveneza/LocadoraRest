package br.com.locadora.util;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDto<T, DTO> {

    protected abstract DTO toRepresentation(T t);

    protected abstract T fromRepresentation(DTO dto);

    public List<DTO> toRepresentation(List<T> listaDto) {
        final List<DTO> lista = new ArrayList<>();
        listaDto.stream().forEach(registro -> {
            lista.add(this.toRepresentation(registro));
        });
        return lista;
    }
;
}
