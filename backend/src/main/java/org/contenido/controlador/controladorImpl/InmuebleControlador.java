package org.contenido.controlador.controladorImpl;

import org.contenido.controlador.Controlador;
import org.contenido.dto.InmuebleDTO;
import org.contenido.servicio.servicioImpl.InmuebleServicio;
import org.contenido.utilidad.NotificacionUtil;

import java.util.List;

public class InmuebleControlador implements Controlador<InmuebleDTO> {
    private InmuebleServicio inmuebleServicio;

    public InmuebleControlador() {
        this.inmuebleServicio = new InmuebleServicio();
    }

    @Override
    public void registrar(InmuebleDTO dto) {
        try {
            inmuebleServicio.registrar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Inmueble registrado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public InmuebleDTO leerPorId(int idDto) {
        try {
            InmuebleDTO newDTO = inmuebleServicio.leerPorId(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Inmueble leído correctamente.");
            return newDTO;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }

    @Override
    public void actualizar(InmuebleDTO dto) {
        try {
            inmuebleServicio.actualizar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Inmueble actualizado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public void eliminar(int idDto) {
        try {
            inmuebleServicio.eliminar(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Inmueble eliminado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public List<InmuebleDTO> listarTodo() {
        try {
            List<InmuebleDTO> inmuebles = inmuebleServicio.listarTodo();
            //NotificacionUtil.mostrarMensajeAfirmacion("✅ Inmuebles listados correctamente.");
            return inmuebles;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }
}
