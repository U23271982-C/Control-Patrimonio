package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.modelo.Categoria;

import java.util.List;

public class CategoriaDAO implements DAO<Categoria> {
    @Override
    public void registrar(Categoria entidad) {

    }

    @Override
    public Categoria leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Categoria entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Categoria> listarTodo() {
        return List.of();
    }
}
