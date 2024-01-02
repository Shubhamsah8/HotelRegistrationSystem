package org.example;

import java.time.LocalDate;
import java.util.*;

/*
    @description: This class represents a hotel with regular rates for different dates.
*/
public class Hotel {

    private String name;
    private Map<LocalDate, Integer> regularRates;

    /*
        @description: Constructor to initialize the hotel with a name.
        @parameters:
            - name: The name of the hotel.
    */
    public Hotel(String name) {
        this.name = name;
        this.regularRates = new HashMap<>();
    }

    /*
        @description: Adds regular rates for a specific date.
        @parameters:
            - date: The date for which the regular rate is added.
            - rate: The regular rate for the specified date.
        @return: None
    */
    public void addRegularRates(LocalDate date, int rate) {
        regularRates.put(date, rate);
    }

    /*
        @description: Retrieves the regular rate for a specific date.
        @parameters:
            - date: The date for which the regular rate is requested.
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
}
