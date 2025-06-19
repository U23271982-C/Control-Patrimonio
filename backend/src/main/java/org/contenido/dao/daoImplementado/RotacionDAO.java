package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.mapeo.mapeoImpl.RotacionMapper;
import org.contenido.modelo.Rotacion;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RotacionDAO implements DAO<Rotacion> {
    private final ResultSetMapper<Rotacion> mapper;

    public RotacionDAO() {
        this.mapper = new RotacionMapper(); // Aquí deberías inicializar el mapper adecuado para Rotacion
    }

    @Override
    public void registrar(Rotacion entidad) {
        String sql = "{ CALL pa_Registrar_Rotacion(?, ?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getBien().getId());
            stmt.setInt(2, entidad.getAmbiente().getId());
            stmt.setString(3, entidad.getMotivo());
            stmt.setInt(4, entidad.getResponsable().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s: ", Rotacion.class.getName()), e);
        }
    }

    @Override
    public Rotacion leerPorId(int idEntidad) {
        String sql = "{ CALL pa_Leer_Rotacion(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, idEntidad);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper.mapDeResultSet(rs);
            }

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al leer %s: ", Rotacion.class.getName()), e);
        }
        return null;
    }

    @Override
    public void actualizar(Rotacion entidad) {
        String sql = "{ CALL pa_Actualizar_Rotacion(?, ?, ?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getId());
            stmt.setInt(2, entidad.getBien().getId());
            stmt.setInt(3, entidad.getAmbiente().getId());
            stmt.setString(4, entidad.getMotivo());
            stmt.setInt(5, entidad.getResponsable().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al actualizar %s: ", Rotacion.class.getName()), e);
        }
    }

    @Override
    public void eliminar(int idEntidad) {
        String sql = "{ CALL pa_Eliminar_Rotacion(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idEntidad);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al eliminar %s: ", Rotacion.class.getName()), e);
        }
    }

    @Override
    public List<Rotacion> listarTodo() {
        String sql = "{ CALL pa_Listar_Rotacion() }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();
            List<Rotacion> entidades = new ArrayList<>();
            while (rs.next()) {
                entidades.add(mapper.mapDeResultSet(rs));
            }

            stmt.executeUpdate();
            return entidades;

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al listar %s: ", Rotacion.class.getName()), e);
        }
    }
}
