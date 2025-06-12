package org.contenido.excepcion;

public class ValidacionExcepcion extends RuntimeException {
    public ValidacionExcepcion(String message) {
        super(message);
    }
}
