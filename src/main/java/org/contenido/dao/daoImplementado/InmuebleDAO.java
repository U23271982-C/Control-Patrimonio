package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.model.Inmueble;

import java.util.List;

public class InmuebleDAO implements DAO<Inmueble> {
    @Override
    public void registrar(Inmueble entidad) {

    }

    @Override
    public Inmueble leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Inmueble entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Inmueble> listarTodo() {
        return List.of();
    }
}
