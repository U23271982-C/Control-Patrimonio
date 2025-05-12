package org.contenido.controlador;

import org.contenido.dao.CRUD;
import org.contenido.dao.Listable;

import java.util.List;

public interface Controlador<T> extends CRUD<T>, Listable<T> {
    @Override
    void registrar(T dto);

    @Override
    T leerPorId(int idDto);

    @Override
    void actualizar(T dto);

    @Override
    void eliminar(int idDto);

    @Override
    List<T> listarTodo();
}
