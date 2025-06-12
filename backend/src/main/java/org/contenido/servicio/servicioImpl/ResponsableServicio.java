package org.contenido.servicio.servicioImpl;

import org.contenido.dao.daoImplementado.ResponsableDAO;
import org.contenido.dto.ResponsableDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.mapeoImpl.ResponsableMapper;
import org.contenido.modelo.Responsable;
import org.contenido.servicio.Servicio;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnCrear;
import org.contenido.validacion.EnLeer;

import java.util.List;

public class ResponsableServicio implements Servicio<ResponsableDTO> {
    private final ResponsableDAO responsableDAO;
    private final ResponsableMapper responsableMapper;

    public ResponsableServicio() {
        this.responsableDAO = new ResponsableDAO();
        this.responsableMapper = new ResponsableMapper();
    }

    @Override
    public void registrar(ResponsableDTO dto) {
        ValidadorUtilidad.validar(dto, EnCrear.class); //  Validamos todos los campos del DTO
        ValidadorUtilidad.validar(dto.getRol_ResponsableDTO(), EnLeer.class);
        responsableDAO.registrar(responsableMapper.convertirModelo(dto)); //  Convertimos el DTO en un modelo, y se registra en la base de datos
    }

    @Override
    public ResponsableDTO leerPorId(int idDto) {
        return (responsableDAO.leerPorId(idDto) != null) ?
                responsableMapper.convertirDTO(responsableDAO.leerPorId(idDto)) : null;
    }

    @Override
    public void actualizar(ResponsableDTO dto) {
        ValidadorUtilidad.validar(dto, EnLeer.class); //  Validamos todos los campos del DTO
        Responsable modelo = responsableMapper.convertirModelo(dto); //  Convertimos el DTO en un modelo
        if (responsableDAO.leerPorId(modelo.getId()) == null) {
            throw new NegocioExcepcion("El responsable con el id " + modelo.getId() + " no existe.");
        }
        responsableDAO.actualizar(modelo); //  Actualizamos el modelo en la base de datos
    }

    @Override
    public void eliminar(int idDto) {
        if (responsableDAO.leerPorId(idDto) == null) {
            throw new NegocioExcepcion("El responsable con el id " + idDto + " no existe.");
        }
        responsableDAO.eliminar(idDto);
    }

    @Override
    public List<ResponsableDTO> listarTodo() {
        return responsableDAO.listarTodo().stream()
                .map(responsableMapper::convertirDTO)
                .toList();
    }
}
