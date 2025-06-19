package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.mapeo.mapeoImpl.AsignacionMapper;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Asignacion;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AsignacionDAO implements DAO<Asignacion> {
    private final ResultSetMapper<Asignacion> mapper;

    public AsignacionDAO() {
        this.mapper = new AsignacionMapper();
    }

    @Override
    public void registrar(Asignacion entidad) {
        String sql = "{ CALL pa_Registrar_Asignacion(?, ?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, entidad.getBien().getId());
            stmt.setInt(2, entidad.getResponsable().getId());
            stmt.setDate(3, java.sql.Date.valueOf(entidad.getFechaInicio()));
            stmt.setDate(4, java.sql.Date.valueOf(entidad.getFechaFin()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s: ", Asignacion.class.getName()), e);
        }
    }

    @Override
    public void actualizar(Asignacion entidad) {
        String sql = "{ CALL pa_Actualizar_Asignacion(?, ?, ?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getId());
            stmt.setInt(2, entidad.getBien().getId());
            stmt.setInt(3, entidad.getResponsable().getId());
            stmt.setDate(4, java.sql.Date.valueOf(entidad.getFechaInicio()));
            stmt.setDate(5, java.sql.Date.valueOf(entidad.getFechaFin()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al actualizar %s: ", Asignacion.class.getName()), e);
        }
    }

    @Override
    public Asignacion leerPorId(int idEntidad) {
        String sql = "{ CALL pa_Leer_Asignacion(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, idEntidad);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper.mapDeResultSet(rs);
            }

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al leer %s: ", Asignacion.class.getName()), e);
        }
        return null;
    }

    @Override
    public void eliminar(int idEntidad) {
        String sql = "{ CALL pa_Eliminar_Asignacion(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idEntidad);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al eliminar %s: ", Asignacion.class.getName()), e);
        }
    }

    @Override
    public List<Asignacion> listarTodo() {
        String sql = "{ CALL pa_Listar_Asignacion() }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();
            List<Asignacion> entidades = new ArrayList<>();
            while (rs.next()) {
                entidades.add(mapper.mapDeResultSet(rs));
            }

            stmt.executeUpdate();
            return entidades;

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al listar %s: ", Asignacion.class.getName()), e);
        }
    }
}
