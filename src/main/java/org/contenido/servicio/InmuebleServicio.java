package org.contenido.servicio;

import org.contenido.dao.daoImplementado.InmuebleDAO;
import org.contenido.dto.InmuebleDTO;
import org.contenido.mapeo.InmuebleMapper;
import java.util.List;

public class InmuebleServicio implements Servicio<InmuebleDTO>{
    private InmuebleDAO inmuebleDAO;
    private InmuebleMapper inmuebleMapper;

    public InmuebleServicio() {
        this.inmuebleDAO = new InmuebleDAO();
        this.inmuebleMapper = new InmuebleMapper();
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
