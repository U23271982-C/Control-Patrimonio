package org.contenido.model;

public class Rotacion {
    private int id;
    private Bien bien;
    private Ambiente ambiente;
    private String motivo;
    private Responsable responsable;

    public Rotacion(int id, Bien bien, Ambiente ambiente, String motivo, Responsable responsable) {
        this.id = id;
        this.bien = bien;
        this.ambiente = ambiente;
        this.motivo = motivo;
        this.responsable = responsable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bien getBien() {
        return bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Responsable getResponsable() {
        return responsable;
    }

    public void setResponsable(Responsable responsable) {
        this.responsable = responsable;
    }
}
