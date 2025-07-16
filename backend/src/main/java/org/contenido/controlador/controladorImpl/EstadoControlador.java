package org.contenido.controlador.controladorImpl;

import org.contenido.controlador.Controlador;
import org.contenido.dto.EstadoDTO;
import org.contenido.servicio.servicioImpl.EstadoServicio;
import org.contenido.utilidad.NotificacionUtil;

import java.util.List;

public class EstadoControlador implements Controlador<EstadoDTO> {
    private EstadoServicio estadoServicio;

    public EstadoControlador() {
        this.estadoServicio = new EstadoServicio();
    }

    @Override
    public void registrar(EstadoDTO dto) {
        try {
            estadoServicio.registrar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Estado registrado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public EstadoDTO leerPorId(int idDto) {
        try {
            EstadoDTO newDTO = estadoServicio.leerPorId(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Estado leído correctamente.");
            return newDTO;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }

    @Override
    public void actualizar(EstadoDTO dto) {
        try {
            estadoServicio.actualizar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Estado actualizado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public void eliminar(int idDto) {
        try {
            estadoServicio.eliminar(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Estado eliminado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public List<EstadoDTO> listarTodo() {
        try {
            List<EstadoDTO> estados = estadoServicio.listarTodo();
            //NotificacionUtil.mostrarMensajeAfirmacion("✅ Estados listados correctamente.");
            return estados;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }
}
