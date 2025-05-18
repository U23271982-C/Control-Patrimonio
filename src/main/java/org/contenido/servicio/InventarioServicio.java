package org.contenido.servicio;

import org.contenido.dao.daoImplementado.InventarioDAO;
import org.contenido.dto.InventarioDTO;
import org.contenido.mapeo.InventarioMapper;
import org.contenido.modelo.Inventario;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnCrear;

import java.util.List;

public class InventarioServicio implements Servicio<InventarioDTO> {
    private InventarioDAO inventarioDAO;
    private InventarioMapper inventarioMapper;

    public InventarioServicio() {
        this.inventarioDAO = new InventarioDAO();
        this.inventarioMapper = new InventarioMapper();
    }

    @Override
    public void registrar(InventarioDTO dto) {
        ValidadorUtilidad.validar(dto, EnCrear.class);
        Inventario modelo = inventarioMapper.convertirModelo(dto);
        inventarioDAO.registrar(modelo);
    }

    @Override
    public InventarioDTO leerPorId(int idDto) {
        // Falta lógica de negocio
        return inventarioMapper.convertirDTO(inventarioDAO.leerPorId(idDto));
    }

    @Override
    public void actualizar(InventarioDTO dto) {
        // Falta lógica de negocio
        Inventario modelo = inventarioMapper.convertirModelo(dto);
        inventarioDAO.actualizar(modelo);
    }

    @Override
    public void eliminar(int idDto) {
        // Falta lógica de negocio
        inventarioDAO.eliminar(idDto);
    }

    @Override
    public List<InventarioDTO> listarTodo() {
        // Falta lógica de negocio
        return inventarioDAO.listarTodo()
                .stream()
                .map(inventarioMapper::convertirDTO)
                .toList();
    }
}
