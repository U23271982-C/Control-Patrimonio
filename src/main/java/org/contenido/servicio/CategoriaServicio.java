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
    public void registrar(CategoriaDTO dto) {

    }

    @Override
    public CategoriaDTO leerPorId(int idDto) {
        return null;
    }

    @Override
    public void actualizar(CategoriaDTO dto) {

    }

    @Override
    public void eliminar(int idDto) {

    }

    @Override
    public List<CategoriaDTO> listarTodo() {
        return List.of();
    }
}
