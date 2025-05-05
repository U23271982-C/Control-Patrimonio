package org.contenido.dao;

import java.util.List;

public interface Servicio <T> extends CRUD<T>, Listar<T> {
    @Override
    void registrar(T entidad);

    @Override
    T leerId(int idEntidad);

    @Override
    void actualizar(T entidad);

    @Override
    void eliminar(int idEntidad);

    @Override
    List<T> listar();
}
