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
}
