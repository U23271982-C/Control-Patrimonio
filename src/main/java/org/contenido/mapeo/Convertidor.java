package org.contenido.mapeo;

public interface Convertidor<T, D> {
    D convertidorDTO(T modelo);
    T convertidorModelo(D dto);
}
