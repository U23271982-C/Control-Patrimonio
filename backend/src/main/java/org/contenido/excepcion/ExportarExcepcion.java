package org.contenido.excepcion;

public class ExportarExcepcion extends RuntimeException {
    public ExportarExcepcion(String message) {
        super(message);
    }
}
