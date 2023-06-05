package com.example.software_technology;

import java.sql.*;

public class DayOffController {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/hoteliday_db"; // Replace with your database URL
        String username = "root"; // Replace with your database username
        String password = "root"; // Replace with your database password

        String query = "SELECT * FROM ADMIN"; // Replace with your table name

        try {
            // Create a connection to the database
            Connection connection = DriverManager.getConnection(url, username, password);

            // Create a statement object
            Statement statement = connection.createStatement();

            // Execute the query and get the result set
            ResultSet resultSet = statement.executeQuery(query);

            // Iterate through the result set and print the data
            while (resultSet.next()) {
                // Retrieve data from each column by name or index
                int ADMIN_ID = resultSet.getInt("ADMIN_ID");
                String FIRST_NAME = resultSet.getString("FIRST_NAME");
                // Retrieve other columns as needed

                String LAST_NAME = resultSet.getString("LAST_NAME");

                // Process the retrieved data
                System.out.println("ADMIN_ID: " + ADMIN_ID + ", FIRST_NAME: " + FIRST_NAME + "LAST_NAME: " + LAST_NAME);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
