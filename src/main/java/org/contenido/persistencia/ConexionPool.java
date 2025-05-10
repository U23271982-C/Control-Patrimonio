package org.contenido.persistencia;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConexionPool {
    private static HikariDataSource codigoFuente;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/BDPatrimonioU?useSSL=false&serverTimezone=UTC");
        config.setUsername("root");
        config.setPassword("123456789");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        config.setMaximumPoolSize(10); // conexiones máximas
        config.setMinimumIdle(2);      // conexiones mínimas en reposo
        config.setIdleTimeout(30000);  // 30 segundos
        config.setMaxLifetime(1800000); // 30 minutos
        config.setConnectionTimeout(30000); // timeout de espera

        codigoFuente = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return codigoFuente.getConnection();
    }

    public static void cerrarPool() {
        if (codigoFuente != null) {
            codigoFuente.close();
        }
    }
}
