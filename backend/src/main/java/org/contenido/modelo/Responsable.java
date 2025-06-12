package org.contenido.modelo;

public class Responsable {
    private int id;
    private String nombre;
    private String dni;
    private String email;
    private String cargo;

    public Responsable(int id, String nombre, String dni, String email, String cargo) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.cargo = cargo;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
}
