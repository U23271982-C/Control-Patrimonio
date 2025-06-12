package org.contenido.servicio.servicioImpl;

import org.contenido.dao.daoImplementado.Detalle_InventarioDAO;
import org.contenido.dto.Detalle_InventarioDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.mapeoImpl.Detalle_InventarioMapper;
import org.contenido.modelo.Detalle_Inventario;
import org.contenido.servicio.Servicio;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnCrear;
import org.contenido.validacion.EnLeer;

import java.util.List;

public class Detalle_InventarioServicio implements Servicio<Detalle_InventarioDTO> {
    private final Detalle_InventarioDAO detalleInventarioDAO;
    private final Detalle_InventarioMapper detalle_InventarioMapper;

    public Detalle_InventarioServicio() {
        this.detalleInventarioDAO = new Detalle_InventarioDAO();
        this.detalle_InventarioMapper = new Detalle_InventarioMapper();
    }

    @Override
    public void registrar(Detalle_InventarioDTO dto) {
        ValidadorUtilidad.validar(dto, EnCrear.class); //  Validamos todos los campos del DTO
        ValidadorUtilidad.validar(dto.getBienDTO(), EnLeer.class);
        ValidadorUtilidad.validar(dto.getInventarioDTO(), EnLeer.class);
        detalleInventarioDAO.registrar(detalle_InventarioMapper.convertirModelo(dto)); //  Convertimos el DTO en un modelo, y se registra en la base de datos
    }

    @Override
    public Detalle_InventarioDTO leerPorId(int idDto) {
        return (detalleInventarioDAO.leerPorId(idDto) != null) ?
                detalle_InventarioMapper.convertirDTO(detalleInventarioDAO.leerPorId(idDto)) : null;
    }

    @Override
    public void actualizar(Detalle_InventarioDTO dto) {
        ValidadorUtilidad.validar(dto, EnLeer.class); //  Validamos todos los campos del DTO
        Detalle_Inventario modelo = detalle_InventarioMapper.convertirModelo(dto); //  Convertimos el DTO en un modelo
        if (detalleInventarioDAO.leerPorId(modelo.getId()) == null) {
            throw new NegocioExcepcion("El detalle inventario con el id " + modelo.getId() + " no existe.");
        }
        detalleInventarioDAO.actualizar(modelo); //  Actualizamos el modelo en la base de datos
    }

    @Override
    public void eliminar(int idDto) {
        if (detalleInventarioDAO.leerPorId(idDto) == null) {
            throw new NegocioExcepcion("El detalle inventario con el id " + idDto + " no existe.");
        }
        detalleInventarioDAO.eliminar(idDto);
    }

    @Override
    public List<Detalle_InventarioDTO> listarTodo() {
        return detalleInventarioDAO.listarTodo().stream()
                .map(detalle_InventarioMapper::convertirDTO)
                .toList();
    }
}
