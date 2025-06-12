package org.contenido.servicio;

import org.contenido.dao.daoImplementado.AsignacionDAO;
import org.contenido.dto.AsignacionDTO;
import org.contenido.mapeo.AsignacionMapper;

import java.util.List;

public class AsignacionServicio implements Historial_Servicio<AsignacionDTO>{
    private AsignacionDAO asignacionDAO;
    private AsignacionMapper asignacionMapper;

    public AsignacionServicio() {
        this.asignacionDAO = new AsignacionDAO();
        this.asignacionMapper = new AsignacionMapper();
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
