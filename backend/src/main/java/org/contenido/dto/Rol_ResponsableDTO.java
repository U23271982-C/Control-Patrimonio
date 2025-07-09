package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Rol_ResponsableDTO {
    @NotNull(message = "El id no puede ser nulo", groups = {EnActualizar.class})
    private int id;
    @Size(max = 80, message = "La descripción no debe exceder los 80 caracteres")
    private String descripcion;
    @Size(max = 80, message = "El nombre rol no debe exceder los 80 caracteres")
    private String nombreRol;



    public Rol_ResponsableDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    @Override
    public String toString() {
        return this.getNombreRol();
    }

   

}
