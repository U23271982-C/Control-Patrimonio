package org.contenido.utilidad;

import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.excepcion.ValidacionExcepcion;

import javax.swing.*;
import java.util.Map;

public class NotificacionUtil {
    private record TipoError(String titulo, int tipo) {}

    private static final Map<Class<? extends Exception>, TipoError> MAPEO_ERRORES = Map.of(
            ValidacionExcepcion.class, new TipoError("Error de validación", JOptionPane.WARNING_MESSAGE),
            NegocioExcepcion.class, new TipoError("Error de negocio", JOptionPane.WARNING_MESSAGE),
            PersistenciaExcepcion.class, new TipoError("Error en la base de datos", JOptionPane.ERROR_MESSAGE)
    );

    public static void mostrarMensajeAfirmacion(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarError(Exception e) {
        var tipoError = MAPEO_ERRORES.getOrDefault(e.getClass(),
                new TipoError("Error", JOptionPane.ERROR_MESSAGE));

        JOptionPane.showMessageDialog(null, e.getMessage(), tipoError.titulo(), tipoError.tipo());
    }

}
