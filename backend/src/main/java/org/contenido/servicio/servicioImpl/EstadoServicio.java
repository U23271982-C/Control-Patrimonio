package org.contenido.servicio.servicioImpl;

import org.contenido.dao.daoImplementadoModelo.EstadoDAO;
import org.contenido.dto.EstadoDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.mapeoImpl.EstadoMapper;
import org.contenido.modelo.Estado;
import org.contenido.servicio.Servicio;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;
import org.contenido.validacion.EnLeer;

import java.util.List;

public class EstadoServicio implements Servicio<EstadoDTO> {
    private final EstadoDAO estadoDAO;
    private final EstadoMapper estadoMapper;

    public EstadoServicio() {
        this.estadoDAO = new EstadoDAO();
        this.estadoMapper = new EstadoMapper();
    }

    @Override
    public void registrar(EstadoDTO dto) {
        ValidadorUtilidad.validar(dto, EnCrear.class); //  Validamos todos los campos del DTO
        estadoDAO.registrar(estadoMapper.convertirModelo(dto)); //  Convertimos el DTO en un modelo, y se registra en la base de datos
    }

    @Override
    public EstadoDTO leerPorId(int idDto) {
        return (estadoDAO.leerPorId(idDto) != null) ?
                estadoMapper.convertirDTO(estadoDAO.leerPorId(idDto)) : null;
    }

    @Override
    public void actualizar(EstadoDTO dto) {
        ValidadorUtilidad.validar(dto, EnLeer.class, EnActualizar.class); //  Validamos todos los campos del DTO
        Estado modelo = estadoMapper.convertirModelo(dto); //  Convertimos el DTO en un modelo
        if (estadoDAO.leerPorId(modelo.getId()) == null) {
            throw new NegocioExcepcion("El estado con el id " + modelo.getId() + " no existe.");
        }
        estadoDAO.actualizar(modelo); //  Actualizamos el modelo en la base de datos
    }

    @Override
    public void eliminar(int idDto) {
        if (estadoDAO.leerPorId(idDto) == null) {
            throw new NegocioExcepcion("El estado con el id " + idDto + " no existe.");
        }
        estadoDAO.eliminar(idDto);
    }

    @Override
    public List<EstadoDTO> listarTodo() {
        return estadoDAO.listarTodo().stream()
                .map(estadoMapper::convertirDTO)
                .toList();
    }
}
