package org.contenido.controlador.controladorImpl;

import org.contenido.controlador.Controlador;
import org.contenido.dto.Detalle_InventarioDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.modelo.Detalle_Inventario;
import org.contenido.servicio.servicioImpl.Detalle_InventarioServicio;
import org.contenido.utilidad.NotificacionUtil;

import java.util.List;

public class Detalle_InventarioControlador implements Controlador<Detalle_InventarioDTO> {
    private Detalle_InventarioServicio detalle_InventarioServicio;

    public Detalle_InventarioControlador() {
        this.detalle_InventarioServicio = new Detalle_InventarioServicio();
    }

    @Override
    public void registrar(Detalle_InventarioDTO dto) {
        try {
            detalle_InventarioServicio.registrar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Detalle de inventario registrado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public Detalle_InventarioDTO leerPorId(int idDto) {
        try {
            Detalle_InventarioDTO newDTO = detalle_InventarioServicio.leerPorId(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Detalle de inventario leído correctamente.");
            return newDTO;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }

    @Override
    public void actualizar(Detalle_InventarioDTO dto) {
        try {
            detalle_InventarioServicio.actualizar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Detalle de inventario actualizado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public void eliminar(int idDto) {
        try {
            detalle_InventarioServicio.eliminar(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Detalle de inventario eliminado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public List<Detalle_InventarioDTO> listarTodo() {
        try {
            List<Detalle_InventarioDTO> detalle_inventarios = detalle_InventarioServicio.listarTodo();
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Detalles de inventarios listados correctamente.");
            return detalle_inventarios;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }

    public void registrarDetalleInventarioBienesActivos(Detalle_InventarioDTO dto) {
        try {
            detalle_InventarioServicio.registrarDetalleInventarioBienesActivos(dto);
            NotificacionUtil.mostrarMensajeAfirmacion
                    ("✅ Se registraron correctamente el detalle de inventarios bienes activos correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }
}
