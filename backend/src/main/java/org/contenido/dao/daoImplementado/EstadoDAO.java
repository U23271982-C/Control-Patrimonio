package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.mapeo.mapeoImpl.EstadoMapper;
import org.contenido.modelo.Estado;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EstadoDAO implements DAO<Estado> {
    private final ResultSetMapper<Estado> mapper;

    public EstadoDAO() {
        this.mapper = new EstadoMapper();
    }

    @Override
    public void registrar(Estado entidad) {
        String sql = "{ CALL pa_Registrar_Estado(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setString(1, entidad.getTipo());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s: ", Estado.class.getName()), e);
        }
    }

    @Override
    public Estado leerPorId(int idEntidad) {
        String sql = "{ CALL pa_Leer_Estado(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, idEntidad);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper.mapDeResultSet(rs);
            }

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al leer %s: ", Estado.class.getName()), e);
        }
        return null;
    }

    @Override
    public void actualizar(Estado entidad) {
        String sql = "{ CALL pa_Actualizar_Estado(?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getId());
            stmt.setString(2, entidad.getTipo());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al actualizar %s: ", Estado.class.getName()), e);
        }
    }

    @Override
    public void eliminar(int idEntidad) {
        String sql = "{ CALL pa_Eliminar_Estado(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idEntidad);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al eliminar %s: ", Estado.class.getName()), e);
        }
    }

    @Override
    public List<Estado> listarTodo() {
        String sql = "{ CALL pa_Listar_Estado() }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();
            List<Estado> entidades = new ArrayList<>();
            while (rs.next()) {
                entidades.add(mapper.mapDeResultSet(rs));
            }

            stmt.executeUpdate();
            return entidades;

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al listar %s: ", Estado.class.getName()), e);
        }
    }
}
