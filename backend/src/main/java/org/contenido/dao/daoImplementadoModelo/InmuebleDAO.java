package org.contenido.dao.daoImplementadoModelo;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.mapeo.mapeoImpl.InmuebleMapper;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Inmueble;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InmuebleDAO implements DAO<Inmueble> {
    private final ResultSetMapper<Inmueble> mapper;

    public InmuebleDAO() {
        this.mapper = new InmuebleMapper();
    }
    @Override
    public void registrar(Inmueble entidad) {
        String sql = "{ CALL pa_Registrar_Inmueble(?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setString(1, entidad.getNombre());
            stmt.setString(2, entidad.getDescripcion());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion("Error al registrar Inmueble:" + Inmueble.class.getSimpleName(), e);
        }
    }

    @Override
    public Inmueble leerPorId(int idEntidad) {
        String sql = "{ CALL pa_Leer_Inmueble(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, idEntidad);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper.mapDeResultSet(rs);
            }

        } catch (SQLException e) {
            throw new PersistenciaExcepcion("Error al leer Inmueble:", e);
        }
        return null;
    }

    @Override
    public void actualizar(Inmueble entidad) {
        String sql = "{ CALL pa_Actualizar_Inmueble(?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getId());
            stmt.setString(2, entidad.getNombre());
            stmt.setString(3, entidad.getDescripcion());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion("Error al actualizar Inmueble:", e);
        }
    }

    @Override
    public void eliminar(int idEntidad) {
        String sql = "{ CALL pa_Eliminar_Inmueble(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idEntidad);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaExcepcion("Error al eliminar Inmueble:", e);
        }
    }

    @Override
    public List<Inmueble> listarTodo() {
        String sql = "{ CALL pa_Listar_Inmueble() }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();
            List<Inmueble> entidades = new ArrayList<>();
            while (rs.next()) {
                entidades.add(mapper.mapDeResultSet(rs));
            }

            stmt.executeUpdate();
            return entidades;

        } catch (SQLException e) {
            throw new PersistenciaExcepcion("Error al listar Inmueble:", e);
        }
    }
}
