package org.contenido.mapeo;

import org.contenido.dto.Historial_EstadoDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.modelo.Historial_Estado;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Historial_EstadoMapper implements Convertidor<Historial_Estado, Historial_EstadoDTO>, ResultSetMapper<Historial_Estado> {
    private final BienMapper bienMapper;
    private final EstadoMapper estadoMapper;
    private final ResponsableMapper responsableMapper;

    public Historial_EstadoMapper() {
        this.bienMapper = new BienMapper();
        this.estadoMapper = new EstadoMapper();
        this.responsableMapper = new ResponsableMapper();
    }

    @Override
    public Historial_EstadoDTO convertirDTO(Historial_Estado modelo) {
        if (modelo == null) throw new NegocioExcepcion("El objeto estadoDTO es nulo");

        Historial_EstadoDTO dto = new Historial_EstadoDTO();
        dto.setId(modelo.getId());
        dto.setBienDTO(
                modelo.getBien() != null ? bienMapper.convertirDTO(modelo.getBien()) : null
        );
        dto.setEstadoDTO(
                modelo.getEstado() != null ? estadoMapper.convertirDTO(modelo.getEstado()) : null
        );
        dto.setMotivo(modelo.getMotivo());
        dto.setFecha_cambio(modelo.getFecha_cambio());
        dto.setResponsableDTO(
                modelo.getResponsable() != null ? responsableMapper.convertirDTO(modelo.getResponsable()) : null
        );
        return dto;
    }

    @Override
    public Historial_Estado convertirModelo(Historial_EstadoDTO dto) {
        if (dto == null) throw new NegocioExcepcion("El objeto historial_estadoDTO es nulo");

        return new Historial_Estado(
            dto.getId(),
            dto.getBienDTO() != null ? bienMapper.convertirModelo(dto.getBienDTO()) : null,
            dto.getEstadoDTO() != null ? estadoMapper.convertirModelo(dto.getEstadoDTO()) : null,
            dto.getMotivo(),
            dto.getFecha_cambio(),
            dto.getResponsableDTO() != null ? responsableMapper.convertirModelo(dto.getResponsableDTO()) : null
        );
    }

    @Override
    public Historial_Estado mapDeResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
