package org.contenido.dao.daoImplementado;

import org.contenido.dao.Historial_DAO;
import org.contenido.modelo.Asignacion;

import java.util.List;

public class AsignacionDAO implements Historial_DAO<Asignacion> {
    @Override
    public void actualizar(Asignacion entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Asignacion> listarTodo() {
        return List.of();
    }
}
