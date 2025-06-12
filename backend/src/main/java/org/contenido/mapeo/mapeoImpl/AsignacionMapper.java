package org.contenido.mapeo.mapeoImpl;

import org.contenido.dto.AsignacionDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.Convertidor;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Asignacion;

import java.sql.ResultSet;
import java.sql.SQLException;

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
        // Falta porque no estan los procedimientos almacenados listar
        // El orden segun como se liste en el procedimiento almacenado
        /*return new Asignacion(
                rs.getInt(1),
                bienMapper.mapDeResultSet(rs),
                responsableMapper.mapDeResultSet(rs),
                rs.getObject(4, java.time.LocalDate.class),
                rs.getObject(5, java.time.LocalDate.class)
        );*/
        return null;
    }
}
