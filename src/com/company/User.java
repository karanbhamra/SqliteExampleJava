package com.company;

// ORM for User Table
public class User {

    private int Id;
    private String FirstName;
    private String LastName;

    public User(int id, String firstName, String lastName) {
        Id = id;
        FirstName = firstName;
        LastName = lastName;
    }

    public User(String firstName, String lastName) {
        FirstName = firstName;
        LastName = lastName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getId() {
        return Id;
    }

    // String representation of user record
    @Override
    public String toString() {
        return Id + "\t" + FirstName + "\t" + LastName;
    }
}
