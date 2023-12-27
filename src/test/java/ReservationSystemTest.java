import org.example.HotelReservation;
import org.example.Hotel;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ReservationSystemTest {


    @Test
    void testFindCheapestHotel(){
        Hotel lakewood = new Hotel("Lakewood");
        lakewood.addRegularRates(LocalDate.of(2020, 9, 10), 100);
        lakewood.addRegularRates(LocalDate.of(2020, 9, 11), 120);

        Hotel bridgewood = new Hotel("Bridgewood");
        bridgewood.addRegularRates(LocalDate.of(2020, 9, 10), 120);
        bridgewood.addRegularRates(LocalDate.of(2020, 9, 11), 100);

        Hotel ridgewood = new Hotel("Ridgewood");
        ridgewood.addRegularRates(LocalDate.of(2020, 9, 10), 150);
        ridgewood.addRegularRates(LocalDate.of(2020, 9, 11), 150);

        HotelReservation reservationSystem = new HotelReservation();
        reservationSystem.addHotel(lakewood);
        reservationSystem.addHotel(bridgewood);
        reservationSystem.addHotel(ridgewood);

        String cheapestHotel = reservationSystem.findCheapestHotel(LocalDate.of(2020, 9, 10), LocalDate.of(2020, 9, 11));
        assertEquals("Lakewood, Total Rates: $220", cheapestHotel);
    }

    @Test
    void testRegularCustomerRates() {
        Hotel lakewood = new Hotel("Lakewood");
        lakewood.addRegularRates(LocalDate.of(2020, 9, 10), 100);
        lakewood.addRegularRates(LocalDate.of(2020, 9, 11), 120);

        // Other hotels with regular rates
        Hotel bridgewood = new Hotel("Bridgewood");
        bridgewood.addRegularRates(LocalDate.of(2020, 9, 10), 120);
        bridgewood.addRegularRates(LocalDate.of(2020, 9, 11), 100);

        Hotel ridgewood = new Hotel("Ridgewood");
        ridgewood.addRegularRates(LocalDate.of(2020, 9, 10), 150);
        ridgewood.addRegularRates(LocalDate.of(2020, 9, 11), 150);

        HotelReservation reservationSystem = new HotelReservation();
        reservationSystem.addHotel(lakewood);
        reservationSystem.addHotel(bridgewood);
        reservationSystem.addHotel(ridgewood);

        // Assuming regular customer rates are used in findCheapestHotel
        String cheapestHotel = reservationSystem.findCheapestHotel(LocalDate.of(2020, 9, 10), LocalDate.of(2020, 9, 11));
        assertEquals("Lakewood, Total Rates: $190", cheapestHotel);
    }
}
