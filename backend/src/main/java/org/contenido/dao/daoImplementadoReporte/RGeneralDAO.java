package org.contenido.dao.daoImplementadoReporte;

import org.contenido.dao.Consultable;

public interface RGeneralDAO extends Consultable<String> {
    @Override
    String[][] consultar();
}
