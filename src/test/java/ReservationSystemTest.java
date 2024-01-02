import org.example.HotelReservation;
import org.example.Hotel;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * ReservationSystemTest class for testing hotel-related functionality.
 */
class ReservationSystemTest {

    /**
     * Tests the getName method of the Hotel class.
     */
    @Test
    void testHotelName() {
        // @description: Tests the getName method of the Hotel class.
        Hotel hotel1 = new Hotel("Lakewood");
        Assert.assertEquals("Lakewood", hotel1.getName());
    }

    /**
     * Tests the addRates and getRates methods of the Hotel class.
     */
    @Test
    void testRate() {
        // @description: Tests the addRates and getRates methods of the Hotel class.
        Hotel hotel1 = new Hotel("Lakewood");
        hotel1.addRates(LocalDate.of(2023, 12, 5), 560);
        Assert.assertEquals(560, hotel1.getRates(LocalDate.of(2023, 12, 5)));
    }

    /**
     * Tests the findCheapestHotel method of the HotelReservation class.
     */
    @Test
    void testFindCheapestHotel() {
        // @description: Tests the findCheapestHotel method of the HotelReservation class.
        Hotel lakewood = new Hotel("Lakewood");
        lakewood.addRates(LocalDate.of(2023, 12, 1), 600);
        lakewood.addRates(LocalDate.of(2023, 12, 2), 500);

        Hotel redwood = new Hotel("Redwood");
        redwood.addRates(LocalDate.of(2023, 12, 1), 300);
        redwood.addRates(LocalDate.of(2023, 12, 2), 500);

        Hotel bridgewood = new Hotel("Bridgewood");
        bridgewood.addRates(LocalDate.of(2023, 12, 1), 350);
        bridgewood.addRates(LocalDate.of(2023, 12, 2), 400);

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(redwood);
        hotelReservation.addHotel(bridgewood);

        String cheapHotel = hotelReservation.findCheapestHotel(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 15));
        System.out.println(cheapHotel);
        Assert.assertEquals("Redwood Total Rate: $800", cheapHotel);
    }

    /**
     * Tests the setRating and getRating methods of the Hotel class.
     */
    @Test
    void testRating() {
        // @description: Tests the setRating and getRating methods of the Hotel class.
        Hotel hotel1 = new Hotel("Lakewood");
        hotel1.addRates(LocalDate.of(2023, 12, 1), 500);
        hotel1.setRating(4);
        Assert.assertEquals(4, hotel1.getRating());
    }

    /**
     * Tests the findCheapestHotelByRating method of the HotelReservation class.
     */
    @Test
    void testCheapestHotelByRating() {
        // @description: Tests the findCheapestHotelByRating method of the HotelReservation class.
        Assert.assertEquals("Bridgewood, Total Rates: $600", testRatings());
    }

    /**
     * Helper method for testing findCheapestHotelByRating method.
     *
     * @return A string containing the name of the cheapest hotel by rating and its total rate for a specified date range.
     */
    public static String testRatings() {
        // @description: Helper method for testing findCheapestHotelByRating method.
        Hotel hotel1 = new Hotel("Lakewood");
        hotel1.addRates(LocalDate.of(2023, 12, 1), 560);
        hotel1.addRates(LocalDate.of(2023, 12, 2), 570);
        hotel1.setRating(3);

        Hotel hotel2 = new Hotel("Bridgewood");
        hotel2.addRates(LocalDate.of(2023, 12, 1), 600);
        hotel2.addRates(LocalDate.of(2023, 12, 2), 600);
        hotel2.setRating(5);

        Hotel hotel3 = new Hotel("Redwood");
        hotel3.addRates(LocalDate.of(2023, 12, 1), 520);
        hotel3.addRates(LocalDate.of(2023, 12, 2), 530);
        hotel3.setRating(4);
        HotelReservation hotelReservation = new HotelReservation();

        hotelReservation.addHotel(hotel1);
        hotelReservation.addHotel(hotel2);
        hotelReservation.addHotel(hotel3);

        return hotelReservation.findCheapestHotelByRating(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 2));
    }
}
