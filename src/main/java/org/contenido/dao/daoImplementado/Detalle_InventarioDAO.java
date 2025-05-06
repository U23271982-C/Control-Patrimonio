package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.dto.Detalle_InventarioDTO;

import java.util.List;

public class Detalle_InventarioDAO implements DAO<Detalle_InventarioDTO> {
    @Override
    public void actualizar(Detalle_InventarioDTO entidad) {

    }

    @Override
    public Detalle_InventarioDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void registrar(Detalle_InventarioDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Detalle_InventarioDTO> listarTodo() {
        return List.of();
    }
}
