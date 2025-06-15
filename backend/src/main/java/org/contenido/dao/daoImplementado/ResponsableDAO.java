package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.modelo.Ambiente;
import org.contenido.modelo.Responsable;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ResponsableDAO implements DAO<Responsable> {
    @Override
    public void registrar(Responsable entidad) {
        String sql = "{ CALL pa_Registrar_Responsable(?, ?, ?, ?, ?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setString(1, entidad.getNombre());
            stmt.setString(2, entidad.getDni());
            stmt.setString(3, entidad.getEmail());
            stmt.setString(4, entidad.getUsuario());
            stmt.setString(5, entidad.getContrasena());
            stmt.setInt(6, entidad.getRol_responsable().getId());
            // Falta la relacion con Rol_Responsable?

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s: ", Responsable.class.getName()), e);
        }
    }

    @Override
    public Responsable leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Responsable entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Responsable> listarTodo() {
        return List.of();
    }
}
