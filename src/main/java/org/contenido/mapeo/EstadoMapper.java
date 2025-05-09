package org.contenido.mapeo;

import org.contenido.dto.EstadoDTO;
import org.contenido.modelo.Estado;

public class EstadoMapper implements Convertidor <Estado,EstadoDTO>{
    public EstadoMapper() {
    }

    @Override
    public EstadoDTO convertirDTO(Estado modelo) {
        return null;
    }

    @Override
    public Estado convertirModelo(EstadoDTO dto) {
        return null;
    }
}
