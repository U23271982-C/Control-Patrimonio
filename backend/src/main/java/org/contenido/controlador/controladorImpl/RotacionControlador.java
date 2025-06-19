package org.contenido.controlador.controladorImpl;

import org.contenido.controlador.Controlador;
import org.contenido.dto.RotacionDTO;
import org.contenido.servicio.servicioImpl.RotacionServicio;
import org.contenido.utilidad.NotificacionUtil;

import java.util.List;

public class RotacionControlador implements Controlador<RotacionDTO> {
    private RotacionServicio rotacionServicio;

    public RotacionControlador() {
        this.rotacionServicio = new RotacionServicio();
    }

    @Override
    public void registrar(RotacionDTO dto) {

    }

    @Override
    public RotacionDTO leerPorId(int idDto) {
        return null;
    }

    @Override
    public void actualizar(RotacionDTO dto) {
        try {
            rotacionServicio.actualizar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Rotación actualizada correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public void eliminar(int idDto) {
        try {
            rotacionServicio.eliminar(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Rotación eliminada correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public List<RotacionDTO> listarTodo() {
        try {
            List<RotacionDTO> rotaciones = rotacionServicio.listarTodo();
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Rotaciones listadas correctamente.");
            return rotaciones;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }
}
