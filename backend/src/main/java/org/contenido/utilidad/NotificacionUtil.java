package org.contenido.utilidad;

import org.contenido.excepcion.*;

import javax.swing.*;
import java.util.Map;

public class NotificacionUtil {
    private record TipoError(String titulo, int tipo) {} // Record para encapsular el título y tipo de mensaje de error

    private static final Map<Class<? extends Exception>, TipoError> MAPEO_ERRORES = Map.of(
            // Mapeo de excepciones a tipos de error para mostrar mensajes específicos
            // Por cada tipo de excepción creada en /excepcion, se debe agregar aquí
            ValidacionExcepcion.class, new TipoError("Error de validación", JOptionPane.WARNING_MESSAGE),
            NegocioExcepcion.class, new TipoError("Error de negocio", JOptionPane.WARNING_MESSAGE),
            PersistenciaExcepcion.class, new TipoError("Error en la base de datos", JOptionPane.ERROR_MESSAGE),
            SuperAdminExcepcion.class, new TipoError("Error en los permisos de Super Admin", JOptionPane.ERROR_MESSAGE),
            LoginExcepcion.class, new TipoError("Error en Iniciar Sesión", JOptionPane.ERROR_MESSAGE),
            ExportarExcepcion.class, new TipoError("Error en Exportación de Archivos", JOptionPane.ERROR_MESSAGE),
            FormatoExportacionExcepcion.class, new TipoError("Error en Formato de Exportar", JOptionPane.ERROR_MESSAGE)
    );

    public static void mostrarMensajeAfirmacion(String mensaje) {
        // Este método se utiliza para notificar al usuario de una acción exitosa
        // como la creación, actualización o eliminación de un registro.
        JOptionPane.showMessageDialog(null, mensaje, "Información", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void mostrarError(Exception e) {
        // Este método se utiliza para notificar al usuario de un error ocurrido
        // durante la ejecución de una acción, como la validación de datos o
        // la interacción con la base de datos.
        var tipoError = MAPEO_ERRORES.getOrDefault(
                e.getClass(),
                new TipoError("Error", JOptionPane.ERROR_MESSAGE));

        JOptionPane.showMessageDialog(null, e.getMessage(), tipoError.titulo(), tipoError.tipo());
    }

    public static void mostrarMensajeAfirmacionLogueo(String rolResponsable, String nombreResponsable, String nombreApp) {
        String mensaje = """
                ¡Bienvenido a %s!
                
                ¡Hola! %s
                Tienes el Rol de %s
                """;
        mostrarMensajeAfirmacion(String.format(mensaje, nombreApp,nombreResponsable, rolResponsable));
    }
}
