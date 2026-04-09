package abc;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {
	@DataProvider
	public Object[][] dataProvider_BookingTicket() {

	    Object[][] objArr = new Object[3][2];

	    objArr[0][0] = "India";
	    objArr[0][1] = "Paris";

	    objArr[1][0] = "TamilNadu";
	    objArr[1][1] = "Kerala";

	    objArr[2][0] = "TamilNadu";
	    objArr[2][1] = "Goa";

	    return objArr;
	}
	@Test(dataProvider = "dataProvider_BookingTicket")
	public void bookingTest(String src, String dst) {

	    System.out.println("Booking Ticket from " + src + " to " + dst);
	}
}