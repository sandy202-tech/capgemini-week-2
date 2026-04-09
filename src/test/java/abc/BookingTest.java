package abc;

import org.testng.annotations.Test;

public class BookingTest {

    @Test(dataProvider = "dataProvider_BookingTicket", dataProviderClass = DataProviderClass.class)
    public void bookingTest(String src, String dst) {

        System.out.println("Booking Ticket from " + src + " to " + dst);
    }
}