package org.contenido.servicio;

import org.contenido.dao.daoImplementado.EstadoDAO;
import org.contenido.dto.EstadoDTO;
import org.contenido.mapeo.EstadoMapper;

import java.util.List;

public class EstadoServicio implements Servicio<EstadoDTO>{
    private EstadoDAO estadoDAO;
    private EstadoMapper estadoMapper;

    public EstadoServicio() {
        this.estadoDAO = new EstadoDAO();
        this.estadoMapper = new EstadoMapper();
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
