package org.contenido.dao.daoImplementadoModelo;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.mapeo.mapeoImpl.Detalle_InventarioMapper;
import org.contenido.modelo.Detalle_Inventario;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Detalle_InventarioDAO implements DAO<Detalle_Inventario> {
    private final ResultSetMapper<Detalle_Inventario> mapper;

    public Detalle_InventarioDAO() {
        this.mapper = new Detalle_InventarioMapper();
    }

    @Override
    public void registrar(Detalle_Inventario entidad) {
        String sql = "{ CALL pa_Registrar_Detalle_Inventario(?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getBien().getId());
            stmt.setInt(2, entidad.getInventario().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s: ", Detalle_Inventario.class.getName()), e);
        }
    }

    @Override
    public Detalle_Inventario leerPorId(int idEntidad) {
        String sql = "{ CALL pa_Leer_Detalle_Inventario(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, idEntidad);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper.mapDeResultSet(rs);
            }

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al leer %s: ", Detalle_Inventario.class.getName()), e);
        }
        return null;
    }

    @Override
    public void actualizar(Detalle_Inventario entidad) {
        String sql = "{ CALL pa_Actualizar_Detalle_Inventario(?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getId());
            stmt.setInt(2, entidad.getBien().getId());
            stmt.setInt(3, entidad.getInventario().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al actualizar %s: ", Detalle_Inventario.class.getName()), e);
        }
    }

    @Override
    public void eliminar(int idEntidad) {
        String sql = "{ CALL pa_Eliminar_Detalle_Inventario(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idEntidad);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al eliminar %s: ", Detalle_Inventario.class.getName()), e);
        }
    }

    @Override
    public List<Detalle_Inventario> listarTodo() {
        String sql = "{ CALL pa_Listar_DetalleInventario() }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();
            List<Detalle_Inventario> entidades = new ArrayList<>();
            while (rs.next()) {
                entidades.add(mapper.mapDeResultSet(rs));
            }

            stmt.executeUpdate();
            return entidades;

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al listar %s: ", Detalle_Inventario.class.getName()), e);
        }
    }
    /*CREATE PROCEDURE pa_Registrar_Bienes_Activos_en_DetalleInventario(
    IN p_idInventario INT
) el procedimiento de registrar activos en detalle*/

    public void registrarDetalleInventarioBienesActivos(Detalle_Inventario entidad) {
        String sql = "{ CALL pa_Registrar_Bienes_Activos_en_DetalleInventario(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getInventario().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s con Bienes Activos: ", Detalle_Inventario.class.getName()), e);
        }
    }
}
