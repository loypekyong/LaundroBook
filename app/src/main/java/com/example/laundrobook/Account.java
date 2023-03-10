package com.example.laundrobook;

public class Account {
    private String username;    // username
    private Integer roomId;     // room id
    private String passwordHash;    // password
    private Boolean bookedWashingMachine;
    private Boolean bookedDryer;


    // Todo Hashing function if needed


    // Constructor
    public Account() {
    }
    public Account(String username, String passwordHash) {
        this.username = username;
        this.passwordHash = passwordHash;
        //this.roomId = roomId;
        bookedDryer = false;
        bookedWashingMachine = false;

    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public Boolean getBookedWashingMachine() {
        return bookedWashingMachine;
    }

    public void setBookedWashingMachine(Boolean bookedWashingMachine) {
        this.bookedWashingMachine = bookedWashingMachine;
    }

    public Boolean getBookedDryer() {
        return bookedDryer;
    }

    public void setBookedDryer(Boolean bookedDryer) {
        this.bookedDryer = bookedDryer;
    }
}
