package org.contenido.controlador;

import org.contenido.dto.AmbienteDTO;
import org.contenido.servicio.AmbienteServicio;

import java.util.List;

public class AmbienteControlador implements Controlador<AmbienteDTO>{
    private final AmbienteServicio ambienteServicio;

    public AmbienteControlador() {
        this.ambienteServicio = new AmbienteServicio();
    }

    @Override
    public void registrar(AmbienteDTO entidad) {

    }

    @Override
    public AmbienteDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(AmbienteDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<AmbienteDTO> listarTodo() {
        return List.of();
    }
}
