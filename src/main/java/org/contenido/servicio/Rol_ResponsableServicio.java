package org.contenido.servicio;

import org.contenido.dao.daoImplementado.Rol_ResponsableDAO;
import org.contenido.dto.Rol_ResponsableDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.Rol_ResponsableMapper;
import org.contenido.modelo.Rol_Responsable;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnCrear;
import org.contenido.validacion.EnLeer;

import java.util.List;

public class Rol_ResponsableServicio implements Servicio<Rol_ResponsableDTO>{
    private Rol_ResponsableDAO rol_responsableDAO;
    private Rol_ResponsableMapper rol_responsableMapper;

    public Rol_ResponsableServicio() {
        this.rol_responsableDAO = new Rol_ResponsableDAO();
        this.rol_responsableMapper = new Rol_ResponsableMapper();
    }

    @Override
    public void registrar(Rol_ResponsableDTO dto) {
        ValidadorUtilidad.validar(dto, EnCrear.class);
        rol_responsableDAO.registrar(rol_responsableMapper.convertirModelo(dto));
    }

    @Override
    public Rol_ResponsableDTO leerPorId(int idDto) {
        return (rol_responsableDAO.leerPorId(idDto) != null) ?
                rol_responsableMapper.convertirDTO(rol_responsableDAO.leerPorId(idDto)) : null;
    }

    @Override
    public void actualizar(Rol_ResponsableDTO dto) {
        ValidadorUtilidad.validar(dto, EnLeer.class); //  Validamos todos los campos del DTO
        Rol_Responsable modelo = rol_responsableMapper.convertirModelo(dto); //  Convertimos el DTO en un modelo
        if (rol_responsableDAO.leerPorId(modelo.getId()) == null) {
            throw new NegocioExcepcion("El rol_responsable con el id " + modelo.getId() + " no existe.");
        }
        rol_responsableDAO.actualizar(modelo); //  Actualizamos el modelo en la base de datos
    }

    @Override
    public void eliminar(int idDto) {
        if (rol_responsableDAO.leerPorId(idDto) == null) {
            throw new NegocioExcepcion("El rol_responsable con el id " + idDto + " no existe.");
        }
        rol_responsableDAO.eliminar(idDto);
    }

    @Override
    public List<Rol_ResponsableDTO> listarTodo() {
        return rol_responsableDAO.listarTodo().stream()
                .map(rol_responsableMapper::convertirDTO)
                .toList();
    }
}
