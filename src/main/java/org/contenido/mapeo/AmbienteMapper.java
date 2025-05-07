package org.contenido.mapeo;

import org.contenido.dto.AmbienteDTO;
import org.contenido.modelo.Ambiente;

public class AmbienteMapper implements Convertidor<Ambiente, AmbienteDTO>{
    public AmbienteMapper() {
    }

    @Override
    public AmbienteDTO convertirDTO(Ambiente modelo) {
        return null;
    }

    @Override
    public Ambiente convertirModelo(AmbienteDTO dto) {
        return null;
    }
}
