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

    public String findCheapestHotel(LocalDate startDate, LocalDate endDate){
        int min_cost = Integer.MAX_VALUE;
        String cheapestHotel = null;

        for(Hotel hotel: hotels){
            int totalCost = calculateTotalHotelCost(hotel, startDate, endDate);
            if(totalCost<min_cost){
                min_cost = totalCost;
                cheapestHotel = hotel.getName();
            }
        }
        return cheapestHotel+" Total Rate: $"+min_cost;
    }

    public int calculateTotalHotelCost(Hotel hotel, LocalDate startDate, LocalDate endDate){
        int totalCost = 0;

        while(!startDate.isAfter(endDate)){
            totalCost += hotel.getRates(startDate);
            startDate.plusDays(1);
        }
        return totalCost;
    }

    public String findCheapestHotelByRating(LocalDate startDate, LocalDate endDate){
        Hotel cheapestHotel = null;
        for(Hotel hotel: hotels){
            if(cheapestHotel == null || compareHotels(hotel, cheapestHotel) <0){
                cheapestHotel = hotel;
            }
        }
        return (cheapestHotel != null)? cheapestHotel.getName() +", Total Rates: $"+new HotelReservation().calculateTotalHotelCost(cheapestHotel,startDate, endDate): "No Hotels Available";
    }

    public int compareHotels(Hotel hotel1, Hotel hotel2){
        return Integer.compare(hotel1.getRating(), hotel2.getRating());
    }
}