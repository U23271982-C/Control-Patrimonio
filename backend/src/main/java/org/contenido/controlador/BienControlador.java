package org.contenido.controlador;

import org.contenido.dto.BienDTO;
import org.contenido.servicio.servicioImpl.BienServicio;
import org.contenido.utilidad.NotificacionUtil;

import java.util.List;

public class BienControlador implements Controlador<BienDTO>{
    private BienServicio bienServicio;

    public BienControlador() {
        this.bienServicio = new BienServicio();
    }

    @Override
    public void registrar(BienDTO dto) {
        try {
            bienServicio.registrar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Bien registrado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public BienDTO leerPorId(int idDto) {
        try {
            BienDTO newDTO = bienServicio.leerPorId(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Bien leído correctamente.");
            return newDTO;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }

    @Override
    public void actualizar(BienDTO dto) {
        try {
            bienServicio.actualizar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Bien actualizado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public void eliminar(int idDto) {
        try {
            bienServicio.eliminar(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Bien eliminado correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public List<BienDTO> listarTodo() {
        try {
            List<BienDTO> bienes = bienServicio.listarTodo();
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Bienes listados correctamente.");
            return bienes;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }
}
