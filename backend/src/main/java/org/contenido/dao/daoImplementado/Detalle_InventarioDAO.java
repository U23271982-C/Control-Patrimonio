package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.modelo.Detalle_Inventario;
import org.contenido.modelo.Responsable;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Detalle_InventarioDAO implements DAO<Detalle_Inventario> {
    @Override
    public void registrar(Detalle_Inventario entidad) {
        String sql = "{ CALL pa_Registrar_Detalle_Inventario(?, ?) }";
        try (Connection conn = ConexionPool.getConnection();
             CallableStatement stmt = conn.prepareCall(sql)){

            stmt.setInt(1, entidad.getBien().getId());
            stmt.setInt(2, entidad.getInventario().getId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenciaExcepcion(String.format("Error al registrar %s: ", Responsable.class.getName()), e);
        }
    }

    @Override
    public Detalle_Inventario leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(Detalle_Inventario entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<Detalle_Inventario> listarTodo() {
        return List.of();
    }
}
