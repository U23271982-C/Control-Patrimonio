package org.contenido.controlador;

import org.contenido.dto.EstadoDTO;
import org.contenido.servicio.EstadoServicio;

import java.util.List;

public class EstadoControlador implements Controlador<EstadoDTO>{
    private EstadoServicio estadoServicio;

    public EstadoControlador() {
        this.estadoServicio = new EstadoServicio();
    }

    @Override
    public void registrar(EstadoDTO entidad) {

    }

    @Override
    public EstadoDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(EstadoDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<EstadoDTO> listarTodo() {
        return List.of();
    }
}
