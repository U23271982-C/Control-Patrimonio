package org.contenido.modelo;

public class Responsable {
    private int id;
    private String nombre;
    private String dni;
    private String email;
    private String usuario;
    private String contrasena;
    private Rol_Responsable rol_responsable;

    public Responsable(int id, String nombre, String dni, String email, Rol_Responsable rol_responsable, String usuario, String contrasena) {
        this.id = id;
        this.nombre = nombre;
        this.dni = dni;
        this.email = email;
        this.rol_responsable = rol_responsable;
        this.usuario = usuario;
        this.contrasena = contrasena;
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

    public Rol_Responsable getRol_responsable() {
        return rol_responsable;
    }

    public void setRol_responsable(Rol_Responsable rol_responsable) {
        this.rol_responsable = rol_responsable;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
