package org.contenido.controlador;

import org.contenido.dto.CategoriaDTO;
import org.contenido.servicio.CategoriaServicio;

import java.util.List;

public class CategoriaControlador implements Controlador<CategoriaDTO> {
    private CategoriaServicio categoriaServicio;

    public CategoriaControlador() {
        this.categoriaServicio = new CategoriaServicio();
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
