package org.contenido.mapeo;

import org.contenido.dto.InventarioDTO;
import org.contenido.model.Inventario;

public class InventarioMapper implements Convertidor<Inventario, InventarioDTO>{
    public InventarioMapper() {
    }

    @Override
    public InventarioDTO convertidorDTO(Inventario modelo) {
        return null;
    }

    @Override
    public Inventario convertidorModelo(InventarioDTO dto) {
        return null;
    }
}
