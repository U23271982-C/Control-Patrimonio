package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EstadoDTO {
    @NotNull(message = "El id no puede ser nulo", groups = {EnActualizar.class})
    private int id;
    @NotNull(message = "El tipo no puede ser nulo", groups = {EnCrear.class})
    @Size(max = 30, message = "El tipo no debe exceder los 30 caracteres", groups = {EnCrear.class, EnActualizar.class})
    private String tipo;

    public EstadoDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return this.getTipo();
    }
}
