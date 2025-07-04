package org.contenido.servicio.servicioImpl;

import org.contenido.dao.daoImplementadoModelo.Historial_EstadoDAO;
import org.contenido.dto.Historial_EstadoDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.mapeoImpl.Historial_EstadoMapper;
import org.contenido.modelo.Historial_Estado;
import org.contenido.servicio.Servicio;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnCrear;
import org.contenido.validacion.EnLeer;

import java.util.List;

public class Historial_EstadoServicio implements Servicio<Historial_EstadoDTO> {

    private final Historial_EstadoDAO historial_estadoDAO;
    private final Historial_EstadoMapper historial_estadoMapper;

    public Historial_EstadoServicio() {
        this.historial_estadoDAO = new Historial_EstadoDAO();
        this.historial_estadoMapper = new Historial_EstadoMapper();
    }

    @Override
    public void registrar(Historial_EstadoDTO dto) {
        ValidadorUtilidad.validar(dto, EnCrear.class);
        ValidadorUtilidad.validar(dto.getBienDTO(), EnLeer.class);
        ValidadorUtilidad.validar(dto.getEstadoDTO(), EnLeer.class);
        ValidadorUtilidad.validar(dto.getResponsableDTO(), EnLeer.class);
        historial_estadoDAO.registrar(historial_estadoMapper.convertirModelo(dto));
    }

    @Override
    public Historial_EstadoDTO leerPorId(int idDto) {
        return null;
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
