package org.example;

import java.time.LocalDate;
import java.util.*;

/*
    @description: This class represents a hotel reservation system that manages a list of hotels.
*/
public class HotelReservation {
    private List<Hotel> hotels;

    /*
        @description: Constructor to initialize a HotelReservation object with an empty list of hotels.
        @parameters: None
        @return: None
    */
    public HotelReservation() {
        this.hotels = new ArrayList<>();
    }

    /*
        @description: Adds a hotel to the list of hotels.
        @parameters: hotel - The hotel to be added.
        @return: None
    */
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    /*
        @description: Finds the cheapest hotel among the list for a specified date range.
        @parameters: startDate - The start date of the reservation, endDate - The end date of the reservation.
        @return: A string containing the name of the cheapest hotel and the total cost.
    */
    public String findCheapestHotel(LocalDate startDate, LocalDate endDate) {
        int minCost = Integer.MAX_VALUE;
        String cheapestHotel = null;

        for (Hotel hotel : hotels) {
            int totalCost = calculateTotalHotelCost(hotel, startDate, endDate);
            if (totalCost < minCost) {
                minCost = totalCost;
                cheapestHotel = hotel.getName();
            }
        }

        return cheapestHotel + " Total Rate: $" + minCost;
    }

    /*
        @description: Calculates the total cost of staying in a hotel for a specified date range.
        @parameters: hotel - The hotel for which the cost is calculated, startDate - The start date of the reservation, endDate - The end date of the reservation.
        @return: The total cost of staying in the hotel for the specified date range.
    */
    public int calculateTotalHotelCost(Hotel hotel, LocalDate startDate, LocalDate endDate) {
        int totalCost = 0;

        while (!startDate.isAfter(endDate)) {
            totalCost += hotel.getRates(startDate);
            startDate = startDate.plusDays(1);
        }

        return totalCost;
    }

}
