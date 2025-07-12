package org.contenido.mapeo.mapeoImpl;

import org.contenido.dto.RotacionDTO;
import org.contenido.mapeo.Convertidor;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RotacionMapper implements Convertidor<Rotacion, RotacionDTO>, ResultSetMapper<Rotacion> {
    private final AmbienteMapper ambienteMapper;
    private final BienMapper bienMapper;
    private final ResponsableMapper responsableMapper;
    public RotacionMapper() {
        this.ambienteMapper = new AmbienteMapper();
        this.bienMapper = new BienMapper();
        this.responsableMapper = new ResponsableMapper();
    }

    @Override
    public RotacionDTO convertirDTO(Rotacion modelo) {
        RotacionDTO dto = new RotacionDTO();

        dto.setId(modelo.getId());
        dto.setMotivo(modelo.getMotivo());
        dto.setFecha(modelo.getFecha());
        dto.setBienDTO(
                modelo.getBien() != null ?
                        bienMapper.convertirDTO(modelo.getBien()) : null
        );
        dto.setAmbienteDTO(
                modelo.getAmbiente() != null ?
                ambienteMapper.convertirDTO(modelo.getAmbiente()) : null
        );

        dto.setResponsableDTO(
                modelo.getResponsable() != null ?
                responsableMapper.convertirDTO(modelo.getResponsable()) : null
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
                dto.getResponsableDTO() != null ? responsableMapper.convertirModelo(dto.getResponsableDTO()) : null,
                dto.getFecha()

        );
    }

    @Override
    public Rotacion mapDeResultSet(ResultSet rs) throws SQLException {
        Inmueble inmueble = new Inmueble(rs.getInt(18),rs.getString(19),rs.getString(20));
        Rol_Responsable rol_responsable= new Rol_Responsable(rs.getInt(15),rs.getString(16),rs.getString(17));
        Responsable responsable= new Responsable(rs.getInt(9),rs.getString(10),rs.getString(11),rs.getString(12),rol_responsable,rs.getString(13),rs.getString(14));
        Ambiente ambiente= new Ambiente(rs.getInt(7),rs.getString(8),inmueble);
        Bien bien = new Bien(rs.getInt(4), rs.getString(5),rs.getString(6),null,null,null,null,null,null);
        Rotacion entidad = new Rotacion(rs.getInt(1),bien,ambiente, rs.getString(2),responsable,(rs.getDate(3)).toLocalDate());
        return entidad;
    }
}
