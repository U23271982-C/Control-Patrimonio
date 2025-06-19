package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.mapeo.mapeoImpl.Rol_ResponsableMapper;
import org.contenido.modelo.Responsable;
import org.contenido.modelo.Rol_Responsable;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Rol_ResponsableDAO implements DAO<Rol_Responsable> {
    private final ResultSetMapper<Rol_Responsable> mapper;

    public Rol_ResponsableDAO() {
        this.mapper = new Rol_ResponsableMapper();
    }

    @Override
    public void registrar(Rol_Responsable entidad) {
        String sql = "{ CALL pa_Registrar_Rol_Responsable(?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setString(1, entidad.getDescripcion());
            stmt.setString(2, entidad.getNombreRol());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s: ", Responsable.class.getName()), e);
        }
    }

    @Override
    public Rol_Responsable leerPorId(int idEntidad) {
        String sql = "{ CALL pa_Leer_Rol_Responsable(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, idEntidad);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper.mapDeResultSet(rs);
            }

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al leer %s: ", Rol_Responsable.class.getName()), e);
        }
        return null;
    }

    @Override
    public void actualizar(Rol_Responsable entidad) {
        String sql = "{ CALL pa_Actualizar_Rol_Responsable(?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getId());
            stmt.setString(2, entidad.getDescripcion());
            stmt.setString(3, entidad.getNombreRol());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al actualizar %s: ", Rol_Responsable.class.getName()), e);
        }
    }

    @Override
    public void eliminar(int idEntidad) {
        String sql = "{ CALL pa_Eliminar_Rol_Responsable(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idEntidad);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al eliminar %s: ", Rol_Responsable.class.getName()), e);
        }
    }

    @Override
    public List<Rol_Responsable> listarTodo() {
        String sql = "{ CALL pa_Listar_RolResponsable() }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();
            List<Rol_Responsable> entidades = new ArrayList<>();
            while (rs.next()) {
                entidades.add(mapper.mapDeResultSet(rs));
            }

            stmt.executeUpdate();
            return entidades;

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al listar %s: ", Rol_Responsable.class.getName()), e);
        }
    }
}
