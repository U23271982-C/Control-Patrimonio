package org.contenido.servicio;

import org.contenido.dao.DAO;
import org.contenido.dto.InventarioDTO;

import java.util.List;

public class InventarioServicio implements Servicio<InventarioDTO> {
    private DAO<InventarioDTO> dao;

    public InventarioServicio(DAO dao){
        this.dao = dao;
    }

    @Override
    public void registrar(InventarioDTO entidad) {
        // Falta lógica de negocio
        dao.registrar(entidad);
    }

    @Override
    public InventarioDTO leerPorId(int idEntidad) {
        // Falta lógica de negocio
        return dao.leerPorId(idEntidad);
    }

    @Override
    public void actualizar(InventarioDTO entidad) {
        // Falta lógica de negocio
        dao.actualizar(entidad);
    }

    @Override
    public void eliminar(int idEntidad) {
        // Falta lógica de negocio
        dao.eliminar(idEntidad);
    }

    @Override
    public List<InventarioDTO> listarTodo() {
        // Falta lógica de negocio
        return dao.listarTodo();
    }
}
