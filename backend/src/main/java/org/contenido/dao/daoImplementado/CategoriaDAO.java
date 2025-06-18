package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.mapeo.ResultSetMapper;
import org.contenido.mapeo.mapeoImpl.CategoriaMapper;
import org.contenido.modelo.Ambiente;
import org.contenido.modelo.Bien;
import org.contenido.modelo.Categoria;
import org.contenido.modelo.Responsable;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO implements DAO<Categoria> {
    private final ResultSetMapper<Categoria> mapper;

    public CategoriaDAO() {
        this.mapper = new CategoriaMapper();
    }

    @Override
    public void registrar(Categoria entidad) {
        String sql = "{ CALL pa_Registrar_Categoria(?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setString(1, entidad.getNombre());
            stmt.setString(2, entidad.getDescripcion());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s: ", Responsable.class.getName()), e);
        }
    }

    @Override
    public Categoria leerPorId(int idEntidad) {
        String sql = "{ CALL pa_Leer_Categoria(?) }";
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
    public void actualizar(Categoria entidad) {
        String sql = "{ CALL pa_Actualizar_Categoria(?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getId());
            stmt.setString(2, entidad.getNombre());
            stmt.setString(3, entidad.getDescripcion());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al actualizar %s: ", Categoria.class.getName()), e);
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
    public List<Categoria> listarTodo() {
        String sql = "{ CALL pa_Listar_Categoria() }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)) {

            ResultSet rs = stmt.executeQuery();
            List<Categoria> entidades = new ArrayList<>();
            while (rs.next()) {
                entidades.add(mapper.mapDeResultSet(rs));
            }

            stmt.executeUpdate();
            return entidades;

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al listar %s: ", Categoria.class.getName()), e);
        }
    }
}
