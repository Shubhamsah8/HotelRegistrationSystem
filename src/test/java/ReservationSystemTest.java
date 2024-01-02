import org.example.HotelReservation;
import org.example.Hotel;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    @description: This class contains test cases for the hotel reservation system.
*/
class ReservationSystemTest {

    /*
        @description: Tests the retrieval of the hotel name.
        @parameters: None
        @return: None
    */
    @Test
    void testHotelName(){
        Hotel hotel1 = new Hotel("Lakewood");

        /*
            @description: Validates that the retrieved hotel name is "Lakewood".
            @parameters: None
            @return: Expects the hotel name to be "Lakewood".
        */
        Assert.assertEquals("Lakewood", hotel1.getName());
    }

    /*
        @description: Tests the retrieval of the rate for a specific date.
        @parameters: None
        @return: None
    */
    @Test
    void testRate(){
        Hotel hotel1 = new Hotel("Lakewood");
        hotel1.addRates(LocalDate.of(2023, 12, 5), 560);

        /*
            @description: Validates that the retrieved rate for the date 2023-12-5 is 560.
            @parameters: None
            @return: Expects the rate to be 560.
        */
        Assert.assertEquals(560, hotel1.getRates(LocalDate.of(2023, 12,5)));
    }

    /*
        @description: Tests the finding of the cheapest hotel for a given date range.
        @parameters: None
        @return: None
    */
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

        /*
            @description: Validates that the cheapest hotel for the date range is "Redwood" with a total rate of $800.
            @parameters: None
            @return: Expects the result string to be "Redwood Total Rate: $800".
        */
        String cheapHotel = hotelReservation.findCheapestHotel(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 15));
        System.out.println(cheapHotel);
        Assert.assertEquals("Redwood Total Rate: $800", cheapHotel);
    }
}
