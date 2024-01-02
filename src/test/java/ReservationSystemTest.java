import org.example.HotelReservation;
import org.example.Hotel;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the Reservation System.
 */
class ReservationSystemTest {

    /**
     * Test case to verify if the hotel name is correctly set.
     */
    @Test
    void testHotelName() {
        // @description: Verifies if the hotel name is correctly set.
        Hotel hotel1 = new Hotel("Lakewood");
        Assert.assertEquals("Lakewood", hotel1.getName());
    }

    /**
     * Test case to verify if the rate is correctly added and retrieved.
     */
    @Test
    void testRate() {
        // @description: Verifies if the rate is correctly added and retrieved.
        Hotel hotel1 = new Hotel("Lakewood");
        hotel1.addRates(LocalDate.of(2023, 12, 5), 560);
        Assert.assertEquals(560, hotel1.getRates(LocalDate.of(2023, 12, 5)));
    }

    /**
     * Test case to find the cheapest hotel for a date range.
     */
    @Test
    void testFindCheapestHotel() {
        // @description: Finds the cheapest hotel for a given date range.
        // @parameters: LocalDate startDate - start date of the date range,
        //             LocalDate endDate - end date of the date range.
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
     * Test case to verify if the hotel rating is correctly set and retrieved.
     */
    @Test
    void testRating() {
        // @description: Verifies if the hotel rating is correctly set and retrieved.
        // @parameters: int rating - the rating to be set for the hotel.
        Hotel hotel1 = new Hotel("Lakewood");
        hotel1.addRates(LocalDate.of(2023, 12, 1), 500);
        hotel1.setRating(4);
        Assert.assertEquals(4, hotel1.getRating());
    
