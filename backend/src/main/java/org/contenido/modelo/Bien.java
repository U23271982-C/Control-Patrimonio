package org.contenido.modelo;

import java.time.LocalDate;

public class Bien {
    private int id;
    private String codigo;
    private String nombre;
    private String descripcion;
    private LocalDate fecha_registro;
    private Estado estado;
    private Categoria categoria;
    private Ambiente ambiente;
    private Responsable responsable;

    public Bien(int id, String codigo, String nombre, String descripcion, LocalDate fecha_registro, Estado estado, Categoria categoria, Ambiente ambiente, Responsable responsable) {
        this.id = id;
        this.codigo=codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha_registro = fecha_registro;
        this.estado = estado;
        this.categoria = categoria;
        this.ambiente = ambiente;
        this.responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo(){return codigo;}

    public void setCodigo(String codigo){this.codigo=codigo;}

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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
}
