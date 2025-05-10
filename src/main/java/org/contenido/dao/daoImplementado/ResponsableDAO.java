package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.modelo.Responsable;

import java.util.List;

public class ResponsableDAO implements DAO<Responsable> {
    @Override
    public void registrar(Responsable entidad) {

    }

    @Override
    public Responsable leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Responsable entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Responsable> listarTodo() {
        return List.of();
    }
}
