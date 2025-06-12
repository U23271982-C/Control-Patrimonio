package org.contenido.dto;


import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;

import javax.validation.constraints.NotNull;

public class Detalle_InventarioDTO {
    @NotNull(message = "El id no puede ser nulo", groups = {EnActualizar.class})
    private int id;
    @NotNull(message = "El Bien no puede ser nulo", groups = {EnCrear.class})
    private BienDTO bienDTO;
    @NotNull(message = "El Inventario no puede ser nulo", groups = {EnCrear.class})
    private InventarioDTO inventarioDTO;

    public Detalle_InventarioDTO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BienDTO getBienDTO() {
        return bienDTO;
    }

    public void setBienDTO(BienDTO bienDTO) {
        this.bienDTO = bienDTO;
    }

    public InventarioDTO getInventarioDTO() {
        return inventarioDTO;
    }

    public void setInventarioDTO(InventarioDTO inventarioDTO) {
        this.inventarioDTO = inventarioDTO;
    }
}
