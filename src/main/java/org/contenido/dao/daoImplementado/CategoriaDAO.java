package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.dto.CategoriaDTO;

import java.util.List;

public class CategoriaDAO implements DAO<CategoriaDTO> {
    @Override
    public void actualizar(CategoriaDTO entidad) {

    }

    @Override
    public CategoriaDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void registrar(CategoriaDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<CategoriaDTO> listarTodo() {
        return List.of();
    }
}
