package org.contenido.servicio;

import org.contenido.dao.daoImplementado.Rol_ResponsableDAO;
import org.contenido.dto.Rol_ResponsableDTO;
import org.contenido.mapeo.Rol_ResponsableMapper;

import java.util.List;

public class Rol_ResponsableServicio implements Servicio<Rol_ResponsableDTO>{
    private Rol_ResponsableDAO rol_responsableDAO;
    private Rol_ResponsableMapper rol_responsableMapper;

    public Rol_ResponsableServicio() {
        this.rol_responsableDAO = new Rol_ResponsableDAO();
        this.rol_responsableMapper = new Rol_ResponsableMapper();
    }

    @Override
    public void registrar(Rol_ResponsableDTO dto) {

    }

    @Override
    public Rol_ResponsableDTO leerPorId(int idDto) {
        return null;
    }

    @Override
    public void actualizar(Rol_ResponsableDTO dto) {

    }

    @Override
    public void eliminar(int idDto) {

    }

    @Override
    public List<Rol_ResponsableDTO> listarTodo() {
        return List.of();
    }
}
