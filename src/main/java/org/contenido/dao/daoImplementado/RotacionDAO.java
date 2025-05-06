package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.dto.RotacionDTO;

import java.util.List;

public class RotacionDAO implements DAO<RotacionDTO> {
    @Override
    public void actualizar(RotacionDTO entidad) {

    }

    @Override
    public RotacionDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void registrar(RotacionDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<RotacionDTO> listarTodo() {
        return List.of();
    }
}
