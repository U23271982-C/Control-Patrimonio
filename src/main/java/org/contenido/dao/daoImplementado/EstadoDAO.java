package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.dto.EstadoDTO;

import java.util.List;

public class EstadoDAO implements DAO<EstadoDTO> {
    @Override
    public void registrar(EstadoDTO entidad) {

    }

    @Override
    public EstadoDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(EstadoDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<EstadoDTO> listarTodo() {
        return List.of();
    }
}
