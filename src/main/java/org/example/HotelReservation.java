package org.example;

import java.time.LocalDate;
import java.util.*;

/*
    @description: This class represents a hotel reservation system that manages a list of hotels.
*/
public class HotelReservation {
    private List<Hotel> hotels;

    /*
        @description: Constructor to initialize the hotel reservation system with an empty list of hotels.
        @parameters: None
    */
    public HotelReservation() {
        this.hotels = new ArrayList<>();
    }

    /*
        @description: Adds a hotel to the list of hotels in the reservation system.
        @parameters:
            - hotel: The hotel to be added.
        @return: None
    */
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    /**
        @description: Get the List of the hotels.
        @return: return the List of the hotels.
    */
    public List<Hotel> getHotel(){
        return hotels;
}
