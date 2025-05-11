package org.contenido.controlador;

import org.contenido.dto.ResponsableDTO;
import org.contenido.servicio.ResponsableServicio;

import java.util.List;

public class ResponsableControlador implements Controlador<ResponsableDTO> {
    private ResponsableServicio responsableServicio;

    public ResponsableControlador() {
        this.responsableServicio = new ResponsableServicio();
    }

    @Override
    public void registrar(ResponsableDTO entidad) {

    }

    @Override
    public ResponsableDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(ResponsableDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<ResponsableDTO> listarTodo() {
        return List.of();
    }
}
