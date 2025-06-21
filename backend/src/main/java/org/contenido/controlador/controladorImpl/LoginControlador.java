package org.contenido.controlador.controladorImpl;

import org.contenido.dto.ResponsableDTO;
import org.contenido.servicio.servicioImpl.ResponsableServicio;
import org.contenido.utilidad.NotificacionUtil;

public class LoginControlador {
    private ResponsableServicio servicio;

    public LoginControlador() {
        this.servicio = new ResponsableServicio();
    }

    public boolean validarCredenciales(ResponsableDTO dto) {
        ResponsableDTO r = servicio.leerPorUsuarioContrasena(dto);
        // Si existe el responsable, se va loguear
        if (r != null) {
            NotificacionUtil.mostrarMensajeAfirmacionLogueo(
                    r.getRol_ResponsableDTO().getNombreRol(),
                    r.getNombre(),
                    "ASSET CONTROL");
            return true;
        }

        return false;
    }

}
