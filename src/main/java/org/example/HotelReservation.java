package org.example;

import java.time.LocalDate;
import java.util.*;

public class HotelReservation{
    private List<Hotel> hotels;

    public HotelReservation(){
        this.hotels = new ArrayList<>();
    }

    public void addHotel(Hotel hotel){
        hotels.add(hotel);
    }
}
