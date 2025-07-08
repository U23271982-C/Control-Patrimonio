package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;
import org.contenido.validacion.EnLeer;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

public class AmbienteDTO {
    @NotNull(message = "El id no puede ser nulo", groups = {EnActualizar.class, EnLeer.class})
    @Positive(message = "El id debe ser positivo", groups = {EnActualizar.class, EnLeer.class})
    private int id;
    //@NotNull(message = "El nombre no puede ser nulo", groups = {EnCrear.class})
    @Size(max = 40, message = "La descripción no debe exceder los 40 caracteres")
    @NotBlank(message = "El nombre no puede estar vacio", groups = {EnCrear.class, EnActualizar.class})
    private String nombre;
    @NotNull(message = "El id del inmueble no puede ser nulo", groups = {EnCrear.class})
    private InmuebleDTO inmuebleDTO;

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

    public InmuebleDTO getInmuebleDTO() {
        return inmuebleDTO;
    }

    public void setInmuebleDTO(InmuebleDTO inmuebleDTO) {
        this.inmuebleDTO = inmuebleDTO;
    }

    @Override
    public String toString() {
        return this.getNombre();
    }
}
