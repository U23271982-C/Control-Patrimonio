package org.contenido.dao;

public interface CRUD <T> {
    void registrar(T entidad);
    T leerId(int idEntidad);
    void actualizar (T entidad);
    void eliminar (int idEntidad);
}
