package org.contenido.mapeo;

import org.contenido.dto.ResponsableDTO;
import org.contenido.model.Responsable;

public class ResponsableMapper implements Convertidor<Responsable, ResponsableDTO>{
    public ResponsableMapper() {
    }

    @Override
    public ResponsableDTO convertidorDTO(Responsable modelo) {
        return null;
    }

    @Override
    public Responsable convertidorModelo(ResponsableDTO dto) {
        return null;
    }
}
