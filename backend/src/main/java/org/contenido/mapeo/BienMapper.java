package org.contenido.mapeo;

import org.contenido.dto.BienDTO;
import org.contenido.modelo.Bien;

public class BienMapper implements Convertidor<Bien, BienDTO>{
    public BienMapper() {
    }

    @Override
    public BienDTO convertirDTO(Bien modelo) {
        return null;
    }

    @Override
    public Bien convertirModelo(BienDTO dto) {
        return null;
    }
}
