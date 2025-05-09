package org.contenido.mapeo;

import org.contenido.dto.InventarioDTO;
import org.contenido.modelo.Inventario;

public class InventarioMapper implements Convertidor<Inventario, InventarioDTO>{
    public InventarioMapper() {
    }

    @Override
    public InventarioDTO convertirDTO(Inventario modelo) {
        return null;
    }

    @Override
    public Inventario convertirModelo(InventarioDTO dto) {
        return null;
    }
}
