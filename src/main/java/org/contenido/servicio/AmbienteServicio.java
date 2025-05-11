package org.contenido.servicio;

import org.contenido.dao.daoImplementado.AmbienteDAO;
import org.contenido.dto.AmbienteDTO;
import org.contenido.mapeo.AmbienteMapper;

import java.util.List;

public class AmbienteServicio implements Servicio <AmbienteDTO>{
    private AmbienteDAO ambienteDAO;
    private AmbienteMapper ambienteMapper;

    public AmbienteServicio() {
        this.ambienteDAO = new AmbienteDAO();
        this.ambienteMapper = new AmbienteMapper();
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
