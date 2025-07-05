package org.contenido.mapeo.mapeoImpl;

import org.contenido.dto.AmbienteDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.Convertidor;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Ambiente;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.contenido.modelo.Inmueble;

public class AmbienteMapper implements Convertidor<Ambiente, AmbienteDTO>, ResultSetMapper<Ambiente> {
    private final InmuebleMapper inmuebleMapper;
    public AmbienteMapper() {
        this.inmuebleMapper = new InmuebleMapper();
    }

    @Override
    public AmbienteDTO convertirDTO(Ambiente modelo) {
        if (modelo == null) throw new NegocioExcepcion("El objeto ambiente es nulo");

        AmbienteDTO dto = new AmbienteDTO();
        dto.setId(modelo.getId());
        dto.setNombre(modelo.getNombre());
        dto.setInmuebleDTO(
                // Si el inmueble es nulo, se deja en null en el DTO
                // Si no es nulo, se convierte a DTO
                modelo.getInmueble() != null ? inmuebleMapper.convertirDTO(modelo.getInmueble()) : null
        );

        return dto;
    }

    @Override
    public Ambiente convertirModelo(AmbienteDTO dto) {
        if (dto == null) throw new NegocioExcepcion("El objeto ambienteDTO es nulo");

        Ambiente model = new Ambiente();
        model.setId(dto.getId());
        model.setNombre(dto.getNombre());
        model.setInmueble(
                // Si el inmuebleDTO es nulo, se deja en null en el modelo
                // Si no es nulo, se convierte a modelo
                dto.getInmuebleDTO() != null ?
                        inmuebleMapper.convertirModelo(dto.getInmuebleDTO()) : null
        );
        return model;
    }
    @Override
    public Ambiente mapDeResultSet(ResultSet rs) throws SQLException {
        Inmueble inmueble = new Inmueble(rs.getInt(3),rs.getString(4),rs.getString(5));
        Ambiente entidad = new Ambiente(rs.getInt(1),rs.getString(2),inmueble);
        return entidad;
    }
}
