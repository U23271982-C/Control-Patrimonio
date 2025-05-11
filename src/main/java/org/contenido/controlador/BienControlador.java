package org.contenido.controlador;

import org.contenido.dto.BienDTO;
import org.contenido.servicio.BienServicio;

import java.util.List;

public class BienControlador implements Controlador<BienDTO>{
    private BienServicio bienServicio;

    public BienControlador() {
        this.bienServicio = new BienServicio();
    }

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
