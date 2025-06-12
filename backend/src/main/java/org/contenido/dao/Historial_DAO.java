package org.contenido.dao;

import java.util.List;

public interface Historial_DAO <T> extends Actualizable<T>, Eliminable<T>, Listable<T>, Leible<T> {
    @Override
    void actualizar(T entidad);

    @Override
    void eliminar(int idEntidad);

    @Override
    List<T> listarTodo();

    @Override
    T leerPorId(int idEntidad);
}
