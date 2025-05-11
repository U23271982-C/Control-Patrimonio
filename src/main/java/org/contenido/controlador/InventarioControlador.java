package org.contenido.controlador;

import org.contenido.dto.InventarioDTO;
import org.contenido.servicio.InventarioServicio;

import java.util.List;

public class InventarioControlador implements Controlador<InventarioDTO> {
    private InventarioServicio inventarioServicio;

    public InventarioControlador() {
        this.inventarioServicio = new InventarioServicio();
    }

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
