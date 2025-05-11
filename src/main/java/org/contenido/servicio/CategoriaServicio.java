package org.contenido.servicio;

import org.contenido.dao.daoImplementado.CategoriaDAO;
import org.contenido.dto.CategoriaDTO;
import org.contenido.mapeo.CategoriaMapper;

import java.util.List;

public class CategoriaServicio implements Servicio<CategoriaDTO> {
    private CategoriaDAO categoriaDAO;
    private CategoriaMapper categoriaMapper;

    public CategoriaServicio() {
        this.categoriaDAO = new CategoriaDAO();
        this.categoriaMapper = new CategoriaMapper();
    }

    @Override
    public void registrar(CategoriaDTO entidad) {

    }

    @Override
    public CategoriaDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(CategoriaDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<CategoriaDTO> listarTodo() {
        return List.of();
    }
}
