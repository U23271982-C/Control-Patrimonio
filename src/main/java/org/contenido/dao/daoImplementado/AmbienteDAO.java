package org.contenido.dao.daoImplementado;

import org.contenido.dao.DAO;
import org.contenido.dto.AmbienteDTO;
import org.contenido.persistencia.ConexionPool;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.List;

public class AmbienteDAO implements DAO<AmbienteDTO> {
    @Override
    public void registrar(AmbienteDTO entidad) {
        // Ejemplo
        String consultaSQL = "{ CALL pa_registrarAmbiente(?, ?, ?) }";

        try (CallableStatement comando =
                     ConexionPool.getConnection().prepareCall(consultaSQL)){

            comando.setInt
                    (1, entidad.getId());
            comando.setString
                    (2, entidad.getNombre());
            comando.setInt(3, entidad.getId_inmueble());

            comando.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public AmbienteDTO leerPorId(int idEntidad) {
        return null;
    }

    @Override
    public void actualizar(AmbienteDTO entidad) {

    }

    @Override
    public void eliminar(int idEntidad) {

    }

    @Override
    public List<AmbienteDTO> listarTodo() {
        return List.of();
    }
}
