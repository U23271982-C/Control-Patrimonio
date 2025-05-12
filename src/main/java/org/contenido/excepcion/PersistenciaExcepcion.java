package org.contenido.excepcion;

import java.sql.SQLException;

public class BaseDatosExcepcion extends RuntimeException, SQLException {
    public BaseDatosExcepcion(String message) {
        super(message);
    }
}
