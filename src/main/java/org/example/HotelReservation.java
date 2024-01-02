import java.time.LocalDate;
import java.util.*;

/**
 * HotelReservation class representing a system for managing hotels and finding the cheapest hotel.
 */
public class HotelReservation {
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
    public void addHotel(Hotel hotel) {
        // @description: Adds a hotel to the list of hotels.
        // @parameters: Hotel hotel - the hotel to be added.
        hotels.add(hotel);
    }

    /**
     * Finds the cheapest hotel based on total rates for a specified date range.
     *
     * @param startDate The start date of the date range.
     * @param endDate   The end date of the date range.
     * @return A string containing the name of the cheapest hotel and its total rate for the specified date range.
     */
    public String findCheapestHotel(LocalDate startDate, LocalDate endDate) {
        // @description: Finds the cheapest hotel based on total rates for a specified date range.
        // @parameters: LocalDate startDate - the start date of the date range,
        //              LocalDate endDate - the end date of the date range.
        int minCost = Integer.MAX_VALUE;
        String cheapestHotel = null;

        for (Hotel hotel : hotels) {
            int totalCost = calculateTotalHotelCost(hotel, startDate, endDate);
            if (totalCost < minCost) {
                minCost = totalCost;
                cheapestHotel = hotel.getName();
            }
        }
        return (cheapestHotel != null) ? cheapestHotel + " Total Rate: $" + minCost : "No Hotels Available";
    }

    /**
     * Calculates the total cost of a hotel for a specified date range.
     *
     * @param hotel     The hotel for which the total cost is calculated.
     * @param startDate The start date of the date range.
     * @param endDate   The end date of the date range.
     * @return The total cost of the hotel for the specified date range.
     */
    public int calculateTotalHotelCost(Hotel hotel, LocalDate startDate, LocalDate endDate) {
        // @description: Calculates the total cost of a hotel for a specified date range.
        // @parameters: Hotel hotel - the hotel for which the total cost is calculated,
        //              LocalDate startDate - the start date of the date range,
        //              LocalDate endDate - the end date of the date range.
        int totalCost = 0;

        while (!startDate.isAfter(endDate)) {
            totalCost += hotel.getRates(startDate);
            startDate = startDate.plusDays(1);
        }
        return totalCost;
    }

    /**
     * Finds the cheapest hotel based on hotel ratings for a specified date range.
     *
     * @param startDate The start date of the date range.
     * @param endDate   The end date of the date range.
     * @return A string containing the name of the cheapest hotel by rating and its total rate for the specified date range.
     */
    public String findCheapestHotelByRating(LocalDate startDate, LocalDate endDate) {
        // @description: Finds the cheapest hotel based on hotel ratings for a specified date range.
        // @parameters: LocalDate startDate - the start date of the date range,
        //              LocalDate endDate - the end date of the date range.
        Hotel cheapestHotel = null;
        for (Hotel hotel : hotels) {
            if (cheapestHotel == null || compareHotels(hotel, cheapestHotel) < 0) {
                cheapestHotel = hotel;
            }
        }
        return (cheapestHotel != null) ? cheapestHotel.getName() + ", Total Rates: $" + calculateTotalHotelCost(cheapestHotel, startDate, endDate) : "No Hotels Available";
    }

    /**
     * Compares two hotels based on their ratings.
     *
     * @param hotel1 The first hotel.
     * @param hotel2 The second hotel.
     * @return The result of the comparison (-1 if hotel1 has a lower rating, 0 if equal, 1 if hotel1 has a higher rating).
     */
    public int compareHotels(Hotel hotel1, Hotel hotel2) {
        // @description: Compares two hotels based on their ratings.
        // @parameters: Hotel hotel1 - the first hotel,
        //              Hotel hotel2 - the second hotel.
        return Integer.compare(hotel1.getRating(), hotel2.getRating());
    }
}
