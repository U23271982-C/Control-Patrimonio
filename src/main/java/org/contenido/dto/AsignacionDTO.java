package org.contenido.dto;

import java.time.LocalDate;

public class AsignacionDTO {
    private int id;
    private int id_bien;
    private int id_bien_responsable;
    private LocalDate fecha_inicio;
    private LocalDate fecha_fin;

    public AsignacionDTO(int id, int id_bien, int id_bien_responsable, LocalDate fecha_inicio, LocalDate fecha_fin) {
        this.id = id;
        this.id_bien = id_bien;
        this.id_bien_responsable = id_bien_responsable;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
    }

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
