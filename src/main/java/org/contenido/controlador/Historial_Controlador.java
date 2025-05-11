package org.contenido.controlador;

import org.contenido.dao.Actualizable;
import org.contenido.dao.CRUD;
import org.contenido.dao.Eliminable;
import org.contenido.dao.Listable;

import java.util.List;

public interface Historial_Controlador<T> extends Eliminable<T>, Actualizable<T>, Listable<T> {
    @Override
    void actualizar(T entidad);

    @Override
    void eliminar(int idEntidad);

    @Override
    List<T> listarTodo();
}
