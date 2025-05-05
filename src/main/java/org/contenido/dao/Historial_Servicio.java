package org.contenido.dao;

import java.util.List;

public interface Historial_Servicio <T> extends CRUD<T>, Listar<T> {
    @Override
    void actualizar(T entidad);

    @Override
    void eliminar(int idEntidad);

    @Override
    List<T> listar();
}
