package org.contenido.excepcion;

public class PersistenciaExcepcion extends RuntimeException {
    public PersistenciaExcepcion(String message, Throwable cause) {
        super(message, cause);
    }
}
