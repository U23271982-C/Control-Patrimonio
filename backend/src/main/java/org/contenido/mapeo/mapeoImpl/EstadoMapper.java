package org.contenido.mapeo.mapeoImpl;

import org.contenido.dto.EstadoDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.Convertidor;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Estado;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EstadoMapper implements Convertidor<Estado,EstadoDTO>, ResultSetMapper<Estado> {

    public EstadoMapper() {
    }

    @Override
    public EstadoDTO convertirDTO(Estado modelo) {
        if(modelo == null) throw new NegocioExcepcion("El objeto estado es nulo");

        EstadoDTO dto = new EstadoDTO();
        dto.setId(modelo.getId());
        dto.setTipo(modelo.getTipo());

        return dto;
    }

    @Override
    public Estado convertirModelo(EstadoDTO dto) {
        if (dto == null) throw new NegocioExcepcion("El objeto estadoDTO es nulo");

        return new Estado(dto.getId(), dto.getTipo());
    }

    @Override
    public Estado mapDeResultSet(ResultSet rs) throws SQLException {
        Estado entidad = new Estado(rs.getInt(1),rs.getString(2));
        return entidad;
    }
}
