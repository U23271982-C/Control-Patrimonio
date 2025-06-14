package org.contenido.controlador.controladorImpl;

import org.contenido.controlador.Controlador;
import org.contenido.dto.CategoriaDTO;
import org.contenido.servicio.servicioImpl.CategoriaServicio;
import org.contenido.utilidad.NotificacionUtil;

import java.util.List;

public class CategoriaControlador implements Controlador<CategoriaDTO> {
    private CategoriaServicio categoriaServicio;

    public CategoriaControlador() {
        this.categoriaServicio = new CategoriaServicio();
    }

    @Override
    public void registrar(CategoriaDTO dto) {
        try {
            categoriaServicio.registrar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Categoría registrada correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public CategoriaDTO leerPorId(int idDto) {
        try {
            CategoriaDTO newDTO = categoriaServicio.leerPorId(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Categoría leída correctamente.");
            return newDTO;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }

    @Override
    public void actualizar(CategoriaDTO dto) {
        try {
            categoriaServicio.actualizar(dto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Categoría actualizada correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public void eliminar(int idDto) {
        try {
            categoriaServicio.eliminar(idDto);
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Categoría eliminada correctamente.");
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
    }

    @Override
    public List<CategoriaDTO> listarTodo() {
        try {
            List<CategoriaDTO> categorias = categoriaServicio.listarTodo();
            NotificacionUtil.mostrarMensajeAfirmacion("✅ Categorías listadas correctamente.");
            return categorias;
        } catch (Exception e) {
            NotificacionUtil.mostrarError(e);
        }
        return null;
    }
}
