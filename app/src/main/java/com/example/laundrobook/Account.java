package com.example.laundrobook;

public class Account {

    private String username;
    private Integer roomId;
    private String passwordHash;
    private Boolean bookedWashingMachine;
    private Boolean bookedDryer;


    // Todo Hashing function if needed


    // Constructor
    public Account(String username, String passwordHash, Integer roomId) {
        this.username = username;
        this.passwordHash = passwordHash;
        this.roomId = roomId;
        bookedDryer = false;
        bookedWashingMachine = false;

    }

    public String getUsername() {
        return username;
    }

    public Integer getRoomId() {
        return roomId;
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
