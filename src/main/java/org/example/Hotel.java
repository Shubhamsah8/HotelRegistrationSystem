import java.time.LocalDate;
import java.util.*;
import java.time.DayOfWeek;

/**
 * Hotel class representing a hotel with rates, ratings, and other details.
 */
public class Hotel {

    private String name;
    private Map<LocalDate, Integer> regularRates;
    private Map<LocalDate, Integer> weekdayRate;
    private Map<LocalDate, Integer> weekendRate;
    private int rating;

    /**
     * Constructor to initialize a hotel with the given name.
     *
     * @param name The name of the hotel.
     */
    public Hotel(String name) {
        this.name = name;
        this.regularRates = new HashMap<>();
        this.weekdayRate = new HashMap<>();
        this.weekendRate = new HashMap<>();
        this.rating = 0;
    }

    /**
     * Adds rates for a specific date, distinguishing between weekday and weekend rates.
     *
     * @param date The date for which rates are added.
     * @param rate The rate for the specified date.
     */
    public void addRates(LocalDate date, int rate) {
        // @description: Adds rates for a specific date, distinguishing between weekday and weekend rates.
        // @parameters: LocalDate date - the date for which rates are added,
        //              int rate - the rate for the specified date.
        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
        if (isWeekend) {
            weekendRate.put(date, rate);
        } else {
            weekdayRate.put(date, rate);
        }
    }

    /**
     * Gets the rate for a specific date, considering weekday or weekend rates.
     *
     * @param date The date for which the rate is retrieved.
     * @return The rate for the specified date.
     */
    public int getRates(LocalDate date) {
        // @description: Gets the rate for a specific date, considering weekday or weekend rates.
        // @parameters: LocalDate date - the date for which the rate is retrieved.
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        Map<LocalDate, Integer> rates = (date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY) ? weekendRate : weekdayRate;
        return rates.get(date);
    }

    /**
     * Adds regular rates for a specific date.
     *
     * @param date The date for which regular rates are added.
     * @param rate The regular rate for the specified date.
     */
    public void addRegularRates(LocalDate date, int rate) {
        // @description: Adds regular rates for a specific date.
        // @parameters: LocalDate date - the date for which regular rates are added,
        //              int rate - the regular rate for the specified date.
        regularRates.put(date, rate);
    }

    /**
     * Gets the regular rate for a specific date.
     *
     * @param date The date for which the regular rate is retrieved.
     * @return The regular rate for the specified date.
     */
    public int getRegularRates(LocalDate date) {
        // @description: Gets the regular rate for a specific date.
        // @parameters: LocalDate date - the date for which the regular rate is retrieved.
        return regularRates.get(date);
    }

    /**
     * Gets the rating of the hotel.
     *
     * @return The rating of the hotel.
     */
    public int getRating() {
        // @description: Gets the rating of the hotel.
        return rating;
    }

    /**
     * Sets the rating of the hotel within the range of 1 to 5.
     *
     * @param rating The rating to be set for the hotel.
     */
    public void setRating(int rating) {
        // @description: Sets the rating of the hotel within the range of 1 to 5.
        // @parameters: int rating - the rating to be set for the hotel.
        this.rating = Math.max(1, Math.min(5, rating));
    }

    /**
     * Gets the name of the hotel.
     *
     * @return The name of the hotel.
     */
    public String getName() {
        // @description: Gets the name of the hotel.
        return name;
    }
}
