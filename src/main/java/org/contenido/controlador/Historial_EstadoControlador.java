package org.contenido.controlador;

import org.contenido.dto.Historial_EstadoDTO;
import org.contenido.servicio.Historial_EstadoServicio;

import java.util.List;

public class Historial_EstadoControlador implements Historial_Controlador<Historial_EstadoDTO>{
    private Historial_EstadoServicio historial_EstadoServicio;

    public Historial_EstadoControlador() {
        this.historial_EstadoServicio = new Historial_EstadoServicio();
    }

    @Override
    public void actualizar(Historial_EstadoDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Historial_EstadoDTO> listarTodo() {
        return List.of();
    }
}
