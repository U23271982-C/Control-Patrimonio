package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.mapeo.mapeoImpl.AmbienteMapper;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.modelo.Ambiente;
import org.contenido.persistencia.ConexionPool;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AmbienteDAO implements DAO<Ambiente> {
    private final ResultSetMapper<Ambiente> mapper;

    public AmbienteDAO() {
        this.mapper = new AmbienteMapper();
    }

    @Override
    public void registrar(Ambiente entidad) {
        String sql = "{ CALL pa_Registrar_Ambiente(?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getInmueble().getId());
            stmt.setString(2, entidad.getNombre());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s: ", Ambiente.class.getName()), e);
        }
    }

    @Override
    public Ambiente leerPorId(int idEntidad) {
        String sql = "{ CALL pa_Leer_Ambiente(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, idEntidad);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapper.mapDeResultSet(rs);
            }

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al leer %s: ", Ambiente.class.getName()), e);
        }
        return null;
    }

    @Override
    public void actualizar(Ambiente entidad) {
        String sql = "{ CALL pa_Actualizar_Ambiente(?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getId());
            stmt.setInt(2, entidad.getInmueble().getId());
            stmt.setString(3, entidad.getNombre());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al actualizar %s: ", Ambiente.class.getName()), e);
        }
    }

    @Override
    public void eliminar(int idEntidad) {
        String sql = "{ CALL pa_Eliminar_Ambiente(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setInt(1, idEntidad);

            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al eliminar %s: ", Ambiente.class.getName()), e);
        }
    }

    @Override
    public List<Ambiente> listarTodo() {
        String sql = "{ CALL pa_Listar_Ambiente() }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();
            List<Ambiente> entidades = new ArrayList<>();
            while (rs.next()) {
                entidades.add(mapper.mapDeResultSet(rs));
            }

            stmt.executeUpdate();
            return entidades;

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al listar %s: ", Ambiente.class.getName()), e);
        }
    }
}
