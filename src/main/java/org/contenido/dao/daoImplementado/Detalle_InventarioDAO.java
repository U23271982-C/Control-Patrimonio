package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.modelo.Detalle_Inventario;

import java.util.List;

public class Detalle_InventarioDAO implements DAO<Detalle_Inventario> {
    @Override
    public void registrar(Detalle_Inventario entidad) {

    }

    @Override
    public Detalle_Inventario leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Detalle_Inventario entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Detalle_Inventario> listarTodo() {
        return List.of();
    }
}
