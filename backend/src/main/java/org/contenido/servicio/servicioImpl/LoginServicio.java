package org.contenido.servicio.servicioImpl;

import org.contenido.dto.ResponsableDTO;
import org.contenido.excepcion.LoginExcepcion;
import org.contenido.excepcion.SuperAdminExcepcion;

public class LoginServicio {
    private final ResponsableServicio servicio;
    private ResponsableDTO dto;
    private ResponsableDTO getDtoDevuelve;

    public LoginServicio(ResponsableDTO dto) {
        this.servicio = new ResponsableServicio();
        this.dto = dto;
    }

    public boolean validarCredenciales() throws LoginExcepcion{
        this.getDtoDevuelve = servicio.leerPorUsuarioContrasena(dto);
        // Si no esta registrado las credenciales, arroga una excepcion
        if (getDtoDevuelve == null) throw new LoginExcepcion(
                    "Usuario o contraseña equivocadas. Intente de nuevamente.");

        return true;
    }

    public void accesoSoloSuperUsuario() {
        String rol = dto.getRol_ResponsableDTO().getNombreRol();
        if (!rol.toLowerCase().contains("super")) {
            throw new SuperAdminExcepcion(String.format(
                    "Solo para 'Super Usuario'. Usted tiene permiso de '%s'", rol));
        }
    }

    public void setDto(ResponsableDTO dto) {
        this.dto = dto;
    }

    public ResponsableDTO getDto() {
        return getDtoDevuelve;
    }
}
