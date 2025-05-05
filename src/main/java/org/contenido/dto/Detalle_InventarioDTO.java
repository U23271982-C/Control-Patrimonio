package org.contenido.dto;

public class Detalle_InventarioDTO {
    private int id;
    private int id_bien;
    private int id_inventario;

    public Detalle_InventarioDTO(int id, int id_bien, int id_inventario) {
        this.id = id;
        this.id_bien = id_bien;
        this.id_inventario = id_inventario;
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

    public int getId_inventario() {
        return id_inventario;
    }

    public void setId_inventario(int id_inventario) {
        this.id_inventario = id_inventario;
    }
}
