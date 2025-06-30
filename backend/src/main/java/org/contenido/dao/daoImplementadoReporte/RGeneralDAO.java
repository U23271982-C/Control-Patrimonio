package org.contenido.dao.daoImplementadoReporte;

import org.contenido.dao.ConsultableSinParametros;

import java.util.List;


public interface RGeneralDAO extends ConsultableSinParametros {
    @Override
    List<Object[]> consultarSinParametros();
}
