package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.modelo.Ambiente;
import java.util.List;

public class AmbienteDAO implements DAO<Ambiente> {
    @Override
    public void registrar(Ambiente entidad) {

    }

    @Override
    public Ambiente leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Ambiente entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Ambiente> listarTodo() {
        return List.of();
    }
}
