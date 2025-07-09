package org.contenido.servicio.servicioImpl;

import org.contenido.dto.ResponsableDTO;
import org.contenido.excepcion.LoginExcepcion;
import org.contenido.excepcion.SuperAdminExcepcion;

public class LoginServicio {
    private final ResponsableServicio servicio;
    private ResponsableDTO dto;
    private static ResponsableDTO getDtoDevuelve;

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

    public boolean accesoSoloSuperUsuario(String contrasenaIngresada) {
        // Verifica que la contraseña ingresada coincida con la del usuario actual
        boolean result = true;
        if (!getDtoDevuelve.getContrsena().equals(contrasenaIngresada)) {
            throw new LoginExcepcion("Contraseña incorrecta.");
        }
        // Verifica si es superUsuario
        String rol = getDtoDevuelve.getRol_ResponsableDTO().getNombreRol();
        if (!rol.toLowerCase().contains("super")) {
            result = false;
            throw new SuperAdminExcepcion(String.format(
                    "Solo para 'Super Usuario'. Usted tiene permiso de '%s'", rol));
        }

        return result;
    }

    public void setDto(ResponsableDTO dto) {
        this.dto = dto;
    }

    public ResponsableDTO getDto() {
        return getDtoDevuelve;
    }
}
