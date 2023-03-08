package com.example.laundrobook;

import java.util.ArrayList;

public class BookingSystem {
    // singleton - only one booking system allowed

    private static BookingSystem instance = null;

    private BookingSystem(){}

    public static BookingSystem getInstance(){
        if (instance == null)
            instance = new BookingSystem();
        return instance;
    }
    private ArrayList<String> timeSlots; // time slots for booking system

    // Todo logic for making booking with accounts?
}
