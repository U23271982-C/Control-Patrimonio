package org.contenido.mapeo;

import org.contenido.dto.InventarioDTO;
import org.contenido.modelo.Inventario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventarioMapper implements Convertidor<Inventario, InventarioDTO>, ResultSetMapper<Inventario>{
    public InventarioMapper() {}

    @Override
    public InventarioDTO convertirDTO(Inventario modelo) {
        InventarioDTO dto = new InventarioDTO();
        dto.setId(modelo.getId());
        dto.setNombre(modelo.getNombre());
        dto.setDescripcion(modelo.getDescripcion());
        dto.setFechaInicio(modelo.getFechaInicio());
        dto.setFechaFin(modelo.getFechaFin());

        return dto;
    }

    @Override
    public Inventario convertirModelo(InventarioDTO dto) {
        Inventario modelo = new Inventario();
        modelo.setId(dto.getId());
        modelo.setNombre(dto.getNombre());
        modelo.setDescripcion(dto.getDescripcion());
        modelo.setFechaInicio(dto.getFechaInicio());
        modelo.setFechaFin(dto.getFechaFin());

        return modelo;
    }

    @Override
    public Inventario mapDeResultSet(ResultSet rs) throws SQLException {
        Inventario entidad = new Inventario();
        entidad.setId(rs.getInt(1));
        entidad.setNombre(rs.getString(2));
        entidad.setDescripcion(rs.getString(3));
        entidad.setFechaInicio(rs.getDate(4).toLocalDate());
        entidad.setFechaFin(rs.getDate(5).toLocalDate());

        return entidad;
    }
}
