package org.contenido.mapeo;

import org.contenido.dto.AsignacionDTO;
import org.contenido.modelo.Asignacion;

public class AsignacionMapper implements Convertidor<Asignacion, AsignacionDTO>{
    public AsignacionMapper() {
    }

    @Override
    public AsignacionDTO convertirDTO(Asignacion modelo) {
        return null;
    }

    @Override
    public Asignacion convertirModelo(AsignacionDTO dto) {
        return null;
    }
}
