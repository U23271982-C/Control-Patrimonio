package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.modelo.Bien;
import java.util.List;

public class BienDAO implements DAO<Bien> {
    @Override
    public void registrar(Bien entidad) {

    }

    @Override
    public Bien leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Bien entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Bien> listarTodo() {
        return List.of();
    }
}
