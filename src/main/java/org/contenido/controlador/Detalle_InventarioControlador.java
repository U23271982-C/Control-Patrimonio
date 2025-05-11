package org.contenido.controlador;

import org.contenido.dto.Detalle_InventarioDTO;
import org.contenido.servicio.Detalle_InventarioServicio;

import java.util.List;

public class Detalle_InventarioControlador implements Controlador<Detalle_InventarioDTO>{
    private Detalle_InventarioServicio detalle_InventarioServicio;

    public Detalle_InventarioControlador() {
        this.detalle_InventarioServicio = new Detalle_InventarioServicio();
    }

    @Override
    public void registrar(Detalle_InventarioDTO entidad) {

    }

    @Override
    public Detalle_InventarioDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Detalle_InventarioDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Detalle_InventarioDTO> listarTodo() {
        return List.of();
    }
}
