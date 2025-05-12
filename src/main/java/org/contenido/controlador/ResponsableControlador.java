package org.contenido.controlador;

import org.contenido.dto.ResponsableDTO;
import org.contenido.servicio.ResponsableServicio;
import org.contenido.utilidad.NotificacionUtil;

import java.util.List;

public class ResponsableControlador implements Controlador<ResponsableDTO> {
    private ResponsableServicio responsableServicio;

    public ResponsableControlador() {
        this.responsableServicio = new ResponsableServicio();
    }

    @Override
    public void registrar(ResponsableDTO dto) {
        try {
            responsableServicio.registrar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Responsable registrado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public ResponsableDTO leerPorId(int idDto) {
        try {
            ResponsableDTO newDTO = responsableServicio.leerPorId(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Responsable leído correctamente.");
            return newDTO;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }

    @Override
    public void actualizar(ResponsableDTO dto) {
        try {
            responsableServicio.actualizar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Responsable actualizado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public void eliminar(int idDto) {
        try {
            responsableServicio.eliminar(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Responsable eliminado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public List<ResponsableDTO> listarTodo() {
        try {
            List<ResponsableDTO> responsables = responsableServicio.listarTodo();
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Responsables listados correctamente.");
            return responsables;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }
}
