package org.contenido.mapper;

public interface Convertidor<T, D> {
    D convertidorDTO(T modelo);
    T convertidorModelo(D dto);
}
