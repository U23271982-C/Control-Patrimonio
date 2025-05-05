package org.contenido.dto;

public class RotacionDTO {
    private int id;
    private int id_bien;
    private int id_ambiente;
    private String motivo;
    private int id_responsable;

    public RotacionDTO(int id, int id_bien, int id_ambiente, String motivo, int id_responsable) {
        this.id = id;
        this.id_bien = id_bien;
        this.id_ambiente = id_ambiente;
        this.motivo = motivo;
        this.id_responsable = id_responsable;
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
