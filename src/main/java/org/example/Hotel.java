package org.example;

import java.time.LocalDate;
import java.util.*;
import java.time.DayOfWeek;

/*
    @description: This class represents a hotel with regular rates, weekday rates, and weekend rates.
*/
public class Hotel {

    private String name;
    private Map<LocalDate, Integer> regularRates;
    private Map<LocalDate, Integer> weekdayRate;
    private Map<LocalDate, Integer> weekendRate;
    private int rating;

    /*
        @description: Constructor to initialize a Hotel object with the specified name and empty rate maps.
        @parameters: name - The name of the hotel.
        @return: None
    */
    public Hotel(String name) {
        this.name = name;
        this.regularRates = new HashMap<>();
        this.weekdayRate = new HashMap<>();
        this.weekendRate = new HashMap<>();
        this.rating = 0;
    }

    /*
        @description: Adds rates for a specific date to the appropriate rate map (weekday or weekend).
        @parameters: date - The date for which rates are added, rate - The rate for the specified date.
        @return: None
    */
    public void addRates(LocalDate date, int rate) {
        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
        if (isWeekend) {
            weekendRate.put(date, rate);
        } else {
            weekdayRate.put(date, rate);
        }
    }

    /*
        @description: Retrieves the rate for a specific date based on the day of the week.
        @parameters: date - The date for which the rate is retrieved.
        @return: The rate for the specified date.
    */
    public int getRates(LocalDate date) {
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        Map<LocalDate, Integer> rates = (dayOfWeek == DayOfWeek.SUNDAY || dayOfWeek == DayOfWeek.SATURDAY) ? weekendRate : weekdayRate;
        return rates.get(date);
    }

    /*
        @description: Adds regular rates for a specific date.
        @parameters: date - The date for which regular rates are added, rate - The regular rate for the specified date.
        @return: None
    */
    public void addRegularRates(LocalDate date, int rate) {
        regularRates.put(date, rate);
    }

    /*
        @description: Retrieves the regular rate for a specific date.
        @parameters: date - The date for which the regular rate is retrieved.
        @return: The regular rate for the specified date.
    */
    public int getRegularRates(LocalDate date) {
        return regularRates.get(date);
    }

    /*
        @description: Retrieves the name of the hotel.
        @parameters: None
        @return: The name of the hotel.
    */
    public String getName() {
        return name;
    }

    /*
        @description: Retrieves the rating of the hotel.
        @parameters: None
        @return: The rating of the hotel.
    */
    public int getRating() {
        return rating;
    }

    /*
        @description: Sets the rating of the hotel within the range of 1 to 5.
        @parameters: rating - The new rating for the hotel.
        @return: None
    */
    public void setRating(int rating) {
        this.rating = Math.max(1, Math.min(5, rating));
    }
}
