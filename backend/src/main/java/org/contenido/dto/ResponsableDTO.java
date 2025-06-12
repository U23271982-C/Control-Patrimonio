package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ResponsableDTO {
    @NotNull(message = "El id no puede ser nulo", groups = {EnActualizar.class})
    private int id;
    @NotNull(message = "El nombre no puede ser nulo", groups = {EnCrear.class})
    @Size(max = 30, message = "El nombre no debe exceder los 30 caracteres")
    private String nombre;
    @Size(max = 8, message = "El dni no debe exceder los 8 caracteres")
    private String dni;
    @Email(message = "El email no es valido")
    private String email;
    @Size(max = 30, message = "El cargo no debe exceder los 30 caracteres")
    private String cargo;
    @NotNull(message = "El Rol Responsable no puede ser nulo", groups = {EnCrear.class})
    private Rol_ResponsableDTO rol_responsableDTO;
    // corroborar Rol_Responsble

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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Rol_ResponsableDTO getRol_ResponsableDTO() {
        return rol_responsableDTO;
    }

    public void setRol_responsableDTO(Rol_ResponsableDTO rolResponsableDTO) {
        this.rol_responsableDTO = rolResponsableDTO;
    }
}
