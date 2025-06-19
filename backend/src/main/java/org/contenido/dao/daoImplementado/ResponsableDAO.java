package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.mapeo.mapeoImpl.ResponsableMapper;
import org.contenido.modelo.Ambiente;
import org.contenido.modelo.Responsable;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ResponsableDAO implements DAO<Responsable> {
    private final ResultSetMapper<Responsable> mapper;

    public ResponsableDAO() {
        this.mapper = new ResponsableMapper();
    }

    @Override
    public void registrar(Responsable entidad) {
        String sql = "{ CALL pa_Registrar_Responsable(?, ?, ?, ?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getRol_responsable().getId());
            stmt.setString(2, entidad.getNombre());
            stmt.setString(3, entidad.getDni());
            stmt.setString(4, entidad.getEmail());
            stmt.setString(5, entidad.getUsuario());
            stmt.setString(6, entidad.getContrasena());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s: ", Responsable.class.getName()), e);
        }
    }

    @Override
    public Responsable leerPorId(int idEntidad) {
        String sql = "{ CALL pa_Leer_Responsable(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, idEntidad);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper.mapDeResultSet(rs);
            }

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al leer %s: ", Responsable.class.getName()), e);
        }
        return null;
    }

    @Override
    public void actualizar(Responsable entidad) {
        String sql = "{ CALL pa_Actualizar_Responsable(?, ?, ?, ?, ?, ?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getId());
            stmt.setInt(2, entidad.getRol_responsable().getId());
            stmt.setString(3, entidad.getNombre());
            stmt.setString(4, entidad.getDni());
            stmt.setString(5, entidad.getEmail());
            stmt.setString(6, entidad.getUsuario());
            stmt.setString(7, entidad.getContrasena());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al actualizar %s: ", Ambiente.class.getName()), e);
        }
    }

    @Override
    public void eliminar(int idEntidad) {
        String sql = "{ CALL pa_Eliminar_Responsable(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idEntidad);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al eliminar %s: ", Responsable.class.getName()), e);
        }
    }

    @Override
    public List<Responsable> listarTodo() {
        String sql = "{ CALL pa_Listar_Responsable() }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();
            List<Responsable> entidades = new ArrayList<>();
            while (rs.next()) {
                entidades.add(mapper.mapDeResultSet(rs));
            }

            stmt.executeUpdate();
            return entidades;

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al listar %s: ", Responsable.class.getName()), e);
        }
    }
}
