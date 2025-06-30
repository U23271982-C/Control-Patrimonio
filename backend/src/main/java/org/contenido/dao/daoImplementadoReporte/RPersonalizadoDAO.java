package org.contenido.dao.daoImplementadoReporte;

import org.contenido.dao.ConsultableConParametros;
import org.contenido.dto.BienDTO;

import java.util.List;

public interface RPersonalizadoDAO extends ConsultableConParametros<BienDTO> {
    @Override
    List<Object[]> consultarParametros(BienDTO param);
}
