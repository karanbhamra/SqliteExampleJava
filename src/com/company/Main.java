package com.company;

import java.util.ArrayList;

public class Main {


    public static void main(String[] args) throws Exception {

        SqlConnector connector = new SqlConnector("resources/test.db");

        UserDao manager = new UserDao(connector);

        ArrayList<User> allUsers = manager.selectAll();

        for (User u : allUsers) {
            System.out.println(u);
        }

        User testUser = new User("Bob", "Dole");

        int result = manager.addNewUser(testUser);


        if (result != 0) {
            System.out.println("Results: " + result);
        }
        else {
            System.out.println("Failed");
        }

    }


}
