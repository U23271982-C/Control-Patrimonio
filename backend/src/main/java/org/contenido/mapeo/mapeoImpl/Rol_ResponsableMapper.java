package org.contenido.mapeo.mapeoImpl;

import org.contenido.dto.Rol_ResponsableDTO;
import org.contenido.mapeo.Convertidor;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Rol_Responsable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Rol_ResponsableMapper implements Convertidor<Rol_Responsable, Rol_ResponsableDTO>, ResultSetMapper<Rol_Responsable> {
    public Rol_ResponsableMapper() {
    }

    @Override
    public Rol_ResponsableDTO convertirDTO(Rol_Responsable modelo) {

        Rol_ResponsableDTO dto = new Rol_ResponsableDTO();
        dto.setId(modelo.getId());
        dto.setDescripcion(modelo.getDescripcion());
        dto.setNombreRol(modelo.getNombreRol());

        return dto;
    }

    @Override
    public Rol_Responsable convertirModelo(Rol_ResponsableDTO dto) {
        return new Rol_Responsable(dto.getId(), dto.getDescripcion(),  dto.getNombreRol());
    }

    @Override
    public Rol_Responsable mapDeResultSet(ResultSet rs) throws SQLException {
        Rol_Responsable entidad = new Rol_Responsable(rs.getInt(1),rs.getString(2),rs.getString(3));
        return entidad;
    }
}
