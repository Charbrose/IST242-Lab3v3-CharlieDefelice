package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class mySQLCRUD {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/database_name";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public void performCRUD() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
            // Implement CRUD operations for MySQL
            // Example:
            // Insert data
            String insertSql = "INSERT INTO table_name (column1, column2) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertSql)) {
                preparedStatement.setString(1, "value1");
                preparedStatement.setString(2, "value2");
                preparedStatement.executeUpdate();
            }

            // Read data
            String selectSql = "SELECT * FROM table_name";
            try (PreparedStatement preparedStatement = connection.prepareStatement(selectSql)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String column1Value = resultSet.getString("column1");
                        String column2Value = resultSet.getString("column2");
                        System.out.println("Column1: " + column1Value + ", Column2: " + column2Value);
                    }
                }
            }

            // Update data
            String updateSql = "UPDATE table_name SET column1 = ? WHERE condition";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
                preparedStatement.setString(1, "new_value");
                preparedStatement.executeUpdate();
            }

            // Delete data
            String deleteSql = "DELETE FROM table_name WHERE condition";
            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
                preparedStatement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
