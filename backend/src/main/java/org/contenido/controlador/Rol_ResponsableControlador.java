package org.contenido.controlador;

import org.contenido.dto.Rol_ResponsableDTO;
import org.contenido.servicio.servicioImpl.Rol_ResponsableServicio;
import org.contenido.utilidad.NotificacionUtil;

import java.util.List;

public class Rol_ResponsableControlador implements Controlador<Rol_ResponsableDTO> {
    private Rol_ResponsableServicio rol_ResponsableServicio;

    public Rol_ResponsableControlador() {
        this.rol_ResponsableServicio = new Rol_ResponsableServicio();
    }

    @Override
    public void registrar(Rol_ResponsableDTO dto) {
        try {
            rol_ResponsableServicio.registrar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Rol responsable registrado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public Rol_ResponsableDTO leerPorId(int idDto) {
        try {
            Rol_ResponsableDTO newDTO = rol_ResponsableServicio.leerPorId(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Rol responsable leído correctamente.");
            return newDTO;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }

    @Override
    public void actualizar(Rol_ResponsableDTO dto) {
        try {
            rol_ResponsableServicio.actualizar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Rol responsable actualizado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public void eliminar(int idDto) {
        try {
            rol_ResponsableServicio.eliminar(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Rol responsable eliminado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public List<Rol_ResponsableDTO> listarTodo() {
        try {
            List<Rol_ResponsableDTO> rol_responsables = rol_ResponsableServicio.listarTodo();
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Rol responsables listados correctamente.");
            return rol_responsables;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }
}
