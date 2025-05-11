package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class Historial_EstadoDTO {
    @NotNull(message = "El id no puede ser nulo", groups = {EnActualizar.class})
    private int id;
    @NotNull(message = "El id del bien no puede ser nulo", groups = {EnCrear.class})
    private int id_bien;
    @NotNull(message = "El id del estado no puede ser nulo", groups = {EnCrear.class})
    private int id_estado;
    @Size(max = 30, message = "El motivo no debe exceder los 30 caracteres")
    private String motivo;
    @NotNull(message = "La fecha de cambio no puede ser nula", groups = {EnCrear.class})
    private LocalDate fecha_cambio;
    @NotNull(message = "El id del responsable no puede ser nulo", groups = {EnCrear.class})
    private int id_responsable_encargado;

    public Historial_EstadoDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_bien() {
        return id_bien;
    }

    public void setId_bien(int id_bien) {
        this.id_bien = id_bien;
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDate getFecha_cambio() {
        return fecha_cambio;
    }

    public void setFecha_cambio(LocalDate fecha_cambio) {
        this.fecha_cambio = fecha_cambio;
    }

    public int getId_responsable_encargado() {
        return id_responsable_encargado;
    }

    public void setId_responsable_encargado(int id_responsable_encargado) {
        this.id_responsable_encargado = id_responsable_encargado;
    }
}
