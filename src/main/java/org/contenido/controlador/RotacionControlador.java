package org.contenido.controlador;

import org.contenido.dto.RotacionDTO;
import org.contenido.servicio.RotacionServicio;

import java.util.List;

public class RotacionControlador implements Controlador<RotacionDTO> {
    private RotacionServicio rotacionServicio;

    public RotacionControlador() {
        this.rotacionServicio = new RotacionServicio();
    }

    @Override
    public void registrar(RotacionDTO entidad) {

    }

    @Override
    public RotacionDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(RotacionDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<RotacionDTO> listarTodo() {
        return List.of();
    }
}
