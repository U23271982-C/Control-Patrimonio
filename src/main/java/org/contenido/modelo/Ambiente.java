package org.contenido.modelo;

public class Ambiente {
    private int id;
    private String nombre;
    private Inmueble inmueble;

    public Ambiente(int id, String nombre, Inmueble inmueble) {
        this.id = id;
        this.nombre = nombre;
        this.inmueble = inmueble;
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

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
}
