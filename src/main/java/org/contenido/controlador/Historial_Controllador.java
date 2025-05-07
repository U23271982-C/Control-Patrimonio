package org.contenido.controlador;

import org.contenido.dao.CRUD;
import org.contenido.dao.Listable;

import java.util.List;

public interface Historial_Controllador <T> extends CRUD<T>, Listable<T> {
    @Override
    void actualizar(T entidad);

    @Override
    void eliminar(int idEntidad);

    @Override
    List<T> listarTodo();
}
