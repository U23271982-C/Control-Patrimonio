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
        dto.setNombreRol(modelo.getNombreRol());
        dto.setDescripcion(modelo.getDescripcion());

        return dto;
    }

    @Override
    public Rol_Responsable convertirModelo(Rol_ResponsableDTO dto) {
        return new Rol_Responsable(dto.getId(), dto.getNombreRol(), dto.getDescripcion());
    }

    @Override
    public Rol_Responsable mapDeResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
