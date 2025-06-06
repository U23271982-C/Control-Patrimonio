package org.contenido.servicio;

import org.contenido.dao.daoImplementado.Historial_EstadoDAO;
import org.contenido.dto.Historial_EstadoDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.Historial_EstadoMapper;
import org.contenido.modelo.Historial_Estado;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnLeer;

import java.util.List;

public class Historial_EstadoServicio implements Historial_Servicio<Historial_EstadoDTO>{

    private Historial_EstadoDAO historial_estadoDAO;
    private Historial_EstadoMapper historial_estadoMapper;

    public Historial_EstadoServicio() {
        this.historial_estadoDAO = new Historial_EstadoDAO();
        this.historial_estadoMapper = new Historial_EstadoMapper();
    }

    @Override
    public void actualizar(Historial_EstadoDTO dto) {
        ValidadorUtilidad.validar(dto, EnLeer.class); //  Validamos todos los campos del DTO
        Historial_Estado modelo = historial_estadoMapper.convertirModelo(dto); //  Convertimos el DTO en un modelo
        if (historial_estadoDAO.leerPorId(modelo.getId()) == null) {
            throw new NegocioExcepcion("El historial estado con el id " + modelo.getId() + " no existe.");
        }
        historial_estadoDAO.actualizar(modelo); //  Actualizamos el modelo en la base de datos
    }

    @Override
    public void eliminar(int idDto) {
        if (historial_estadoDAO.leerPorId(idDto) == null) {
            throw new NegocioExcepcion("El historial estado con el id " + idDto + " no existe.");
        }
        historial_estadoDAO.eliminar(idDto);
    }

    @Override
    public List<Historial_EstadoDTO> listarTodo() {
        return historial_estadoDAO.listarTodo().stream()
                .map(historial_estadoMapper::convertirDTO)
                .toList();
    }
}
