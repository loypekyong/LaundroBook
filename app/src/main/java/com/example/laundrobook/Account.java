package com.example.laundrobook;

public class Account {
    private String username;    // username
    private Integer roomId;     // room id
    private String passwordHash;    // password
    Bookings bookings;  // bookings


    // Todo Hashing function if needed


    // Constructor
    public Account() {
    }
    public Account(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
        //this.roomId = roomId;

    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

}

