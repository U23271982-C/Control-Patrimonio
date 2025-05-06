package org.contenido.dto;

public class AmbienteDTO {
    private int id;
    private String nombre;
    private int id_inmueble;

    public AmbienteDTO(int id, String nombre, int id_inmueble) {
        this.id = id;
        this.nombre = nombre;
        this.id_inmueble = id_inmueble;
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

    public int getId_inmueble() {
        return id_inmueble;
    }

    public void setId_inmueble(int id_inmueble) {
        this.id_inmueble = id_inmueble;
    }
}
