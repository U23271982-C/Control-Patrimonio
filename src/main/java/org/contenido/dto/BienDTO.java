package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class BienDTO {
    @NotNull( message = "El id no puede ser nulo", groups = {EnActualizar.class})
    private int id;
    @NotNull( message = "El nombre no puede ser nulo", groups = {EnCrear.class})
    @Size(max = 50, message = "La descripción no debe exceder los 50 caracteres")
    private String nombre;
    @NotNull( message = "La descripción no puede ser nula", groups = {EnCrear.class})
    @Size(max = 50, message = "La descripción no debe exceder los 50 caracteres")
    private String descripcion;
    @NotNull( message = "La fecha de registro no puede ser nula", groups = {EnCrear.class})
    private LocalDate fecha_registro;
    @NotNull( message = "El id del estado actual no puede ser nulo", groups = {EnCrear.class})
    private int id_estado_actual;
    @NotNull( message = "El id del responsable actual no puede ser nulo", groups = {EnCrear.class})
    private int id_categoria;
    @NotNull( message = "El id del responsable actual no puede ser nulo", groups = {EnCrear.class})
    private int id_ambiente;
    @NotNull( message = "El id del responsable actual no puede ser nulo", groups = {EnCrear.class})
    private int id_responsable_actual;

    public BienDTO() {}

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
