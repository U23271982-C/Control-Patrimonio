package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AmbienteDTO {
    @NotNull(message = "El id no puede ser nulo", groups = {EnActualizar.class})
    private int id;
    @NotNull(message = "El nombre no puede ser nulo", groups = {EnCrear.class})
    @Size(max = 40, message = "La descripción no debe exceder los 40 caracteres")
    private String nombre;
    @NotNull(message = "El id del inmueble no puede ser nulo", groups = {EnCrear.class})
    private int id_inmueble;

    public AmbienteDTO() {}

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

    public int getId_inmueble() {
        return id_inmueble;
    }

    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }
}
