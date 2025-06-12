package org.contenido.mapeo.mapeoImpl;

import org.contenido.dto.CategoriaDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.Convertidor;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Categoria;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriaMapper implements Convertidor<Categoria, CategoriaDTO>, ResultSetMapper<Categoria> {
    public CategoriaMapper() {
    }

    @Override
    public CategoriaDTO convertirDTO(Categoria modelo) {
        if (modelo == null) throw new NegocioExcepcion("El objeto categoria es nulo");

        CategoriaDTO dto = new CategoriaDTO();
        dto.setId(modelo.getId());
        dto.setNombre(modelo.getNombre());
        dto.setDescripcion(modelo.getDescripcion());

        return dto;
    }

    @Override
    public Categoria convertirModelo(CategoriaDTO dto) {
        return new Categoria(dto.getId(), dto.getNombre(), dto.getDescripcion());
    }

    @Override
    public Categoria mapDeResultSet(ResultSet rs) throws SQLException {
        return null;
    }
}
