package org.contenido.dao;

import java.util.List;

public interface DAO <T> extends CRUD<T> , Listable<T> {
    @Override
    void actualizar(T entidad);

    @Override
    T leerPorId(int idEntidad);

    @Override
    void registrar(T entidad);

    @Override
    void eliminar(int idEntidad);

    @Override
    List<T> listarTodo();
}
