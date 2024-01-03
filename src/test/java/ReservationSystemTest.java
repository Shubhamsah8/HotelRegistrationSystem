import org.example.HotelReservation;
import org.example.Hotel;

import java.time.LocalDate;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ReservationSystemTest class to test the Hotel and HotelReservation classes.
 */
class ReservationSystemTest {

    /**
     * Test case to verify if the hotel name is set correctly.
     */
    @Test
    void testHotelName() {
        Hotel hotel1 = new Hotel("Lakewood");
        Assert.assertEquals("Lakewood", hotel1.getName());
    }

    /**
     * Test case to verify if the hotel rates are added and retrieved correctly.
     */
    @Test
    void testRate() {
        Hotel hotel1 = new Hotel("Lakewood");
        hotel1.addRates(LocalDate.of(2023, 12, 5), 560);
        Assert.assertEquals(560, hotel1.getRates(LocalDate.of(2023, 12, 5)));
    }

    /**
     * Test case to find the cheapest hotel within a date range and verify the result.
     */
    @Test
    void testFindCheapestHotel() {
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

        String cheapHotel = hotelReservation.findCheapestHotel(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 2));
        Assert.assertEquals("Bridgewood, Total Rates: $750", cheapHotel);
    }

    /**
     * Test case to verify if the hotel rating is set correctly.
     */
    @Test
    void testRating() {
        Hotel hotel1 = new Hotel("Lakewood");
        hotel1.addRates(LocalDate.of(2023, 12, 1), 500);
        hotel1.setRating(4);
        Assert.assertEquals(4, hotel1.getRating());
    }

    /**
     * Test case to find the cheapest hotel by rating within a date range and verify the result.
     */
    @Test
    void testCheapestHotelByRating() {
        Hotel hotel1 = new Hotel("Lakewood");
        hotel1.addRates(LocalDate.of(2023, 12, 1), 560);
        hotel1.addRates(LocalDate.of(2023, 12, 2), 570);
        hotel1.setRating(3);

        Hotel hotel2 = new Hotel("Bridgewood");
        hotel2.addRates(LocalDate.of(2023, 12, 1), 600);
        hotel2.addRates(LocalDate.of(2023, 12, 2), 600);
        hotel2.setRating(5);

        Hotel hotel3 = new Hotel("Ridgewood");
        hotel3.addRates(LocalDate.of(2023, 12, 1), 520);
        hotel3.addRates(LocalDate.of(2023, 12, 2), 530);
        hotel3.setRating(4);

        HotelReservation hotelReservation = new HotelReservation();

        hotelReservation.addHotel(hotel1);
        hotelReservation.addHotel(hotel2);
        hotelReservation.addHotel(hotel3);
        Assert.assertEquals("Bridgewood, Total Rates: $1200", hotelReservation.findCheapestHotelByRating(LocalDate.of(2023,12, 1), LocalDate.of(2023, 12, 2)));
    }

    /**
     * Test case to find the best-rated hotel and verify the result.
     */
    @Test
    void testBestRatedHotel() {
        Hotel hotel1 = new Hotel("Lakewood");
        hotel1.addRates(LocalDate.of(2023, 12, 1), 560);
        hotel1.addRates(LocalDate.of(2023, 12, 2), 570);
        hotel1.setRating(5);

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

        Assert.assertEquals("Lakewood", hotelReservation.findBestRatedHotel(LocalDate.of(2023, 12, 1), LocalDate.of(2023, 12, 2)).getName());
    }

    /**
     * Test case to check whether the special rates get added or not.
     */
    @Test
    void testSpecialRates(){
        Hotel lakewood = new Hotel("lakewood");
        lakewood.addSpecialRates(LocalDate.of(2024, 1, 1), 80);
        lakewood.addSpecialRates(LocalDate.of(2023, 1, 6), 80);

        Hotel bridgewood = new Hotel("bridgewood");
        bridgewood.addSpecialRates(LocalDate.of(2024, 1, 1), 50);
        bridgewood.addSpecialRates(LocalDate.of(2024, 1, 6), 110);

        Hotel ridgewood = new Hotel("ridgewood");
        ridgewood.addSpecialRates(LocalDate.of(2024, 1, 1), 40);
        ridgewood.addSpecialRates(LocalDate.of(2024, 1, 6), 100);

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

        Assert.assertEquals(110, bridgewood.getSpecialRates(LocalDate.of(2024, 1, 6)));
        Assert.assertEquals(80, lakewood.getSpecialRates(LocalDate.of(2024, 1, 1)));
    }

    /**
     * Test cases find the cheapest best rated hotel for Reward customer.
     */
    @Test
    void testCheapestBestRatedHotelForRewardCustomer(){
        Hotel lakewood = new Hotel("lakewood");
        lakewood.addSpecialRates(LocalDate.of(2024, 1, 1), 80);
        lakewood.addSpecialRates(LocalDate.of(2023, 12, 31), 80);
        lakewood.setRating(5);

        Hotel bridgewood = new Hotel("bridgewood");
        bridgewood.addSpecialRates(LocalDate.of(2024, 1, 1), 50);
        bridgewood.addSpecialRates(LocalDate.of(2023, 12, 31), 110);
        bridgewood.setRating(4);

        Hotel ridgewood = new Hotel("ridgewood");
        ridgewood.addSpecialRates(LocalDate.of(2024, 1, 1), 40);
        ridgewood.addSpecialRates(LocalDate.of(2023, 12, 31), 100);
        ridgewood.setRating(3);

        HotelReservation hotelReservation = new HotelReservation();
        hotelReservation.addHotel(lakewood);
        hotelReservation.addHotel(bridgewood);
        hotelReservation.addHotel(ridgewood);

        Assert.assertEquals("lakewood Total Rates: $160", hotelReservation.findCheapestBestRatedHotelForRewardCustomer(LocalDate.of(2023, 12, 31), LocalDate.of(2024, 1, 1)));
    }
}
