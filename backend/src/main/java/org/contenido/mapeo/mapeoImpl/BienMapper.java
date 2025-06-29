package org.contenido.mapeo.mapeoImpl;

import org.contenido.dto.BienDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.Convertidor;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.*;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BienMapper implements Convertidor<Bien, BienDTO>, ResultSetMapper<Bien> {
    private final EstadoMapper estadoMapper;
    private final CategoriaMapper categoriaMapper;
    private final AmbienteMapper ambienteMapper;
    private final ResponsableMapper responsableMapper;

    public BienMapper() {
        this.estadoMapper = new EstadoMapper();
        this.categoriaMapper = new CategoriaMapper();
        this.ambienteMapper = new AmbienteMapper();
        this.responsableMapper = new ResponsableMapper();
    }

    @Override
    public BienDTO convertirDTO(Bien modelo) {
        if(modelo == null) throw new NullPointerException("El objeto bien es nulo");

        BienDTO dto = new BienDTO();
        dto.setId(modelo.getId());
        dto.setNombre(modelo.getNombre());
        dto.setDescripcion(modelo.getDescripcion());
        dto.setFecha_registro(modelo.getFecha_registro());
        dto.setEstado_actualDTO(
                modelo.getEstado() != null ?
                        estadoMapper.convertirDTO(modelo.getEstado()) : null
        );
        dto.setCategoriaDTO(
                modelo.getCategoria() != null ?
                        categoriaMapper.convertirDTO(modelo.getCategoria()) : null
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
    public Bien convertirModelo(BienDTO dto) {
        if(dto == null) throw new NegocioExcepcion("El objeto bienDTO es nulo");

        return new Bien(
                dto.getId(),
                dto.getNombre(),
                dto.getDescripcion(),
                dto.getFecha_registro(),
                dto.getEstado_actualDTO() != null ?
                        estadoMapper.convertirModelo(dto.getEstado_actualDTO()) : null,
                dto.getCategoriaDTO() != null ?
                        categoriaMapper.convertirModelo(dto.getCategoriaDTO()) : null,
                dto.getAmbienteDTO() != null ?
                        ambienteMapper.convertirModelo(dto.getAmbienteDTO()) : null,
                dto.getResponsableDTO() != null ?
                        responsableMapper.convertirModelo(dto.getResponsableDTO()) : null
        );
    }

    @Override
    public Bien mapDeResultSet(ResultSet rs) throws SQLException {
        Estado estado = new Estado(rs.getInt(5),rs.getString(6));
        Categoria categoria= new Categoria(rs.getInt(7),rs.getString(8),rs.getString(9));
        Ambiente ambiente = new Ambiente(rs.getInt(10),rs.getString(11),null);
        Rol_Responsable rol_responsable = new Rol_Responsable(rs.getInt(18),rs.getString(20),rs.getString(19));
        Responsable responsable = new Responsable(rs.getInt(12),rs.getString(13),rs.getString(14),rs.getString(15),rol_responsable,rs.getString(16),rs.getString(17));
        Bien entidad = new Bien(rs.getInt(1),rs.getString(2),rs.getString(3),(rs.getDate(4)).toLocalDate(),estado,categoria,ambiente,responsable);
        return entidad;
    }
}
