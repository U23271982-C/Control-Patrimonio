package org.contenido.dao.daoImplementadoModelo;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.mapeo.mapeoImpl.Historial_EstadoMapper;
import org.contenido.modelo.Historial_Estado;
import org.contenido.persistencia.ConexionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Historial_EstadoDAO implements DAO<Historial_Estado> {
    private final ResultSetMapper<Historial_Estado> mapper;

    public Historial_EstadoDAO() {
        this.mapper = new Historial_EstadoMapper();
    }

    @Override
    public void registrar(Historial_Estado entidad) {
        String sql = "{ CALL pa_Registrar_HistorialEstado(?, ?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getBien().getId());
            stmt.setInt(2, entidad.getEstado().getId());
            stmt.setInt(3, entidad.getResponsable().getId());
            stmt.setString(4, entidad.getMotivo());
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s: ", Historial_Estado.class.getName()), e);
        }
    }

    @Override
    public Historial_Estado leerPorId(int idEntidad) {
        String sql = "{ CALL pa_Leer_HistorialEstado(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, idEntidad);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper.mapDeResultSet(rs);
            }

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al leer %s: ", Historial_Estado.class.getName()), e);
        }
        return null;
    }

    @Override
    public void actualizar(Historial_Estado entidad) {
        String sql = "{ CALL pa_Actualizar_HistorialEstado(?, ?, ?, ?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getId());
            stmt.setInt(2, entidad.getBien().getId());
            stmt.setInt(3, entidad.getEstado().getId());
            stmt.setInt(4, entidad.getResponsable().getId());
            stmt.setString(5, entidad.getMotivo());
            stmt.setDate(6, java.sql.Date.valueOf(entidad.getFecha_cambio()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al actualizar %s: ", Historial_Estado.class.getName()), e);
        }
    }

    @Override
    public void eliminar(int idEntidad) {
        String sql = "{ CALL pa_Eliminar_HistorialEstado(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idEntidad);
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al eliminar %s: ", Historial_Estado.class.getName()), e);
        }
    }

    @Override
    public List<Historial_Estado> listarTodo() {
        String sql = "{ CALL pa_Listar_HistorialEstado() }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();
            List<Historial_Estado> entidades = new ArrayList<>();
            while (rs.next()) {
                entidades.add(mapper.mapDeResultSet(rs));
            }

            stmt.executeUpdate();
            return entidades;

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al listar %s: ", Historial_Estado.class.getName()), e);
        }
    }
}
