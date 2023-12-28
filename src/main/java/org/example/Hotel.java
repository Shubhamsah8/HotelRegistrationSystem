package org.example;

import java.time.LocalDate;
import java.util.*;
import java.time.DayOfWeek;

public class Hotel {

    private String name;
    private Map<LocalDate date, rate> regularRates;

    public Hotel(String name) {
        this.name = name;
        this.regularRates = new HashMap<>();
    }

    public void addRegularRates(LocalDate date, int rate) {
        regularRates.put(date, rate);
    }


    public int getRegularRates(LocalDate date) {
        return regularRates.get(date);
    }

    public String getName() {
        return name;
    }
}
