package org.example;

import java.time.LocalDate;
import java.util.*;
import java.time.DayOfWeek;

public class Hotel {

    private String name;
    private Map<LocalDate, Integer> regularRates;
    private Map<LocalDate, Integer> weekdayRate;
    private Map<LocalDate, Integer> weekendRate;
    private int rating;

    public Hotel(String name) {
        this.name = name;
        this.regularRates = new HashMap<>();
        this.weekdayRate = new HashMap<>();
        this.weekendRate = new HashMap<>();
        this.rating = 0;
    }

    public void addRates(LocalDate date, int rate){

        boolean isWeekend = date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY;
        if(isWeekend){
            weekendRate.put(date, rate);
        }
        else{
            weekdayRate.put(date, rate);
        }
    }

    public int getRates(LocalDate date){
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        Map<LocalDate, Integer> rates = (date.getDayOfWeek() == DayOfWeek.SUNDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY)? weekendRate: weekdayRate;
        return rates.get(date);
    }
    public void addRegularRates(LocalDate date, int rate) {
        regularRates.put(date, rate);
    }

    public int getRating(){
        return rating;
    }

    public void setRating(int rating){
        this.rating = Math.max(1, Math.min(5,rating));
    }
    public int getRegularRates(LocalDate date) {
        return regularRates.get(date);
    }

    public String getName() {
        return name;
    }
}