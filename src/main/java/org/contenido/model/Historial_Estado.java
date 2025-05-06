package org.contenido.model;

import java.time.LocalDate;

public class Historial_Estado {
    private int id;
    private Bien bien;
    private Estado estado;
    private String motivo;
    private LocalDate fecha_cambio;
    private Responsable responsable;

    public Historial_Estado(int id, Bien bien, Estado estado, String motivo, LocalDate fecha_cambio, Responsable responsable) {
        this.id = id;
        this.bien = bien;
        this.estado = estado;
        this.motivo = motivo;
        this.fecha_cambio = fecha_cambio;
        this.responsable = responsable;
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
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

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
}
