package org.example;

import java.time.LocalDate;
import java.util.*;


interface HotelReservationInterface{
    void addHotel(Hotel hotel);
    String findCheapestHotel(LocalDate startDate, LocalDate endDate);
    String findCheapestHotelByRating(LocalDate startDate, LocalDate endDate);
    Hotel findBestRatedHotel(LocalDate startDate, LocalDate endDate);

    String findCheapestBestRatedHotelForRewardCustomer(LocalDate startDate, LocalDate endDate);

}
/**
 * HotelReservation class representing a hotel reservation system.
 */
public class HotelReservation implements HotelReservationInterface{
    private List<Hotel> hotels;

    /**
     * Constructor to initialize a HotelReservation object with an empty list of hotels.
     */
    public HotelReservation() {
        this.hotels = new ArrayList<>();
    }

    /**
     * Adds a hotel to the list of hotels.
     *
     * @param hotel The hotel to be added.
     */
    @Override
    public void addHotel(Hotel hotel) {
        hotels.add(hotel);
    }

    /**
     * Finds the cheapest hotel based on rates for a given date range.
     * @return A string representation of the cheapest hotel and its total cost.
     */
    @Override

    public String findCheapestHotel(LocalDate startDate, LocalDate endDate) {
        return hotels.stream()
                .map(hotel -> hotel.getName() + ", Total Rates: $" +
                        calculateTotalHotelCost(hotel, startDate, endDate))
                .min(Comparator.comparingInt(s -> Integer.parseInt(s.split("Total Rates: \\$")[1])))
                .orElse("No Hotels Available");
    }

    /**
     * Finds the cheapest hotel based on rating for a given date range.
     *
     * @return A string representation of the cheapest hotel by rating and its total cost.
     */
    @Override
    public String findCheapestHotelByRating(LocalDate startDate, LocalDate endDate) {
        return hotels.stream()
                .max(Comparator.comparing(Hotel::getRating).thenComparingInt(hotel -> calculateTotalHotelCost(hotel, startDate, endDate)))
                .map(hotel -> hotel.getName()+", Total Rates: $"+calculateTotalHotelCost(hotel, startDate, endDate))
                .orElse("No Hotels Available");
    }

    /**
     * Finds the best-rated hotel.
     * @param startDate for starting date range.
     * @param endDate for ending date range.
     * @return The best-rated hotel.
     */
    @Override
    public Hotel findBestRatedHotel(LocalDate startDate, LocalDate endDate) {
        return hotels.stream()
                .max(Comparator.comparing(hotel -> hotel.getRating()))
                .orElse(null);
    }

    /**
     * Finds the cheapest best-rated hotel for reward customer.

     * @return The cheapest best-rated hotel.
     */
    @Override
    public String findCheapestBestRatedHotelForRewardCustomer(LocalDate startDate, LocalDate endDate){
        return hotels.stream()
                .max(Comparator.comparing(Hotel::getRating).thenComparingInt(hotel -> calculateTotalHotelCostForRewardCustomer(hotel, startDate, endDate)))
                .map(hotel -> hotel.getName()+" Total Rates: $"+calculateTotalHotelCostForRewardCustomer(hotel, startDate, endDate))
                .orElse("No Hotels Available");
    }

    /**
     * Calculates the total cost of staying at a hotel for a given date range.
     *
     * @param hotel     The hotel for which the cost is calculated.
     * @param startDate The start date of the reservation.
     * @param endDate   The end date of the reservation.
     * @return The total cost of staying at the hotel.
     */
    private int calculateTotalHotelCost(Hotel hotel, LocalDate startDate, LocalDate endDate) {
        if (hotel == null) {
            return 0;
        }

        return (int) startDate.datesUntil(endDate.plusDays(1))
                .map(date -> hotel.getRates(date))
                .filter(Objects::nonNull)
                .mapToInt(Integer::intValue)
                .sum();
    }



    /**
     * Calculates the total cost of staying at a hotel for a given date range.
     *
     * @param hotel     The hotel for which the cost is calculated.
     * @param startDate The start date of the reservation.
     * @param endDate   The end date of the reservation.
     * @return The total cost of staying at the hotel.
     */
    public int calculateTotalHotelCostForRewardCustomer(Hotel hotel, LocalDate startDate, LocalDate endDate) {
        return (int) startDate.datesUntil(endDate.plusDays(1))
                .mapToInt(date -> hotel.getSpecialRates(date))
                .sum();
    }


}
