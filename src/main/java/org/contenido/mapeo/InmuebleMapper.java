package org.contenido.mapeo;

import org.contenido.dto.InmuebleDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.modelo.Inmueble;

import java.sql.ResultSet;
import java.sql.SQLException;

public class InmuebleMapper implements Convertidor<Inmueble, InmuebleDTO>, ResultSetMapper<Inmueble>{

    public InmuebleMapper() {}

    @Override
    public InmuebleDTO convertirDTO(Inmueble modelo) {
        if(modelo == null) throw new NegocioExcepcion("El objeto inmueble no puede ser nulo");

        InmuebleDTO dto = new InmuebleDTO();
        dto.setId(modelo.getId());
        dto.setNombre(modelo.getNombre());
        dto.setDescripcion(modelo.getDescripcion());

        return dto;
    }

    @Override
    public Inmueble convertirModelo(InmuebleDTO dto) {
        if (dto == null) throw new NegocioExcepcion("El objeto inmuebleDTO no puede ser nulo");

        Inmueble modelo = new Inmueble();
        modelo.setId(dto.getId());
        modelo.setNombre(dto.getNombre());
        modelo.setDescripcion(dto.getDescripcion());

        return modelo;
    }

    @Override
    public Inmueble mapDeResultSet(ResultSet rs) throws SQLException {
        Inmueble entidad = new Inmueble();
        entidad.setId(rs.getInt(1));
        entidad.setNombre(rs.getString(2));
        entidad.setDescripcion(rs.getString(3));
        return entidad;
    }
}
