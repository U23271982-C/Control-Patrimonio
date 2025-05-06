package org.contenido.dao;

import java.util.List;

public interface Controllador <T> extends CRUD<T>, Listable<T> {
    @Override
    void registrar(T entidad);

    @Override
    T leerPorId(int idEntidad);

    @Override
    void actualizar(T entidad);

    @Override
    void eliminar(int idEntidad);

    @Override
    List<T> listarTodo();
}
