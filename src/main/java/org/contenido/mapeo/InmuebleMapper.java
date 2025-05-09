package org.contenido.mapeo;

import org.contenido.dto.InmuebleDTO;
import org.contenido.modelo.Inmueble;

public class InmuebleMapper implements Convertidor<Inmueble, InmuebleDTO>{
    public InmuebleMapper() {
    }

    @Override
    public InmuebleDTO convertirDTO(Inmueble modelo) {
        return null;
    }

    @Override
    public Inmueble convertirModelo(InmuebleDTO dto) {
        return null;
    }
}
