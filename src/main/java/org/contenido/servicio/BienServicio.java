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
    public void registrar(BienDTO dto) {

    }

    @Override
    public BienDTO leerPorId(int idDto) {
        return null;
    }

    @Override
    public void actualizar(BienDTO dto) {

    }

    @Override
    public void eliminar(int idDto) {

    }

    @Override
    public List<BienDTO> listarTodo() {
        return List.of();
    }
}
