package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.modelo.Ambiente;
import org.contenido.modelo.Bien;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class BienDAO implements DAO<Bien> {
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
        return null;
    }

    @Override
    public void actualizar(Bien entidad) {
        String sql = "{ CALL pa_Actualizar_Bien(?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getId());
            stmt.setString(2, entidad.getEstado().getTipo());
            stmt.setString(3, entidad.getNombre());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al actualizar %s: ", Ambiente.class.getName()), e);
        }
    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Bien> listarTodo() {
        return List.of();
    }
}
