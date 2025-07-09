package org.contenido.mapeo.mapeoImpl;

import org.contenido.dto.Historial_EstadoDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.Convertidor;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.*;

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
        dto.setResponsableDTO(
                modelo.getResponsable() != null ? responsableMapper.convertirDTO(modelo.getResponsable()) : null
        );
        dto.setFecha_cambio(modelo.getFecha_cambio());
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
        Rol_Responsable rol_responsable= new Rol_Responsable(rs.getInt(12),rs.getString(14),rs.getString(13));
        Responsable responsable= new Responsable(rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rol_responsable,rs.getString(10),rs.getString(11));
        Estado estado = new Estado(rs.getInt(4),rs.getString(5));
        Bien bien = new Bien(rs.getInt(2),rs.getString(3),null,null,null,null,null,null);
        Historial_Estado entidad = new Historial_Estado(rs.getInt(1),bien,estado,rs.getString(15),(rs.getDate(16)).toLocalDate(),responsable);
        return entidad;
    }
}
