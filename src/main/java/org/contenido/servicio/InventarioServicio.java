package org.contenido.servicio;

import org.contenido.dao.DAO;
import org.contenido.dao.Servicio;
import org.contenido.dao.daoImplementado.InventarioDAO;
import org.contenido.dto.InventarioDTO;

import java.util.List;

public class InventarioServicio implements Servicio<InventarioDTO> {
    private InventarioDAO inventarioDAO;

    public InventarioServicio() {
        this.inventarioDAO = new InventarioDAO();
    }

    @Override
    public void registrar(InventarioDTO entidad) {
        // Falta lógica de negocio
        inventarioDAO.registrar(entidad);
    }

    @Override
    public InventarioDTO leerPorId(int idEntidad) {
        // Falta lógica de negocio
        return inventarioDAO.leerPorId(idEntidad);
    }

    @Override
    public void actualizar(InventarioDTO entidad) {
        // Falta lógica de negocio
        inventarioDAO.actualizar(entidad);
    }

    @Override
    public void eliminar(int idEntidad) {
        // Falta lógica de negocio
        inventarioDAO.eliminar(idEntidad);
    }

    @Override
    public List<InventarioDTO> listarTodo() {
        // Falta lógica de negocio
        return inventarioDAO.listarTodo();
    }
}
