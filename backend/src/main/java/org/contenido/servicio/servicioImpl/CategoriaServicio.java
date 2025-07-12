package org.contenido.servicio.servicioImpl;

import org.contenido.dao.daoImplementadoModelo.CategoriaDAO;
import org.contenido.dto.CategoriaDTO;
import org.contenido.excepcion.NegocioExcepcion;
import org.contenido.mapeo.mapeoImpl.CategoriaMapper;
import org.contenido.modelo.Categoria;
import org.contenido.servicio.Servicio;
import org.contenido.utilidad.ValidadorUtilidad;
import org.contenido.validacion.EnActualizar;
import org.contenido.validacion.EnCrear;
import org.contenido.validacion.EnLeer;

import java.util.List;

public class CategoriaServicio implements Servicio<CategoriaDTO> {
    private final CategoriaDAO categoriaDAO;
    private final CategoriaMapper categoriaMapper;

    public CategoriaServicio() {
        this.categoriaDAO = new CategoriaDAO();
        this.categoriaMapper = new CategoriaMapper();
    }

    @Override
    public void registrar(CategoriaDTO dto) {
        ValidadorUtilidad.validar(dto, EnCrear.class); //  Validamos todos los campos del DTO
        categoriaDAO.registrar(categoriaMapper.convertirModelo(dto)); //  Convertimos el DTO en un modelo, y se registra en la base de datos
    }

    @Override
    public CategoriaDTO leerPorId(int idDto) {
        return (categoriaDAO.leerPorId(idDto) != null) ?
                categoriaMapper.convertirDTO(categoriaDAO.leerPorId(idDto)) : null;
    }

    @Override
    public void actualizar(CategoriaDTO dto) {
        ValidadorUtilidad.validar(dto, EnLeer.class, EnActualizar.class); //  Validamos todos los campos del DTO
        Categoria modelo = categoriaMapper.convertirModelo(dto); //  Convertimos el DTO en un modelo
        if (categoriaDAO.leerPorId(modelo.getId()) == null) {
            throw new NegocioExcepcion("La categoría con el id " + modelo.getId() + " no existe.");
        }
        categoriaDAO.actualizar(modelo); //  Actualizamos el modelo en la base de datos
    }

    @Override
    public void eliminar(int idDto) {
        if (categoriaDAO.leerPorId(idDto) == null) {
            throw new NegocioExcepcion("La categoría con el id " + idDto + " no existe.");
        }
        categoriaDAO.eliminar(idDto);
    }

    @Override
    public List<CategoriaDTO> listarTodo() {
        return categoriaDAO.listarTodo().stream()
                .map(categoriaMapper::convertirDTO)
                .toList();
    }
}
