package org.contenido.dao.daoImplementado;

import org.contenido.dao.Historial_DAO;
import org.contenido.dto.AsignacionDTO;

import java.util.List;

public class AsignacionDAO implements Historial_DAO<AsignacionDTO> {
    @Override
    public void actualizar(AsignacionDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<AsignacionDTO> listarTodo() {
        return List.of();
    }
}
