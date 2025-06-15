package org.contenido.mapeo.mapeoImpl;

import org.contenido.dto.ResponsableDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.Convertidor;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Responsable;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResponsableMapper implements Convertidor<Responsable, ResponsableDTO>, ResultSetMapper<Responsable> {
    private final Rol_ResponsableMapper rolResponsableMapper;
    public ResponsableMapper() {
        this.rolResponsableMapper = new Rol_ResponsableMapper();
    }

    @Override
    public ResponsableDTO convertirDTO(Responsable modelo) {
        ResponsableDTO dto = new ResponsableDTO();
        dto.setId(modelo.getId());
        dto.setNombre(modelo.getNombre());
        dto.setDni(modelo.getDni());
        dto.setEmail(modelo.getEmail());
        dto.setRol_responsableDTO(
                modelo.getRol_responsable() != null ?
                        rolResponsableMapper.convertirDTO(modelo.getRol_responsable()) : null
        );
        dto.setUsuario(modelo.getUsuario());
        dto.setContrsena(modelo.getContrasena());

        return dto;
    }

    @Override
    public Responsable convertirModelo(ResponsableDTO dto) {
        if (dto == null) throw new NegocioExcepcion("El objeto responsableDTO es nulo");

        return new Responsable(
                dto.getId(),
                dto.getNombre(),
                dto.getDni(),
                dto.getEmail(),
                dto.getRol_ResponsableDTO() != null ?
                        rolResponsableMapper.convertirModelo(dto.getRol_ResponsableDTO()) : null,
                dto.getUsuario(),
                dto.getContrsena()
        );
    }

    @Override
    public Responsable mapDeResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
