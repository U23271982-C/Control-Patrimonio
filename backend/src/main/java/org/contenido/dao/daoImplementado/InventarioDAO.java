package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.mapeo.mapeoImpl.InventarioMapper;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Inventario;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventarioDAO implements DAO<Inventario> {
    private final ResultSetMapper<Inventario> mapper;

    public InventarioDAO() {
        this.mapper = new InventarioMapper();
    }

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
            throw new RuntimeException("Error al registrar " + Inventario.class.getSimpleName(), e);
        }
    }

    @Override
    public Inventario leerPorId(int idEntidad) {
        String sql = "{ CALL pa_Leer_Inventario(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, idEntidad);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper.mapDeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al leer " + Inventario.class.getSimpleName(), e);
        }
        return null;
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
            throw new RuntimeException("Error al actualizar " + Inventario.class.getSimpleName(), e);
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
            throw new RuntimeException("Error al eliminar " + Inventario.class.getSimpleName(), e);
        }
    }

    @Override
    public List<Inventario> listarTodo() {
        String sql = "{ CALL pa_Listar_Inventario() }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();
            List<Inventario> entidades = new ArrayList<>();
            while (rs.next()) {
                entidades.add(mapper.mapDeResultSet(rs));
            }

            stmt.executeUpdate();
            return entidades;
        } catch (SQLException e) {
            throw new RuntimeException("Error al listar " + Inventario.class.getSimpleName(), e);
        }
    }
}
