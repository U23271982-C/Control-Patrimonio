package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.modelo.Estado;
import org.contenido.modelo.Responsable;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class EstadoDAO implements DAO<Estado> {
    @Override
    public void registrar(Estado entidad) {
        String sql = "{ CALL pa_Registrar_Estado(?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setString(1, entidad.getTipo());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s: ", Estado.class.getName()), e);
        }
    }

    @Override
    public Estado leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Estado entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Estado> listarTodo() {
        return List.of();
    }
}
