package org.contenido.mapeo.mapeoImpl;

import org.contenido.dto.AsignacionDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.Convertidor;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Asignacion;
import org.contenido.modelo.Bien;
import org.contenido.modelo.Responsable;
import org.contenido.modelo.Rol_Responsable;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class AsignacionMapper implements Convertidor<Asignacion, AsignacionDTO>, ResultSetMapper<Asignacion> {
    private final BienMapper bienMapper;
    private final ResponsableMapper responsableMapper;
    public AsignacionMapper() {
        this.bienMapper = new BienMapper();
        this.responsableMapper = new ResponsableMapper();
    }

    @Override
    public AsignacionDTO convertirDTO(Asignacion modelo) {
        if(modelo == null) throw new NegocioExcepcion("El objeto asignacion es nulo");
        AsignacionDTO dto = new AsignacionDTO();
        dto.setId(modelo.getId());
        dto.setBienDTO(
                modelo.getBien() != null ? bienMapper.convertirDTO(modelo.getBien()) : null
        );
        dto.setResponsableDTO(
                modelo.getResponsable() != null ?
                        responsableMapper.convertirDTO(modelo.getResponsable()) : null
        );
        dto.setFecha_inicio(modelo.getFechaInicio());
        dto.setFecha_fin(modelo.getFechaFin());
        return dto;
    }

    @Override
    public Asignacion convertirModelo(AsignacionDTO dto) {
        if(dto == null) throw new NegocioExcepcion("El objeto asignacionDTO es nulo");
        Asignacion model = new Asignacion(
                dto.getId(),
                dto.getBienDTO() != null ? bienMapper.convertirModelo(dto.getBienDTO()) : null,
                dto.getResponsableDTO() != null ? responsableMapper.convertirModelo(dto.getResponsableDTO()) : null,
                dto.getFecha_inicio(),
                dto.getFecha_fin()
        );
        return model;
    }

    @Override
    public Asignacion mapDeResultSet(ResultSet rs) throws SQLException {
        Bien bien = new Bien(rs.getInt(2),rs.getString(3), null,null,null,null,null,null);
        Rol_Responsable rol_responsable =new Rol_Responsable(rs.getInt(10),rs.getString(12),rs.getString(11));
        Responsable responsable = new Responsable(rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rol_responsable,rs.getString(8),rs.getString(9));
        Asignacion entidad = new Asignacion(
                rs.getInt(1),
                bien,
                responsable,
                (rs.getDate(13)).toLocalDate(),
                (rs.getDate(14)).toLocalDate()

        );
        return entidad;
    }
}
