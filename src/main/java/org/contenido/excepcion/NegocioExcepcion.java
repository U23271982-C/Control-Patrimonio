package org.contenido.excepcion;

public class NegocioExcepcion extends RuntimeException {
    public NegocioExcepcion(String message) {
        super(message);
    }
}
