package org.contenido.mapper;

import org.contenido.dto.InmuebleDTO;
import org.contenido.model.Inmueble;

public class InmuebleMapper implements Convertidor<Inmueble, InmuebleDTO>{
    public InmuebleMapper() {
    }

    @Override
    public InmuebleDTO convertidorDTO(Inmueble modelo) {
        return null;
    }

    @Override
    public Inmueble convertidorModelo(InmuebleDTO dto) {
        return null;
    }
}
