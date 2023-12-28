import org.example.HotelReservation;
import org.example.Hotel;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class ReservationSystemTest {


    @Test
    void testHotelName(){
        Hotel hotel1 = new Hotel("Lakewood");
        Assert.assertEquals("Lakewood", hotel1.getName());
    }

    @Test
    void testRate(){
        Hotel hotel1 = new Hotel("Lakewood");
        hotel1.addRates(LocalDate.of(2023, 12, 5), 560);
        Assert.assertEquals(560, hotel1.getRates(LocalDate.of(2023, 12,5)));
    }
    @Test
    void testFindCheapestHotel(){
        Hotel lakewood = new Hotel("Lakewood");
        lakewood.addRates(LocalDate.of(2023, 12, 1), 600);
        lakewood.addRates(LocalDate.of(2023, 12, 2), 500);

        Hotel redwood = new Hotel("Redwood");
        redwood.addRates(LocalDate.of(2023, 12, 1), 300);
        redwood.addRates(LocalDate.of(2023, 12, 2), 500);

        Hotel bridgewood = new Hotel("Bridgewood");
        bridgewood.addRates(LocalDate.of(2023,12, 1), 350);
        bridgewood.addRates(LocalDate.of(2023, 12, 2), 400);

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(redwood);
        hotelReservation.addHotel(bridgewood);

        String cheapHotel = hotelReservation.findCheapestHotel(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 15));
        System.out.println(cheapHotel);
        Assert.assertEquals("Redwood Total Rate: $800", cheapHotel);
    }

}
