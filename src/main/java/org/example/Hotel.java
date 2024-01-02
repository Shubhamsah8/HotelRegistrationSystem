package org.example;

import java.time.LocalDate;
import java.util.*;
import java.time.DayOfWeek;

/**
 * Hotel class representing a hotel with regular and weekend rates.
 */
public class Hotel {

    private String name;
    private Map<LocalDate, Integer> regularRates;
    private Map<LocalDate, Integer> weekdayRate;
    private Map<LocalDate, Integer> weekendRate;
    private int rating;
    private Map<LocalDate, Integer> specialWeekDayRate;
    private Map<LocalDate, Integer> specialWeekendRate;

    /**
     * Constructor to initialize a Hotel object with the given name.
     *
     * @param name The name of the hotel.
     */
    public Hotel(String name) {
        this.name = name;
        this.regularRates = new HashMap<>();
        this.weekdayRate = new HashMap<>();
        this.weekendRate = new HashMap<>();
        this.rating = 0;
        this.specialWeekDayRate = new HashMap<>();
        this.specialWeekendRate = new HashMap<>();
    }

    /**
     * Adds rates for a specific date.
     *
     * @param date The date for which the rate is added.
     * @param rate The rate for the specified date.
     */
    public void addRates(LocalDate date, int rate) {

        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
        if (isWeekend) {
            weekendRate.put(date, rate);
        } else {
            weekdayRate.put(date, rate);
        }
    }

    /**
     * Add rates for specific dates, option to specify if it's special rates.
     * @param date for specific dates.
     * @param rate to add the rates.
     * @param isSpecial to check if it's special or not.
     */
     public void addRates(LocalDate date, int rate, boolean isSpecial){
        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
        if(isWeekend){
            (isSpecial? specialWeekendRate: weekendRate).put(date, rate);
        }
        else{
            (isSpecial? specialWeekDayRate: weekdayRate).put(date, rate);
        }
     }

    /**
     * Adding special rates by using the above function for convineince.
     * Like I don't need to write boolean value again and again.
     * @param date date for the special customer.
     * @param rate rate for the special customer.
     */
     public void addSpecialRates(LocalDate date, int rate){
         addRates(date, rate, true);
     }

    /**
     * Gets the rate for a specific date.
     *
     * @param date The date for which the rate is retrieved.
     * @return The rate for the specified date.
     */
    public int getRates(LocalDate date) {
        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
        Map<LocalDate, Integer> rates = isWeekend? weekendRate: weekdayRate;
        return rates.get(date);
    }

    /**
     * Get the rate for a specific date for the special customer.
     * @param date The date for which the rate is retrieved.
     * @return The rate for the specified date.
     */
    public int getSpecialRates(LocalDate date) {
        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
        Map<LocalDate, Integer> rates = isWeekend? specialWeekendRate: specialWeekDayRate;
        return rates.get(date);
    }

    /**
     * Adds regular rates for a specific date.
     *
     * @param date The date for which the regular rate is added.
     * @param rate The regular rate for the specified date.
     */
    public void addRegularRates(LocalDate date, int rate) {
        regularRates.put(date, rate);
    }

    /**
     * Gets the regular rate for a specific date.
     *
     * @param date The date for which the regular rate is retrieved.
     * @return The regular rate for the specified date.
     */
    public int getRegularRates(LocalDate date) {
        return regularRates.get(date);
    }

    /**
     * Gets the rating of the hotel.
     *
     * @return The rating of the hotel.
     */
    public int getRating() {
        return rating;
    }
    /**
     * Sets the rating of the hotel, constrained to be between 1 and 5.
     *
     * @param rating The rating to set.
     */
    public void setRating(int rating) {
        this.rating = Math.max(1, Math.min(5, rating));
    }

    /**
     * Gets the name of the hotel.
     *
     * @return The name of the hotel.
     */
    public String getName() {
        return name;
    }

    /**
     * Overrides the default toString method to provide a string representation of the Hotel object.
     *
     * @return A string representation of the Hotel object.
     */
    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}
