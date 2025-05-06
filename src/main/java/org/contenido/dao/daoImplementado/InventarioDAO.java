package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.dto.InventarioDTO;

import java.util.List;

public class InventarioDAO implements DAO<InventarioDTO> {
    @Override
    public void registrar(InventarioDTO entidad) {

    }

    @Override
    public InventarioDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(InventarioDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<InventarioDTO> listarTodo() {
        return List.of();
    }
}
