package org.contenido.controlador.controladorImpl;

import org.contenido.dto.ResponsableDTO;
import org.contenido.servicio.servicioImpl.LoginServicio;
import org.contenido.utilidad.NotificacionUtil;

public class LoginControlador {
    private LoginServicio servicio;

    public LoginControlador(LoginServicio servicio) {
        this.servicio = servicio;
    }

    public boolean validarCredenciales(ResponsableDTO dto) {
        try {
            // valida las credeciales del servicio
            // si es correcto lanza una notificación personalizada
            servicio.validarCredenciales();
            NotificacionUtil.mostrarMensajeAfirmacionLogueo(
                    servicio.getDto().getRol_ResponsableDTO().getNombreRol(),
                    servicio.getDto().getNombre(),
                    "ASSET CONTROL");
            return true;
        } catch (Exception e) {
            // captura de excepcion
            NotificacionUtil.mostrarError(e);
        }
        return false;
    }

    public void accesoSoloSuperUsuario() {
        try {
            servicio.accesoSoloSuperUsuario();
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

}
