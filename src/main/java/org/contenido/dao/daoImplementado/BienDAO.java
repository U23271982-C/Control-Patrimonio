package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.dto.BienDTO;

import java.util.List;

public class BienDAO implements DAO<BienDTO> {
    @Override
    public void registrar(BienDTO entidad) {

    }

    @Override
    public BienDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(BienDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<BienDTO> listarTodo() {
        return List.of();
    }
}
