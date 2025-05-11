package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class AsignacionDTO {
    @NotNull(message = "El id no puede ser nulo", groups = EnActualizar.class)
    private int id;
    @NotNull(message = "El id del bien no puede ser nulo", groups = EnCrear.class)
    private int id_bien;
    @NotNull(message = "El id del responsable no puede ser nulo", groups = EnCrear.class)
    private int id_bien_responsable;
    @NotNull(message = "La fecha de inicio no puede ser nula", groups = EnCrear.class)
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    public AsignacionDTO() {}

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

    public int getId_bien_responsable() {
        return id_bien_responsable;
    }

    public void setId_bien_responsable(int id_bien_responsable) {
        this.id_bien_responsable = id_bien_responsable;
    }

    public LocalDate getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(LocalDate fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public LocalDate getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(LocalDate fecha_fin) {
        this.fecha_fin = fecha_fin;
    }
}
