package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.modelo.Inventario;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class InventarioDAO implements DAO<Inventario> {
    @Override
    public void registrar(Inventario entidad) {
        String sql = "{ CALL pa_Registrar_Inventario(?, ?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setString(1, entidad.getNombre());
            stmt.setString(2, entidad.getDescripcion());
            stmt.setDate(3, java.sql.Date.valueOf
                    (entidad.getFechaInicio()));
            stmt.setDate(4, java.sql.Date.valueOf
                    (entidad.getFechaFin()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al registrar inventario: " + e.getMessage(), e);
        }
    }

    @Override
    public Inventario leerPorId(int idEntidad) {
        Inventario entidad = null;
        String sql = "{ CALL pa_Leer_Inventario(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, idEntidad);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                entidad = new Inventario();
                entidad.setId(rs.getInt(1));
                entidad.setNombre(rs.getString(2));
                entidad.setDescripcion(rs.getString(3));
                entidad.setFechaInicio(rs.getDate(4).toLocalDate());
                entidad.setFechaFin(rs.getDate(5).toLocalDate());
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al leer el inventario: " + e.getMessage(), e);
        }
        return entidad;
    }

    @Override
    public void actualizar(Inventario entidad) {
        String sql = "{ CALL pa_Actualizar_Inventario(?, ?, ?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getId());
            stmt.setString(2, entidad.getNombre());
            stmt.setString(3, entidad.getDescripcion());
            stmt.setDate(4, java.sql.Date.valueOf
                    (entidad.getFechaInicio()));
            stmt.setDate(5, java.sql.Date.valueOf
                    (entidad.getFechaFin()));

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException("Error al actualizar inventario: " + e.getMessage(), e);
        }
    }

    @Override
    public void eliminar(int idEntidad) {
        String sql = "{ CALL pa_Eliminar_Inventario(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idEntidad);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Error al eliminar inventario: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Inventario> listarTodo() {
        // faltan los metodos de listar
        return List.of();
    }
}
