package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnector {

    // Holds the JDBC file url
    private String url;

    // Holds the connection that will be used for CRUD ops
    private Connection connection;

    // Append the file path to create the jdbc connection string
    public SqlConnector(String path) {
        url = "jdbc:sqlite:" + path;
        connection = null;
    }

    public String getUrl() {
        return url;
    }

    // Returns connection if successful, null otherwise, should check for null
    public Connection openConnection() {
        try {
            // create a connection to the database
            connection = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connection;
    }

    // Close the connection, false when unsuccessful
    public boolean closeConnection() throws Exception {
        if (connection != null) {
            connection.close();

            return true;
        }

        return false;

    }
}
