package org.contenido.dao.daoImplementadoReporte;

import org.contenido.dto.BienDTO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.modelo.Ambiente;
import org.contenido.persistencia.ConexionPool;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RPersonalizadoDAOImpl implements RPersonalizadoDAO {
    @Override
    public List<Object[]> consultarParametros(BienDTO param) {
        String sql = "CALL pa_Reporte_Masivo_Personalizado(?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = ConexionPool.getConnection();
            CallableStatement stmt = conn.prepareCall(sql)) {

            stmt.setString(1, param.getEstado_actualDTO().getTipo());
            stmt.setString(2, param.getNombre());
            stmt.setDate(3, Date.valueOf(param.getFecha_registro()));
            stmt.setString(4, param.getResponsableDTO().getNombre());
            stmt.setString(5, param.getCategoriaDTO().getNombre());
            stmt.setString(6, param.getAmbienteDTO().getNombre());
            stmt.setString(7, param.getAmbienteDTO().getInmuebleDTO().getNombre());
            // falta inventario, ya que un bien puede tener muchos inventarios

            ResultSet rs = stmt.executeQuery();

            List<Object[]> filas = new ArrayList<>(); // filas de la respuesta
            while (rs.next()) {
                // tenemos 10 columnas de respuesta
                Object[] fila = new Object[10];
                for (int i = 0; i < 10; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                filas.add(fila); // agregamos una fila
            }

            return filas;
        } catch (SQLException e) {
            throw new PersistenciaExcepcion("Error al extraer los datos del reporte personalizado.", e);
        }
    }
}
