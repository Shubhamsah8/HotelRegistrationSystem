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
        hotel1.addRegularRates(LocalDate.of(2023, 12, 5), 560);

        /*
            @description: Validates that the retrieved rate for the date 2023-12-5 is 560.
            @parameters: None
            @return: Expects the rate to be 560.
        */
        Assert.assertEquals(560, hotel1.getRegularRates(LocalDate.of(2023, 12,5)));
    }

    /*
        @description: Tests the finding of the cheapest hotel for a given date range.
        @parameters: None
        @return: None
    */
    @Test
    void testFindCheapestHotel(){
        Hotel lakewood = new Hotel("Lakewood");
        lakewood.addRegularRat
