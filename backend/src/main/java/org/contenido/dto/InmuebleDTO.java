package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;
import org.contenido.validacion.EnLeer;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class InmuebleDTO {
    @NotNull(message = "El id no puede ser nulo", groups = {EnActualizar.class, EnLeer.class})
    @Positive(message = "El id debe ser positivo", groups = {EnActualizar.class, EnLeer.class})
    private int id;
    @NotBlank(message = "El nombre no puede estar vacio", groups = {EnCrear.class})
    @Size(max = 50, message = "El nombre no debe exceder los 50 caracteres", groups = {EnActualizar.class, EnCrear.class})
    private String nombre;
    @Size(max = 50, message = "La descripción no debe exceder los 50 caracteres", groups = {EnActualizar.class, EnCrear.class})
    private String descripcion;

    public InmuebleDTO() {}

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
}
