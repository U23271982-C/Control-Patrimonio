package org.contenido.dto;

import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RotacionDTO {
    @NotNull( message = "El id no puede ser nulo",  groups = {EnActualizar.class})
    private int id;
    @NotNull( message = "El id del bien no puede ser nulo",  groups = {EnCrear.class})
    private int id_bien;
    @NotNull( message = "El id del ambiente no puede ser nulo",  groups = {EnCrear.class})
    private int id_ambiente;
    @NotNull( message = "El id del responsable no puede ser nulo",  groups = {EnCrear.class})
    @Size(max = 30, message = "El motivo no debe exceder los 30 caracteres")
    private String motivo;
    @NotNull( message = "El id del responsable no puede ser nulo",  groups = {EnCrear.class})
    private int id_responsable;

    public RotacionDTO() {}

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

    public int getId_ambiente() {
        return id_ambiente;
    }

    public void setId_ambiente(int id_ambiente) {
        this.id_ambiente = id_ambiente;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public int getId_responsable() {
        return id_responsable;
    }

    public void setId_responsable(int id_responsable) {
        this.id_responsable = id_responsable;
    }
}
