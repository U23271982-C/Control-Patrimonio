package org.contenido.servicio.servicioImpl;

import org.contenido.dto.InventarioDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.mapeoImpl.InventarioMapper;
import org.contenido.modelo.Inventario;
import org.contenido.servicio.Servicio;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnCrear;
import org.contenido.validacion.EnLeer;

import java.util.List;
import org.contenido.dao.daoImplementadoModelo.InventarioDAO;

public class InventarioServicio implements Servicio<InventarioDTO> {
    private final InventarioDAO inventarioDAO;
    private final InventarioMapper inventarioMapper;

    public InventarioServicio() {
        this.inventarioDAO = new InventarioDAO();
        this.inventarioMapper = new InventarioMapper();
    }

    @Override
    public void registrar(InventarioDTO dto) {
        ValidadorUtilidad.validar(dto, EnCrear.class);
        inventarioDAO.registrar(inventarioMapper.convertirModelo(dto)); //  Convertimos el DTO en un modelo, y se registra en la base de datos

    }

    @Override
    public InventarioDTO leerPorId(int idDto) {
        return (inventarioDAO.leerPorId(idDto) != null) ?
                inventarioMapper.convertirDTO(inventarioDAO.leerPorId(idDto)) : null;
    }

    @Override
    public void actualizar(InventarioDTO dto) {
        ValidadorUtilidad.validar(dto, EnLeer.class); //  Validamos todos los campos del DTO
        Inventario modelo = inventarioMapper.convertirModelo(dto); //  Convertimos el DTO en un modelo
        if (inventarioDAO.leerPorId(modelo.getId()) == null) {
            throw new NegocioExcepcion("El inventario con el id " + modelo.getId() + " no existe.");
        }
        inventarioDAO.actualizar(modelo); //  Actualizamos el modelo en la base de datos
    }

    @Override
    public void eliminar(int idDto) {
        if (inventarioDAO.leerPorId(idDto) == null) {
            throw new NegocioExcepcion("El inventario con el id " + idDto + " no existe.");
        }
        inventarioDAO.eliminar(idDto);
    }

    @Override
    public List<InventarioDTO> listarTodo() {
        return inventarioDAO.listarTodo().stream()
                .map(inventarioMapper::convertirDTO)
                .toList();
    }
}
