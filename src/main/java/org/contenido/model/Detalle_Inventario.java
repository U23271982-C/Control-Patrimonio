package org.contenido.model;

public class Detalle_Inventario {
    private int id;
    private Bien bien;
    private Inventario inventario;

    public Detalle_Inventario(int id, Bien bien, Inventario inventario) {
        this.id = id;
        this.bien = bien;
        this.inventario = inventario;
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

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }
}
