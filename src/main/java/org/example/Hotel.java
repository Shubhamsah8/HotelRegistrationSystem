package org.example;

import java.time.LocalDate;
import java.util.*;
import java.time.DayOfWeek;

/*
    @description: This class represents a hotel and its rates for different dates.
*/
public class Hotel {

    private String name;
    private Map<LocalDate, Integer> regularRates;
    private Map<LocalDate, Integer> weekdayRate;
    private Map<LocalDate, Integer> weekendRate;
    private int rating;

    /*
        @description: Constructor to initialize a Hotel object with the given name.
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
        @description: Adds rates for a specific date, considering weekday and weekend rates.
        @parameters: date - The date for which rates are added, rate - The rate for the given date.
        @return: None
    */
    public void addRates(LocalDate date, int rate){

        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
        if(isWeekend){
            weekendRate.put(date, rate);
        }
        else{
            weekdayRate.put(date, rate);
        }
    }

    /*
        @description: Gets the rate for a specific date, considering weekday and weekend rates.
        @parameters: date - The date for which the rate is retrieved.
        @return: The rate for the given date.
    */
    public int getRates(LocalDate date){
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        Map<LocalDate, Integer> rates = (date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY)? weekendRate: weekdayRate;
        return rates.get(date);
    }

    /*
        @description: Adds regular rates for a specific date.
        @parameters: date - The date for which regular rates are added, rate - The regular rate for the given date.
        @return: None
    */
    public void addRegularRates(LocalDate date, int rate) {
        regularRates.put(date, rate);
    }

    /*
        @description: Gets the regular rate for a specific date.
        @parameters: date - The date for which the regular rate is retrieved.
        @return: The regular rate for the given date.
    */
    public int getRegularRates(LocalDate date) {
        return regularRates.get(date);
    }

    /*
        @description: Gets the name of the hotel.
        @parameters: None
        @return: The name of the hotel.
    */
    public String getName() {
        return name;
    }
}
