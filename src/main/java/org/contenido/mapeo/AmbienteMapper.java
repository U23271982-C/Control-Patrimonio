package org.contenido.mapeo;

import org.contenido.dto.AmbienteDTO;
import org.contenido.modelo.Ambiente;

public class AmbienteMapper implements Convertidor<Ambiente, AmbienteDTO>{
    public AmbienteMapper() {
    }

    @Override
    public AmbienteDTO convertirDTO(Ambiente modelo) {
        AmbienteDTO dto = new AmbienteDTO();
        dto.setId(modelo.getId());
        dto.setNombre(modelo.getNombre());
        if (modelo.getInmueble() != null) dto.setId_inmueble(modelo.getInmueble().getId());

        return dto;
    }

    @Override
    public Ambiente convertirModelo(AmbienteDTO dto) {
        Ambiente model = new Ambiente();
        model.setId(dto.getId());
        model.setNombre(dto.getNombre());
        model.setInmueble(null);
        return null;
    }
}
