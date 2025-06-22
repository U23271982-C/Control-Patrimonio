package org.contenido.excepcion;

public class LoginExcepcion extends RuntimeException {
    public LoginExcepcion(String message) {
        super(message);
    }
}
