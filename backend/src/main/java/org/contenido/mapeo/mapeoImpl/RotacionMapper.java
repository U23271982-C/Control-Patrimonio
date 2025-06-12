package org.contenido.mapeo.mapeoImpl;

import org.contenido.dto.RotacionDTO;
import org.contenido.mapeo.Convertidor;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Rotacion;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RotacionMapper implements Convertidor<Rotacion, RotacionDTO>, ResultSetMapper<Rotacion> {
    private final AmbienteMapper ambienteMapper;
    private final BienMapper bienMapper;
    private final RotacionMapper rotacionMapper;
    public RotacionMapper() {
        this.ambienteMapper = new AmbienteMapper();
        this.bienMapper = new BienMapper();
        this.rotacionMapper = new RotacionMapper();
    }

    @Override
    public RotacionDTO convertirDTO(Rotacion modelo) {
        RotacionDTO dto = new RotacionDTO();

        dto.setId(modelo.getId());
        dto.setMotivo(modelo.getMotivo());
        dto.setAmbienteDTO(
                modelo.getAmbiente() != null ?
                ambienteMapper.convertirDTO(modelo.getAmbiente()) : null
        );
        dto.setBienDTO(
                modelo.getBien() != null ?
                bienMapper.convertirDTO(modelo.getBien()) : null
        );
        dto.setResponsableDTO(
                modelo.getResponsable() != null ?
                new ResponsableMapper().convertirDTO(modelo.getResponsable()) : null
        );

        return dto;
    }

    @Override
    public Rotacion convertirModelo(RotacionDTO dto) {
        return new Rotacion(
                dto.getId(),
                dto.getBienDTO() != null ? bienMapper.convertirModelo(dto.getBienDTO()) : null,
                dto.getAmbienteDTO() != null ? ambienteMapper.convertirModelo(dto.getAmbienteDTO()) : null,
                dto.getMotivo(),
                dto.getResponsableDTO() != null ? new ResponsableMapper().convertirModelo(dto.getResponsableDTO()) : null
        );
    }

    @Override
    public Rotacion mapDeResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
