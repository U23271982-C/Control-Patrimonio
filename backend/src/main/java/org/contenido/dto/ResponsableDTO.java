package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ResponsableDTO {
    @NotNull(message = "El id no puede ser nulo", groups = {EnActualizar.class})
    private int id;
    @NotNull(message = "El nombre no puede ser nulo", groups = {EnCrear.class})
    @Size(max = 30, message = "El nombre no debe exceder los 30 caracteres", groups = {EnCrear.class , EnActualizar.class})
    private String nombre;
    @Size(max = 8, message = "El dni no debe exceder los 8 caracteres", groups = {EnCrear.class , EnActualizar.class})
    private String dni;
    @Email(message = "El email no es valido")
    @Size(max = 30, message = "El email no debe exceder los 30 caracteres", groups = {EnCrear.class , EnActualizar.class})
    private String email;
    @NotNull(message = "El Rol Responsable no puede ser nulo", groups = {EnCrear.class})
    private Rol_ResponsableDTO rol_responsableDTO;
    // corroborar Rol_Responsble
    //@NotBlank(message = "El usuario no puede estar en blanco", groups = {EnCrear.class, EnActualizar.class})
    @Size(max = 30, message = "El usuario no debe exceder los 30 caracteres", groups = {EnCrear.class , EnActualizar.class})
    private String usuario;
    @Size(max = 255, message = "La contraseña no debe exceder los 255 caracteres", groups = {EnCrear.class , EnActualizar.class})
    //@NotBlank(message = "La contraseña no puede estar en blanco", groups = {EnCrear.class, EnActualizar.class})
    private String contrsena;

    public ResponsableDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Rol_ResponsableDTO getRol_ResponsableDTO() {
        return rol_responsableDTO;
    }

    public void setRol_responsableDTO(Rol_ResponsableDTO rolResponsableDTO) {
        this.rol_responsableDTO = rolResponsableDTO;
    }

    public Rol_ResponsableDTO getRol_responsableDTO() {
        return rol_responsableDTO;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrsena() {
        return contrsena;
    }

    public void setContrsena(String contrsena) {
        this.contrsena = contrsena;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
}
