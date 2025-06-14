package org.contenido.controlador.controladorImpl;

import org.contenido.controlador.Controlador;
import org.contenido.dto.InventarioDTO;
import org.contenido.servicio.servicioImpl.InventarioServicio;
import org.contenido.utilidad.NotificacionUtil;

import java.util.List;

public class InventarioControlador implements Controlador<InventarioDTO> {
    private InventarioServicio inventarioServicio;

    public InventarioControlador() {
        this.inventarioServicio = new InventarioServicio();
    }

    @Override
    public void registrar(InventarioDTO dto) {
        try {
            inventarioServicio.registrar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Inventario registrado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public InventarioDTO leerPorId(int idDto) {
        try {
            InventarioDTO newDTO = inventarioServicio.leerPorId(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Inventario leído correctamente.");
            return newDTO;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }

    @Override
    public void actualizar(InventarioDTO dto) {
        try {
            inventarioServicio.actualizar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Inventario actualizado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public void eliminar(int idDto) {
        try {
            inventarioServicio.eliminar(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Inventario eliminado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public List<InventarioDTO> listarTodo() {
        try {
            List<InventarioDTO> inventarios = inventarioServicio.listarTodo();
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Inventarios listados correctamente.");
            return inventarios;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }
}
