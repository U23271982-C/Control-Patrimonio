package org.contenido.mapeo;

public interface Convertidor<T, D> {
    D convertirDTO(T modelo);
    T convertirModelo(D dto);
}
