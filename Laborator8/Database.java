package org.example.Laborator8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/java";
    private static final String USER = "alexandra";
    private static final String PASSWORD = "Alexandra17240309";
    private static Connection connection = null;
    private Database() {

    }
    public static Connection getConnection() {
        return connection;
    }
    public static void createConnection() {
        try {
            connection= DriverManager.getConnection(URL, USER, PASSWORD);
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void closeConnection() throws SQLException {
        connection.close();
    }
    public static void rollback() throws SQLException {
        connection.rollback();
    }
}
