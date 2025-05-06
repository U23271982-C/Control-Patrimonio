package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.dto.ResponsableDTO;

import java.util.List;

public class ResponsableDAO implements DAO<ResponsableDTO> {
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
