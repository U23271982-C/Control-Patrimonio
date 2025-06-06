package org.contenido.servicio;

import org.contenido.dao.daoImplementado.AsignacionDAO;
import org.contenido.dto.AsignacionDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.AsignacionMapper;
import org.contenido.modelo.Asignacion;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnLeer;

import java.util.List;

public class AsignacionServicio implements Historial_Servicio<AsignacionDTO>{
    private AsignacionDAO asignacionDAO;
    private AsignacionMapper asignacionMapper;

    public AsignacionServicio() {
        this.asignacionDAO = new AsignacionDAO();
        this.asignacionMapper = new AsignacionMapper();
    }

    @Override
    public void actualizar(AsignacionDTO dto) {
        ValidadorUtilidad.validar(dto, EnLeer.class); //  Validamos todos los campos del DTO
        Asignacion modelo = asignacionMapper.convertirModelo(dto); //  Convertimos el DTO en un modelo
        if (asignacionDAO.leerPorId(modelo.getId()) == null) {
            throw new NegocioExcepcion("La asignación con el id " + modelo.getId() + " no existe.");
        }
        asignacionDAO.actualizar(modelo); //  Actualizamos el modelo en la base de datos
    }

    @Override
    public void eliminar(int idDto) {
        if (asignacionDAO.leerPorId(idDto) == null) {
            throw new NegocioExcepcion("La asignación con el id " + idDto + " no existe.");
        }
        asignacionDAO.eliminar(idDto);
    }

    @Override
    public List<AsignacionDTO> listarTodo() {
        return asignacionDAO.listarTodo().stream()
                .map(asignacionMapper::convertirDTO)
                .toList();
    }
}
