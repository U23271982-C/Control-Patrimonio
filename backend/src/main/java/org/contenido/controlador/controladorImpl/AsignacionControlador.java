package org.contenido.controlador.controladorImpl;

import org.contenido.controlador.Controlador;
import org.contenido.dto.AsignacionDTO;
import org.contenido.servicio.servicioImpl.AsignacionServicio;
import org.contenido.utilidad.NotificacionUtil;

import java.util.List;

public class AsignacionControlador implements Controlador<AsignacionDTO> {
    private AsignacionServicio asignacionServicio;

    public AsignacionControlador() {
        this.asignacionServicio = new AsignacionServicio();
    }

    @Override
    public void registrar(AsignacionDTO dto) {
        try {
            asignacionServicio.registrar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Asignación creada correctamente.");
        } catch (Exception e){
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public AsignacionDTO leerPorId(int idDto) {
        return null;
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
