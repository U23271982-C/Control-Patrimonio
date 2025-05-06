package org.contenido.mapper;

import org.contenido.dto.Historial_EstadoDTO;
import org.contenido.model.Historial_Estado;

public class Historial_EstadoMapper implements Convertidor<Historial_Estado, Historial_EstadoDTO>{
    public Historial_EstadoMapper() {
    }

    @Override
    public Historial_EstadoDTO convertidorDTO(Historial_Estado modelo) {
        return null;
    }

    @Override
    public Historial_Estado convertidorModelo(Historial_EstadoDTO dto) {
        return null;
    }
}
