package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.dto.Rol_ResponsableDTO;
import org.contenido.model.Rol_Responsable;

import java.util.List;

public class Rol_ResponsableDAO implements DAO<Rol_Responsable> {
    @Override
    public void registrar(Rol_Responsable entidad) {

    }

    @Override
    public Rol_Responsable leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Rol_Responsable entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Rol_Responsable> listarTodo() {
        return List.of();
    }
}
