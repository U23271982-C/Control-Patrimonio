package org.contenido.dto;

import java.time.LocalDate;

public class Historial_EstadoDTO {
    private int id;
    private int id_bien;
    private int id_estado;
    private String motivo;
    private LocalDate fecha_cambio;
    private int id_responsable_encargado;

    public Historial_EstadoDTO(int id, int id_bien, int id_estado, String motivo, LocalDate fecha_cambio, int id_responsable_encargado) {
        this.id = id;
        this.id_bien = id_bien;
        this.id_estado = id_estado;
        this.motivo = motivo;
        this.fecha_cambio = fecha_cambio;
        this.id_responsable_encargado = id_responsable_encargado;
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
