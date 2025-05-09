package org.contenido.modelo;

import java.time.LocalDate;

public class Asignacion {
    private int id;
    private Bien bien;
    private Responsable responsable;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    public Asignacion(int id, Bien bien, Responsable responsable, LocalDate fechaInicio, LocalDate fechaFin) {
        this.id = id;
        this.bien = bien;
        this.responsable = responsable;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }
}
