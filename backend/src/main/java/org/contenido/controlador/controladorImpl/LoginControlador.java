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
            boolean validado = servicio.validarCredenciales();
            if (validado) {
                NotificacionUtil.mostrarMensajeAfirmacionLogueo(
                        servicio.getDto().getRol_ResponsableDTO().getNombreRol(),
                        servicio.getDto().getNombre(),
                        "ASSET CONTROL");
                return true;
            }
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return false;
    }

    public boolean accesoSoloSuperUsuario(String contrasenaIngresada) {
        try {
            return servicio.accesoSoloSuperUsuario(contrasenaIngresada);
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return false;
    }

}
