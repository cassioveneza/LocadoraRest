package br.com.locadora.util;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDto<T, DTO> {

    protected abstract DTO toRepresentation(T t);

    protected abstract T fromRepresentation(DTO dto);

    public List<DTO> toRepresentation(List<T> lista) {
        final List<DTO> listaDto = new ArrayList<>();
        lista.stream().forEach(registro -> {
            listaDto.add(this.toRepresentation(registro));
        });
        return listaDto;
    }
}
