package org.contenido.modelo;

public class Rol_Responsable {
    private int id;
    private String descripcion;
    private String nombreRol;

    public Rol_Responsable(int id, String descripcion, String nombreRol) {
        this.id = id;
        this.descripcion = descripcion;
        this.nombreRol = nombreRol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
}
