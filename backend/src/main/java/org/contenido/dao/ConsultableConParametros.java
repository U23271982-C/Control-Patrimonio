package org.contenido.dao;

import java.util.List;

public interface ConsultableConParametros <T> {
    List<Object[]> consultarParametros(T param);
}
