package org.contenido.mapper;

import org.contenido.dto.EstadoDTO;
import org.contenido.model.Estado;

public class EstadoMapper implements Convertidor <Estado,EstadoDTO>{
    public EstadoMapper() {
    }

    @Override
    public EstadoDTO convertidorDTO(Estado modelo) {
        return null;
    }

    @Override
    public Estado convertidorModelo(EstadoDTO dto) {
        return null;
    }
}
