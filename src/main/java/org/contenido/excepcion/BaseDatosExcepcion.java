package org.contenido.excepcion;

public class BaseDatosExcepcion extends RuntimeException {
    public BaseDatosExcepcion(String message) {
        super(message);
    }
}
