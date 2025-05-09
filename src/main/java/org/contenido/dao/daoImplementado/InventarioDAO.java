package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.modelo.Inventario;

import java.util.List;

public class InventarioDAO implements DAO<Inventario> {
    @Override
    public void registrar(Inventario entidad) {

    }

    @Override
    public Inventario leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Inventario entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Inventario> listarTodo() {
        return List.of();
    }
}
