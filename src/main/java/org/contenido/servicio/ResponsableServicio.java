package org.contenido.servicio;

import org.contenido.dao.daoImplementado.ResponsableDAO;
import org.contenido.dto.ResponsableDTO;
import org.contenido.mapeo.ResponsableMapper;

import java.util.List;

public class ResponsableServicio implements Servicio<ResponsableDTO>{
    private ResponsableDAO responsableDAO;
    private ResponsableMapper responsableMapper;

    public ResponsableServicio() {
        this.responsableDAO = new ResponsableDAO();
        this.responsableMapper = new ResponsableMapper();
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
