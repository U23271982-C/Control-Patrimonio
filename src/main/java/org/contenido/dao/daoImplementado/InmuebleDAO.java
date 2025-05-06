package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.dto.InmuebleDTO;

import java.util.List;

public class InmuebleDAO implements DAO<InmuebleDTO> {
    @Override
    public void registrar(InmuebleDTO entidad) {

    }

    @Override
    public InmuebleDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(InmuebleDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<InmuebleDTO> listarTodo() {
        return List.of();
    }
}
