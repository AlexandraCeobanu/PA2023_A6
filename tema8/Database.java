package org.example.tema8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
         private static Connection connection = null;
        private Database() {

        }
        public static Connection getConnection() {
            return connection;
        }
        public static void createConnection() {
            try {
                connection= C3p0DataSource.getConnection();
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
