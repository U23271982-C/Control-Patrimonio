package org.contenido.servicio;

import org.contenido.dao.daoImplementado.BienDAO;
import org.contenido.dto.BienDTO;
import org.contenido.mapeo.BienMapper;

import java.util.List;

public class BienServicio implements Servicio<BienDTO> {
    private BienDAO bienDAO;
    private BienMapper bienMapper;

    public BienServicio() {
        this.bienDAO = new BienDAO();
        this.bienMapper = new BienMapper();
    }

    @Override
    public void registrar(BienDTO entidad) {

    }

    @Override
    public BienDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(BienDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<BienDTO> listarTodo() {
        return List.of();
    }
}
