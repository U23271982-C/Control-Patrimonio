package org.contenido.dao;

public interface CRUD <T> extends Registrable<T>, Leible<T>, Actualizable<T>, Eliminable<T> {
    @Override
    void actualizar(T entidad);

    @Override
    T leerPorId(int idEntidad);

    @Override
    void registrar(T entidad);

    @Override
    void eliminar(int idEntidad);
}
