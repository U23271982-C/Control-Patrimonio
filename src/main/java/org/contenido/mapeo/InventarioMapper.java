package org.contenido.mapeo;

import org.contenido.dto.InventarioDTO;
import org.contenido.modelo.Inventario;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InventarioMapper implements Convertidor<Inventario, InventarioDTO>, ResultSetMapper<Inventario>{
    public InventarioMapper() {
    }

    @Override
    public InventarioDTO convertirDTO(Inventario modelo) {
        return null;
    }

    @Override
    public Inventario convertirModelo(InventarioDTO dto) {
        return null;
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
