package org.contenido.servicio;

import org.contenido.dao.daoImplementado.Detalle_InventarioDAO;
import org.contenido.dto.Detalle_InventarioDTO;
import org.contenido.mapeo.Detalle_InventarioMapper;

import java.util.List;

public class Detalle_InventarioServicio implements Servicio<Detalle_InventarioDTO>{
    private Detalle_InventarioDAO detalleInventarioDAO;
    private Detalle_InventarioMapper detalle_InventarioMapper;

    public Detalle_InventarioServicio() {
        this.detalleInventarioDAO = new Detalle_InventarioDAO();
        this.detalle_InventarioMapper = new Detalle_InventarioMapper();
    }

    @Override
    public void registrar(Detalle_InventarioDTO dto) {

    }

    @Override
    public Detalle_InventarioDTO leerPorId(int idDto) {
        return null;
    }

    @Override
    public void actualizar(Detalle_InventarioDTO dto) {

    }

    @Override
    public void eliminar(int idDto) {

    }

    @Override
    public List<Detalle_InventarioDTO> listarTodo() {
        return List.of();
    }
}
