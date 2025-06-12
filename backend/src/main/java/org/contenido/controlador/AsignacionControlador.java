package org.contenido.controlador;

import org.contenido.dto.AsignacionDTO;
import org.contenido.servicio.AsignacionServicio;
import org.contenido.utilidad.NotificacionUtil;

import java.util.List;

public class AsignacionControlador implements Historial_Controlador<AsignacionDTO>{
    private AsignacionServicio asignacionServicio;

    public AsignacionControlador() {
        this.asignacionServicio = new AsignacionServicio();
    }

    @Override
    public void actualizar(AsignacionDTO dto) {
        try {
            asignacionServicio.actualizar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Asignación actualizada correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public void eliminar(int idDto) {
        try {
            asignacionServicio.eliminar(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Asignación eliminada correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public List<AsignacionDTO> listarTodo() {
        try {
            List<AsignacionDTO> asignaciones = asignacionServicio.listarTodo();
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Asignaciones listadas correctamente.");
            return asignaciones;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }
}
