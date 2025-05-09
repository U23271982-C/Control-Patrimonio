package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.dto.EstadoDTO;
import org.contenido.model.Estado;

import java.util.List;

public class EstadoDAO implements DAO<Estado> {
    @Override
    public void registrar(Estado entidad) {

    }

    @Override
    public Estado leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Estado entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Estado> listarTodo() {
        return List.of();
    }
}
