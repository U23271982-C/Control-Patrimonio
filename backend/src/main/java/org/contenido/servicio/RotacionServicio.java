package org.contenido.servicio;

import org.contenido.dao.daoImplementado.RotacionDAO;
import org.contenido.dto.RotacionDTO;
import org.contenido.mapeo.RotacionMapper;

import java.util.List;

public class RotacionServicio implements Historial_Servicio<RotacionDTO>{
    private RotacionDAO rotacionDAO;
    private RotacionMapper rotacionMapper;

    public RotacionServicio() {
        this.rotacionDAO = new RotacionDAO();
        this.rotacionMapper = new RotacionMapper();
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
