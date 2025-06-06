package org.contenido.dao.daoImplementado;

import org.contenido.dao.Historial_DAO;
import org.contenido.modelo.Historial_Estado;

import java.util.List;

public class Historial_EstadoDAO implements Historial_DAO<Historial_Estado> {
    @Override
    public void actualizar(Historial_Estado entidad) {

    }

    @Override
    public Historial_Estado leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Historial_Estado> listarTodo() {
        return List.of();
    }
}
