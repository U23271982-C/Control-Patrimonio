package org.contenido.dao.daoImplementado;

import org.contenido.dao.Historial_DAO;
import org.contenido.mapeo.mapeoImpl.AsignacionMapper;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Asignacion;

import java.util.List;

public class AsignacionDAO implements Historial_DAO<Asignacion> {
    private final ResultSetMapper<Asignacion> mapper;

    public AsignacionDAO() {
        this.mapper = new AsignacionMapper();
    }

    @Override
    public void actualizar(Asignacion entidad) {

    }

    @Override
    public Asignacion leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Asignacion> listarTodo() {
        return List.of();
    }
}
