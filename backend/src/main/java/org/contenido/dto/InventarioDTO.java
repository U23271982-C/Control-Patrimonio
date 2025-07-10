package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class InventarioDTO {
    @NotNull(message = "El id no puede ser nulo", groups = EnActualizar.class)
    private int id;
    @NotNull(message = "El nombre no puede ser nulo", groups = EnCrear.class)
    @Size(max = 50, message = "La descripción no debe exceder los 50 caracteres")
    private String nombre;
    @NotNull(message = "La descripción no puede ser nula", groups = EnCrear.class)
    @Size(max = 50, message = "La descripción no debe exceder los 50 caracteres")
    private String descripcion;
    private LocalDate fechaInicio;

    public InventarioDTO() {}

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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Override
    public String toString(){
        return this.nombre;
    }
}
