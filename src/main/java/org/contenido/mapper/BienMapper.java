package org.contenido.mapper;

import org.contenido.dto.BienDTO;
import org.contenido.model.Bien;

public class BienMapper implements Convertidor<Bien, BienDTO>{
    public BienMapper() {
    }

    @Override
    public BienDTO convertidorDTO(Bien modelo) {
        return null;
    }

    @Override
    public Bien convertidorModelo(BienDTO dto) {
        return null;
    }
}
