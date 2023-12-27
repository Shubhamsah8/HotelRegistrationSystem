package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Hotel hotel1 = new Hotel("Lake Wood");
        hotel1.addRegularRates(LocalDate.of(2023, 12, 1), 2500);
        hotel1.addRegularRates(LocalDate.of(2023, 12, 5), 2310);

        Hotel hotel2 = new Hotel("Bride Wood");
        hotel2.addRegularRates(LocalDate.of(2023, 12, 1), 3000);
        hotel2.addRegularRates(LocalDate.of(2023, 12, 5), 3100);

        Hotel hotel3 = new Hotel("Red Wood");
        hotel3.addRegularRates(LocalDate.of(2023, 12, 1), 2300);
        hotel3.addRegularRates(LocalDate.of(2023, 12, 5), 2200);

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel(hotel1);
        hotelReservation.addHotel(hotel2);
        hotelReservation.addHotel(hotel3);

        String cheapestHotel = hotelReservation.findCheapestHotel(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 5));
        System.out.println("Cheapest Hotel: "+cheapestHotel);

    }
}