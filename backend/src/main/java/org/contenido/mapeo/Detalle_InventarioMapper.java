package org.contenido.mapeo;

import org.contenido.dto.Detalle_InventarioDTO;
import org.contenido.modelo.Detalle_Inventario;

public class Detalle_InventarioMapper implements Convertidor<Detalle_Inventario, Detalle_InventarioDTO>{
    public Detalle_InventarioMapper() {
    }

    @Override
    public Detalle_InventarioDTO convertirDTO(Detalle_Inventario modelo) {
        return null;
    }

    @Override
    public Detalle_Inventario convertirModelo(Detalle_InventarioDTO dto) {
        return null;
    }
}
