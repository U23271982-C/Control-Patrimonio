package org.contenido.controlador;

import org.contenido.dto.AsignacionDTO;
import org.contenido.servicio.AsignacionServicio;

import java.util.List;

public class AsignacionControlador implements Historial_Controlador<AsignacionDTO>{
    private AsignacionServicio asignacionServicio;

    public AsignacionControlador() {
        this.asignacionServicio = new AsignacionServicio();
    }

    @Override
    public void actualizar(AsignacionDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<AsignacionDTO> listarTodo() {
        return List.of();
    }
}
