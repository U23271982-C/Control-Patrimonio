package org.contenido.servicio.servicioImpl;

import org.contenido.dao.daoImplementadoModelo.BienDAO;
import org.contenido.dto.BienDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.mapeoImpl.BienMapper;
import org.contenido.modelo.Bien;
import org.contenido.servicio.Servicio;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnCrear;
import org.contenido.validacion.EnLeer;

import java.util.List;

public class BienServicio implements Servicio<BienDTO> {
    private final BienDAO bienDAO;
    private final BienMapper bienMapper;

    public BienServicio() {
        this.bienDAO = new BienDAO();
        this.bienMapper = new BienMapper();
    }

    @Override
    public void registrar(BienDTO dto) {
        ValidadorUtilidad.validar(dto, EnCrear.class); //  Validamos todos los campos del DTO
        ValidadorUtilidad.validar(dto.getEstado_actualDTO(), EnLeer.class);
        ValidadorUtilidad.validar(dto.getAmbienteDTO(), EnLeer.class);
        ValidadorUtilidad.validar(dto.getCategoriaDTO(), EnLeer.class);
        ValidadorUtilidad.validar(dto.getResponsableDTO(), EnLeer.class);
        bienDAO.registrar(bienMapper.convertirModelo(dto)); //  Convertimos el DTO en un modelo, y se registra en la base de datos
    }

    @Override
    public BienDTO leerPorId(int idDto) {
        return (bienDAO.leerPorId(idDto) != null) ?
                bienMapper.convertirDTO(bienDAO.leerPorId(idDto)) : null;
    }

    @Override
    public void actualizar(BienDTO dto) {
        ValidadorUtilidad.validar(dto, EnLeer.class); //  Validamos todos los campos del DTO
        Bien modelo = bienMapper.convertirModelo(dto); //  Convertimos el DTO en un modelo
        if (bienDAO.leerPorId(modelo.getId()) == null) {
            throw new NegocioExcepcion("El bien con el id " + modelo.getId() + " no existe.");
        }
        bienDAO.actualizar(modelo); //  Actualizamos el modelo en la base de datos
    }

    @Override
    public void eliminar(int idDto) {
        if (bienDAO.leerPorId(idDto) == null) {
            throw new NegocioExcepcion("El ambiente con el id " + idDto + " no existe.");
        }
        bienDAO.eliminar(idDto);
    }

    @Override
    public List<BienDTO> listarTodo() {
        return bienDAO.listarTodo().stream()
                .map(bienMapper::convertirDTO)
                .toList();
    }
}
