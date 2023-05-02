package org.example.tema8;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0DataSource {

    private static ComboPooledDataSource cpds = new ComboPooledDataSource();
    private static final String URL = "jdbc:mysql://localhost:3306/java";
    private static final String USER = "alexandra";
    private static final String PASSWORD = "Alexandra17240309";
    private static Connection connection = null;
    static {
            cpds.setJdbcUrl(URL);
            cpds.setUser(USER);
            cpds.setPassword(PASSWORD);
        }
    public static Connection getConnection() throws SQLException {
        return cpds.getConnection();
    }

    private C3p0DataSource(){}
}