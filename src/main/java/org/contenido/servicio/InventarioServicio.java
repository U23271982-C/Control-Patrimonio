package org.contenido.servicio;

import org.contenido.dao.DAO;
import org.contenido.dao.daoImplementado.InventarioDAO;
import org.contenido.dto.InventarioDTO;
import org.contenido.mapeo.BienMapper;
import org.contenido.mapeo.InventarioMapper;
import org.contenido.modelo.Inventario;

import java.util.List;

public class InventarioServicio implements Servicio<InventarioDTO> {
    private InventarioDAO inventarioDAO;
    private InventarioMapper inventarioMapper;

    public InventarioServicio() {
        this.inventarioDAO = new InventarioDAO();
        this.inventarioMapper = new InventarioMapper();
    }

    @Override
    public void registrar(InventarioDTO entidad) {
        // Falta lógica de negocio
        Inventario modelo = inventarioMapper.convertirModelo(entidad);
        inventarioDAO.registrar(modelo);
    }

    @Override
    public InventarioDTO leerPorId(int idEntidad) {
        // Falta lógica de negocio
        return inventarioMapper.convertirDTO(inventarioDAO.leerPorId(idEntidad));
    }

    @Override
    public void actualizar(InventarioDTO entidad) {
        // Falta lógica de negocio
        Inventario modelo = inventarioMapper.convertirModelo(entidad);
        inventarioDAO.actualizar(modelo);
    }

    @Override
    public void eliminar(int idEntidad) {
        // Falta lógica de negocio
        inventarioDAO.eliminar(idEntidad);
    }

    @Override
    public List<InventarioDTO> listarTodo() {
        // Falta lógica de negocio
        return inventarioDAO.listarTodo()
                .stream()
                .map(inventarioMapper::convertirDTO)
                .toList();
    }
}
