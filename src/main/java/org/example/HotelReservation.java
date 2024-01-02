package org.example;

import java.time.LocalDate;
import java.util.*;

interface HotelReservationInterface{
    void addHotel(Hotel hotel);
    String findCheapestHotel(LocalDate startDate, LocalDate endDate);
    String findCheapestHotelByRating(LocalDate startDate, LocalDate endDate);
    Hotel findBestRatedHotel(LocalDate startDate, LocalDate endDate);

    Hotel findCheapestBestRatedHotelForRewardCustomer(LocalDate startDate, LocalDate endDate);

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
     *
     * @param startDate The start date of the reservation.
     * @param endDate   The end date of the reservation.
     * @return A string representation of the cheapest hotel and its total cost.
     */
    @Override
    public String findCheapestHotel(LocalDate startDate, LocalDate endDate) {
        int min_cost = Integer.MAX_VALUE;
        String cheapestHotel = null;

        for (Hotel hotel : hotels) {
            int totalCost = calculateTotalHotelCost(hotel, startDate, endDate);
            if (totalCost < min_cost) {
                min_cost = totalCost;
                cheapestHotel = hotel.getName();
            }
        }
        return cheapestHotel + " Total Rate: $" + min_cost;
    }

    /**
     * Calculates the total cost of staying at a hotel for a given date range.
     *
     * @param hotel     The hotel for which the cost is calculated.
     * @param startDate The start date of the reservation.
     * @param endDate   The end date of the reservation.
     * @return The total cost of staying at the hotel.
     */
    public int calculateTotalHotelCost(Hotel hotel, LocalDate startDate, LocalDate endDate) {
        int totalCost = 0;

        while (!startDate.isAfter(endDate)) {
            totalCost += hotel.getRates(startDate);
            startDate.plusDays(1);
        }
        return totalCost;
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
        int totalCost = 0;

        while (!startDate.isAfter(endDate)) {
            totalCost += hotel.getSpecialRates(startDate);
            startDate.plusDays(1);
        }
        return totalCost;
    }

    /**
     * Finds the cheapest hotel based on rating for a given date range.
     *
     * @param startDate The start date of the reservation.
     * @param endDate   The end date of the reservation.
     * @return A string representation of the cheapest hotel by rating and its total cost.
     */
    @Override
    public String findCheapestHotelByRating(LocalDate startDate, LocalDate endDate) {
        Hotel cheapestHotel = null;
        for (Hotel hotel : hotels) {
            if (cheapestHotel == null || compareHotels(hotel, cheapestHotel, startDate, endDate) < 0) {
                cheapestHotel = hotel;
            }
        }
        return (cheapestHotel != null) ? cheapestHotel.getName() + ", Total Rates: $" +
                new HotelReservation().calculateTotalHotelCost(cheapestHotel, startDate, endDate) : "No Hotels Available";
    }

    /**
     * Finds the best-rated hotel.
     * @param startDate for starting date range.
     * @param endDate for ending date range.
     * @return The best-rated hotel.
     */
    @Override
    public Hotel findBestRatedHotel(LocalDate startDate, LocalDate endDate) {
        Hotel bestRatedHotel = null;

        for (Hotel hotel : hotels) {
            if (bestRatedHotel == null || compareHotels(hotel, bestRatedHotel, startDate, endDate) >0) {
                bestRatedHotel = hotel;
            }
        }

        return bestRatedHotel;
    }

    /**
     * Finds the best-rated hotel for reward customer.
     * @param startDate for starting date range.
     * @param endDate for ending date range.
     * @return The best-rated hotel.
     */
    @Override
    public Hotel findCheapestBestRatedHotelForRewardCustomer(LocalDate startDate, LocalDate endDate){
        Hotel bestRatedHotelForRewardCustomer = null;

        for (Hotel hotel : hotels) {
            if (bestRatedHotelForRewardCustomer == null || compareHotelsForRewardCustomer(hotel, bestRatedHotelForRewardCustomer, startDate, endDate)>0){
                bestRatedHotelForRewardCustomer = hotel;
            }

        }
        return bestRatedHotelForRewardCustomer;
    }

    /**
     * Compares two hotels based on their ratings.
     *
     * @param hotel1 The first hotel.
     * @param hotel2 The second hotel.
     * @param startDate starting date.
     * @param endDate ending date.
     * @return An integer representing the comparison result.
     */
    public int compareHotels(Hotel hotel1, Hotel hotel2, LocalDate startDate, LocalDate endDate) {
        /**
         * Comparing the ratings of hotels.
         * @param rating1 Rating of first Hotel.
         * @param rating2 Rating of second Hotel.
         */
        int ratingComparison = Integer.compare(hotel1.getRating(), hotel2.getRating());

        /**
         * If the ratings are same then comparing the rates.
         * Using 'if' if the rating is equal
         * @param TotalCostHotel1 total cost of hotel 1.
         * @param TotalCostHotel2 total cost of hotel 2.
         * @return the cheapest hotel
         * @return the best rated hotel if the rate isn't equal
         */
        if(ratingComparison == 0) {
            int totalCostComparison = Integer.compare(calculateTotalHotelCost(hotel1, startDate, endDate), calculateTotalHotelCost(hotel2, startDate, endDate));
            return totalCostComparison;
        }
        return ratingComparison;
    }

    public int compareHotelsForRewardCustomer(Hotel hotel1, Hotel hotel2, LocalDate startDate, LocalDate endDate) {
        /**
         * Comparing the ratings of hotels.
         * @param rating1 Rating of first Hotel.
         * @param rating2 Rating of second Hotel.
         */
        int ratingComparison = Integer.compare(hotel1.getRating(), hotel2.getRating());

        /**
         * If the ratings are same then comparing the rates.
         * Using 'if' if the rating is equal
         * @param TotalCostHotel1 total cost of hotel 1.
         * @param TotalCostHotel2 total cost of hotel 2.
         * @return the cheapest hotel
         * @return the best rated hotel if the rate isn't equal
         */
        if(ratingComparison == 0) {
            int totalCostComparison = Integer.compare(calculateTotalHotelCostForRewardCustomer(hotel1, startDate, endDate), calculateTotalHotelCostForRewardCustomer(hotel2, startDate, endDate));
            return totalCostComparison;
        }
        return ratingComparison;
    }
}
