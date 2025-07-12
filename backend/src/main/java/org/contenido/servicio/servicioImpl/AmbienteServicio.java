package org.contenido.servicio.servicioImpl;

import org.contenido.dao.daoImplementadoModelo.AmbienteDAO;
import org.contenido.dto.AmbienteDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.mapeoImpl.AmbienteMapper;
import org.contenido.modelo.Ambiente;
import org.contenido.servicio.Servicio;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;
import org.contenido.validacion.EnLeer;

import java.util.List;

public class AmbienteServicio implements Servicio<AmbienteDTO> {
    private final AmbienteDAO ambienteDAO;
    private final AmbienteMapper ambienteMapper;

    public AmbienteServicio() {
        this.ambienteDAO = new AmbienteDAO();
        this.ambienteMapper = new AmbienteMapper();
    }
    @Override
    public void registrar(AmbienteDTO dto) {
        ValidadorUtilidad.validar(dto, EnCrear.class); //  Validamos todos los campos del DTO
        ValidadorUtilidad.validar(dto.getInmuebleDTO(), EnLeer.class);
        ambienteDAO.registrar(ambienteMapper.convertirModelo(dto)); //  Convertimos el DTO en un modelo, y se registra en la base de datos
    }

    @Override
    public AmbienteDTO leerPorId(int idDto) {
        return (ambienteDAO.leerPorId(idDto) != null) ?
                ambienteMapper.convertirDTO(ambienteDAO.leerPorId(idDto)) : null;
    }

    @Override
    public void actualizar(AmbienteDTO dto) {
        ValidadorUtilidad.validar(dto, EnLeer.class, EnActualizar.class); //  Validamos todos los campos del DTO
        Ambiente modelo = ambienteMapper.convertirModelo(dto); //  Convertimos el DTO en un modelo
        if (ambienteDAO.leerPorId(modelo.getId()) == null) {
            throw new NegocioExcepcion("El ambiente con el id " + modelo.getId() + " no existe.");
        }
        ambienteDAO.actualizar(modelo); //  Actualizamos el modelo en la base de datos
    }

    @Override
    public void eliminar(int idDto) {
        if (ambienteDAO.leerPorId(idDto) == null) {
            throw new NegocioExcepcion("El ambiente con el id " + idDto + " no existe.");
        }
        ambienteDAO.eliminar(idDto);
    }

    @Override
    public List<AmbienteDTO> listarTodo() {
        return ambienteDAO.listarTodo().stream()
                .map(ambienteMapper::convertirDTO)
                .toList();
    }
}
