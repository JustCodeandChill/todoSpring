package com.todo.demo;

import java.sql.*;

public class Database {
    private static String url = "jdbc:postgresql://localhost:5432/dao";
    private static String username = "postgres";
    private static String password = "postgres";

    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        connection = DriverManager.getConnection(url, username, password);

        return connection;
    }

    public static void closeConnection(Connection connection) {

        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException exception) {
            // exception.printStackTrace();
        }

    }

    public static void closeStatement(Statement statement) {

        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException exception) {
            // exception.printStackTrace();
        }

    }

    public static void closeResultSet(ResultSet resultSet) {

        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException exception) {
            // exception.printStackTrace();
        }

    }
}
