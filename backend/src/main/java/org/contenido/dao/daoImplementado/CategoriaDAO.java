package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.modelo.Categoria;
import org.contenido.modelo.Responsable;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class CategoriaDAO implements DAO<Categoria> {
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
        return null;
    }

    @Override
    public void actualizar(Categoria entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Categoria> listarTodo() {
        return List.of();
    }
}
