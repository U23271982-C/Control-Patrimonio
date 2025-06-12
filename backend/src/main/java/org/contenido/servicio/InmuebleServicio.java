package org.contenido.servicio;

import org.contenido.dao.daoImplementado.InmuebleDAO;
import org.contenido.dto.InmuebleDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.mapeoImpl.InmuebleMapper;
import org.contenido.modelo.Inmueble;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnCrear;
import org.contenido.validacion.EnLeer;

import java.util.List;

public class InmuebleServicio implements Servicio<InmuebleDTO>{
    private InmuebleDAO inmuebleDAO;
    private InmuebleMapper inmuebleMapper;

    public InmuebleServicio() {
        this.inmuebleDAO = new InmuebleDAO();
        this.inmuebleMapper = new InmuebleMapper();
    }

    @Override
    public void registrar(InmuebleDTO dto) {
        ValidadorUtilidad.validar(dto, EnCrear.class);
        inmuebleDAO.registrar(inmuebleMapper.convertirModelo(dto));
    }

    @Override
    public InmuebleDTO leerPorId(int idDto) {
        return (inmuebleDAO.leerPorId(idDto) != null) ?
                inmuebleMapper.convertirDTO(inmuebleDAO.leerPorId(idDto)) : null;
    }

    @Override
    public void actualizar(InmuebleDTO dto) {
        ValidadorUtilidad.validar(dto, EnLeer.class); //  Validamos todos los campos del DTO
        Inmueble modelo = inmuebleMapper.convertirModelo(dto); //  Convertimos el DTO en un modelo
        if (inmuebleDAO.leerPorId(modelo.getId()) == null) {
            throw new NegocioExcepcion("El inmueble con el id " + modelo.getId() + " no existe.");
        }
        inmuebleDAO.actualizar(modelo); //  Actualizamos el modelo en la base de datos
    }

    @Override
    public void eliminar(int idDto) {
        if (inmuebleDAO.leerPorId(idDto) == null) {
            throw new NegocioExcepcion("El inmueble con el id " + idDto + " no existe.");
        }
        inmuebleDAO.eliminar(idDto);
    }

    @Override
    public List<InmuebleDTO> listarTodo() {
        return inmuebleDAO.listarTodo()
                .stream()
                .map(inmuebleMapper::convertirDTO)
                .toList();
    }
}
