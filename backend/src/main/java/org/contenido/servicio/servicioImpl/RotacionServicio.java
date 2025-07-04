package org.contenido.servicio.servicioImpl;

import org.contenido.dao.daoImplementadoModelo.RotacionDAO;
import org.contenido.dto.RotacionDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.mapeoImpl.RotacionMapper;
import org.contenido.modelo.Rotacion;
import org.contenido.servicio.Servicio;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnCrear;
import org.contenido.validacion.EnLeer;

import java.util.List;

public class RotacionServicio implements Servicio<RotacionDTO> {
    private final RotacionDAO rotacionDAO;
    private final RotacionMapper rotacionMapper;

    public RotacionServicio() {
        this.rotacionDAO = new RotacionDAO();
        this.rotacionMapper = new RotacionMapper();
    }

    @Override
    public void registrar(RotacionDTO dto) {
        ValidadorUtilidad.validar(dto, EnCrear.class);
        ValidadorUtilidad.validar(dto.getBienDTO(), EnLeer.class);
        ValidadorUtilidad.validar(dto.getAmbienteDTO(), EnLeer.class);
        ValidadorUtilidad.validar(dto.getResponsableDTO(), EnLeer.class);
        rotacionDAO.registrar(rotacionMapper.convertirModelo(dto));
    }

    @Override
    public RotacionDTO leerPorId(int idDto) {
        return null;
    }

    @Override
    public void actualizar(RotacionDTO dto) {
        ValidadorUtilidad.validar(dto, EnLeer.class); //  Validamos todos los campos del DTO
        Rotacion modelo = rotacionMapper.convertirModelo(dto); //  Convertimos el DTO en un modelo
        if (rotacionDAO.leerPorId(modelo.getId()) == null) {
            throw new NegocioExcepcion("La rotación con el id " + modelo.getId() + " no existe.");
        }
        rotacionDAO.actualizar(modelo); //  Actualizamos el modelo en la base de datos
    }

    @Override
    public void eliminar(int idDto) {
        if (rotacionDAO.leerPorId(idDto) == null) {
            throw new NegocioExcepcion("La rotación con el id " + idDto + " no existe.");
        }
        rotacionDAO.eliminar(idDto);
    }

    @Override
    public List<RotacionDTO> listarTodo() {
        return rotacionDAO.listarTodo().stream()
                .map(rotacionMapper::convertirDTO)
                .toList();
    }
}
