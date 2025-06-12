package org.contenido.controlador;

import org.contenido.dto.AmbienteDTO;
import org.contenido.servicio.servicioImpl.AmbienteServicio;
import org.contenido.utilidad.NotificacionUtil;

import java.util.List;

public class AmbienteControlador implements Controlador<AmbienteDTO>{
    private final AmbienteServicio ambienteServicio;

    public AmbienteControlador() {
        this.ambienteServicio = new AmbienteServicio();
    }

    @Override
    public void registrar(AmbienteDTO dto) {
        try {
            ambienteServicio.registrar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Ambiente registrado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public AmbienteDTO leerPorId(int idDto) {
        try {
            AmbienteDTO newDTO = ambienteServicio.leerPorId(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Ambiente leído correctamente.");
            return newDTO;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }

    @Override
    public void actualizar(AmbienteDTO dto) {
        try {
            ambienteServicio.actualizar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Ambiente actualizado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public void eliminar(int idDto) {
        try {
            ambienteServicio.eliminar(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Ambiente eliminado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public List<AmbienteDTO> listarTodo() {
        try {
            List<AmbienteDTO> ambientes = ambienteServicio.listarTodo();
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Ambientes listados correctamente.");
            return ambientes;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }
}
