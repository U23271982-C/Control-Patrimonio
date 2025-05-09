package org.contenido.mapeo;

import org.contenido.dto.RotacionDTO;
import org.contenido.modelo.Rotacion;

public class RotacionMapper implements Convertidor<Rotacion, RotacionDTO>{
    public RotacionMapper() {
    }

    @Override
    public RotacionDTO convertirDTO(Rotacion modelo) {
        return null;
    }

    @Override
    public Rotacion convertirModelo(RotacionDTO dto) {
        return null;
    }
}
