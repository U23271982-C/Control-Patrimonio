package org.contenido.dao.daoImplementadoModelo;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Bien;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BienDAO implements DAO<Bien> {
    private final ResultSetMapper<Bien> mapper;

    public BienDAO() {
        this.mapper = new org.contenido.mapeo.mapeoImpl.BienMapper();
    }

    @Override
    public void registrar(Bien entidad) {
        String sql = "{ CALL pa_Registrar_Bien(?, ?, ?, ?, ?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setString(1, entidad.getNombre());
            stmt.setString(2, entidad.getDescripcion());
            stmt.setDate(3, java.sql.Date.valueOf(entidad.getFecha_registro()));
            stmt.setInt(4, entidad.getEstado().getId());
            stmt.setInt(5, entidad.getCategoria().getId());
            stmt.setInt(6, entidad.getAmbiente().getId());
            stmt.setInt(7, entidad.getResponsable().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s: ", Bien.class.getName()), e);
        }
    }

    @Override
    public Bien leerPorId(int idEntidad) {
        String sql = "{ CALL pa_Leer_Bien(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, idEntidad);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper.mapDeResultSet(rs);
            }

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al leer %s: ", Bien.class.getName()), e);
        }
        return null;
    }

    @Override
    public void actualizar(Bien entidad) {
        String sql = "{ CALL pa_Actualizar_Bien(?, ?, ?, ?, ?, ?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getId());
            stmt.setString(2, entidad.getNombre());
            stmt.setString(3, entidad.getDescripcion());
            stmt.setDate(4, java.sql.Date.valueOf(entidad.getFecha_registro()));
            stmt.setInt(5, entidad.getEstado().getId());
            stmt.setInt(6, entidad.getCategoria().getId());
            stmt.setInt(7, entidad.getAmbiente().getId());
            stmt.setInt(8, entidad.getResponsable().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al actualizar %s: ", Bien.class.getName()), e);
        }
    }

    @Override
    public void eliminar(int idEntidad) {
        String sql = "{ CALL pa_Eliminar_Bien(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idEntidad);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al eliminar %s: ", Bien.class.getName()), e);
        }
    }

    @Override
    public List<Bien> listarTodo() {
        String sql = "{ CALL pa_Listar_Bien() }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();
            List<Bien> entidades = new ArrayList<>();
            while (rs.next()) {
                entidades.add(mapper.mapDeResultSet(rs));
            }

            stmt.executeUpdate();
            return entidades;

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al listar %s: ", Bien.class.getName()), e);
        }
    }
}
