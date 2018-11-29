package com.company;

import java.sql.*;
import java.util.ArrayList;

// This class will act as the intermediary between database and our objects
public class UserDao {

    private SqlConnector connector;

    private String idCol;
    private String firstNameCol;
    private String lastNameCol;

    public UserDao(SqlConnector conn) {

        connector = conn;
        idCol = "id";
        firstNameCol = "FName";
        lastNameCol = "LName";

    }

    // Returns an arraylist of User objects from the database
    // Ideally check the count of returned arrayList
    public ArrayList<User> selectAll() throws Exception {

        ArrayList<User> users = new ArrayList<>();

        String sql = "Select * from Users";
        try {
            Connection conn = connector.openConnection();

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {

                User tempUser = new User(rs.getInt(idCol), rs.getString(firstNameCol), rs.getString(lastNameCol));

                users.add(tempUser);
            }

            connector.closeConnection();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return users;


    }

    // Adds a new user record into the database and returns int representing how many records were affected
    public int addNewUser(User userToAdd) throws Exception {

        String sql = String.format("Insert into Users(%s, %s) values (?,?);", firstNameCol, lastNameCol);

        try {
            Connection conn = connector.openConnection();

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, userToAdd.getFirstName());
            stmt.setString(2, userToAdd.getLastName());

            int result = stmt.executeUpdate();

            connector.closeConnection();

            return result;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // no record added
        return 0;


    }
}
