package org.contenido.dao.daoImplementadoReporte;

import org.contenido.dto.BienDTO;
import org.contenido.excepcion.PersistenciaExcepcion;
import org.contenido.persistencia.ConexionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RGeneralDAOImpl implements RGeneralDAO {
    @Override
    public List<Object[]> consultarSinParametros() {
        String sql = "CALL pa_Reporte_Masivo_General()";
        try(Connection conn = ConexionPool.getConnection();
            CallableStatement stmt = conn.prepareCall(sql)) {

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
            throw new PersistenciaExcepcion("Error al extraer los datos del reporte general.", e);
        }
    }
}
