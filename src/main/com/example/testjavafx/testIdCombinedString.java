package main.com.example.testjavafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class testIdCombinedString {

    public static void main(String[] args) {
        // JDBC connection parameters
        String jdbcUrl = "jdbc:mysql://localhost:3306/app_quan_ly_thien_tai";
        String username = "root";
        String password = "";

        try (
                // Establish a connection to the database
                Connection connection = DriverManager.getConnection(jdbcUrl, username, password)
        ) {
            // Create a table with an auto-incremented integer column and a string column
//            String createTableSQL = "CREATE TABLE your_table (prefix VARCHAR(2) NOT NULL, id INT AUTO_INCREMENT, PRIMARY KEY (id))";
//            try (PreparedStatement createTableStatement = connection.prepareStatement(createTableSQL)) {
//                createTableStatement.execute();
//            }

            // Insert data into the table
            String insertDataSQL = "INSERT INTO your_table (prefix) VALUES (?)";
            try (PreparedStatement insertDataStatement = connection.prepareStatement(insertDataSQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
                // Set the value for the string column
                insertDataStatement.setString(1, "LL");

                // Execute the insert statement
                insertDataStatement.executeUpdate();

                // Retrieve the auto-incremented ID
                try (ResultSet generatedKeys = insertDataStatement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int autoIncrementedID = generatedKeys.getInt(1);
                        String fullID = "LL" + String.format("%02d", autoIncrementedID);
                        System.out.println("Generated Full ID: " + fullID);
                    } else {
                        System.err.println("Failed to retrieve auto-incremented ID.");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

