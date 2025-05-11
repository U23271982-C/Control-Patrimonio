package org.contenido.controlador;

import org.contenido.dto.Rol_ResponsableDTO;
import org.contenido.servicio.Rol_ResponsableServicio;

import java.util.List;

public class Rol_ResponsableControlador implements Controlador<Rol_ResponsableDTO> {
    private Rol_ResponsableServicio rol_ResponsableServicio;

    public Rol_ResponsableControlador() {
        this.rol_ResponsableServicio = new Rol_ResponsableServicio();
    }

    @Override
    public void registrar(Rol_ResponsableDTO entidad) {

    }

    @Override
    public Rol_ResponsableDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Rol_ResponsableDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Rol_ResponsableDTO> listarTodo() {
        return List.of();
    }
}
