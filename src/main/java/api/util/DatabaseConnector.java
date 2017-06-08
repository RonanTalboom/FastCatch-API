package api.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Anna on 7-6-2017.
 */
public class DatabaseConnector {

    private static final String DB_DRIVER = "org.mariadb.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mariadb://127.0.0.1:3306/FastCatch";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";
    private static DataSource datasource = initDataSource();

    private DatabaseConnector() {

    }

    private static DataSource initDataSource() {
        HikariConfig config = new HikariConfig();

        config.setDriverClassName(DB_DRIVER);
        config.setJdbcUrl(DB_CONNECTION);
        config.setUsername(DB_USER);
        config.setPassword(DB_PASSWORD);

        config.setMaximumPoolSize(20);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        config.addDataSourceProperty("useServerPrepStmts", "true");

        return new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return datasource.getConnection();
    }
}
