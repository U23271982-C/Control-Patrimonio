package org.contenido.controlador.controladorImpl;

import org.contenido.controlador.Controlador;
import org.contenido.dto.Historial_EstadoDTO;
import org.contenido.servicio.servicioImpl.Historial_EstadoServicio;
import org.contenido.utilidad.NotificacionUtil;

import java.util.List;

public class Historial_EstadoControlador implements Controlador<Historial_EstadoDTO> {
    private Historial_EstadoServicio historial_EstadoServicio;

    public Historial_EstadoControlador() {
        this.historial_EstadoServicio = new Historial_EstadoServicio();
    }

    @Override
    public void registrar(Historial_EstadoDTO dto) {

    }

    @Override
    public Historial_EstadoDTO leerPorId(int idDto) {
        return null;
    }

    @Override
    public void actualizar(Historial_EstadoDTO dto) {
        try {
            historial_EstadoServicio.actualizar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Historial de estado actualizado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public void eliminar(int idDto) {
        try {
            historial_EstadoServicio.eliminar(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Historial de estado eliminado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public List<Historial_EstadoDTO> listarTodo() {
        try {
            List<Historial_EstadoDTO> historial_estados = historial_EstadoServicio.listarTodo();
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Historial de estados listados correctamente.");
            return historial_estados;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }
}
