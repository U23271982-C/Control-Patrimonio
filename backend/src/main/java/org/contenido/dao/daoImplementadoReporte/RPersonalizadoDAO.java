package org.contenido.dao.daoImplementadoReporte;

import org.contenido.dao.Consultable;

public interface RPersonalizadoDAO extends Consultable<String> {
    @Override
    String[][] consultar();
}
