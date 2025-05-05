package org.contenido.dto;

import java.time.LocalDate;

public class BienDTO {
    private int id;
    private String nombre;
    private String descripcion;
    private LocalDate fecha_registro;
    private int id_estado_actual;
    private int id_categoria;
    private int id_ambiente;
    private int id_responsable_actual;

    public BienDTO(int id, String nombre, String descripcion, LocalDate fecha_registro, int id_estado_actual, int id_categoria, int id_ambiente, int id_responsable_actual) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_registro = fecha_registro;
        this.id_estado_actual = id_estado_actual;
        this.id_categoria = id_categoria;
        this.id_ambiente = id_ambiente;
        this.id_responsable_actual = id_responsable_actual;
    }

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

    public LocalDate getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(LocalDate fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getId_estado_actual() {
        return id_estado_actual;
    }

    public void setId_estado_actual(int id_estado_actual) {
        this.id_estado_actual = id_estado_actual;
    }

    public int getId_categoria() {
        return id_categoria;
    }

    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }

    public int getId_ambiente() {
        return id_ambiente;
    }

    public void setId_ambiente(int id_ambiente) {
        this.id_ambiente = id_ambiente;
    }

    public int getId_responsable_actual() {
        return id_responsable_actual;
    }

    public void setId_responsable_actual(int id_responsable_actual) {
        this.id_responsable_actual = id_responsable_actual;
    }
}
