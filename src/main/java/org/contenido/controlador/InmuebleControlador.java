package org.contenido.controlador;

import org.contenido.dto.InmuebleDTO;
import org.contenido.servicio.InmuebleServicio;

import java.util.List;

public class InmuebleControlador implements Controlador<InmuebleDTO> {
    private InmuebleServicio inmuebleServicio;

    public InmuebleControlador() {
        this.inmuebleServicio = new InmuebleServicio();
    }

    @Override
    public void registrar(InmuebleDTO entidad) {

    }

    @Override
    public InmuebleDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(InmuebleDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<InmuebleDTO> listarTodo() {
        return List.of();
    }
}
