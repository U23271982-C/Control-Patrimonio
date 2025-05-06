package org.contenido.mapper;

import org.contenido.dto.RotacionDTO;
import org.contenido.model.Rotacion;

public class RotacionMapper implements Convertidor<Rotacion, RotacionDTO>{
    public RotacionMapper() {
    }

    @Override
    public RotacionDTO convertidorDTO(Rotacion modelo) {
        return null;
    }

    @Override
    public Rotacion convertidorModelo(RotacionDTO dto) {
        return null;
    }
}
