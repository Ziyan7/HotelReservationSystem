package userRegistration.HotelReservationWorskshop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;


public class HotelReservationSystemTest {
	HotelReservationSystem hotelreservation = new HotelReservationSystem();

	@Before
	public void HotelAdded() {
		assertTrue(hotelreservation.listHotel("Lakewood", 110,90,80,80,3));
		assertTrue(hotelreservation.listHotel("BridgeWood", 150,50,110,50,4));
		assertTrue(hotelreservation.listHotel("RidgeWood", 220,150,100,40,5));
		
	}

	@Test
	public void checkCheapHoteForRegalurCustomer() {
		String cheapHotel = hotelreservation.cheapHotelForRegularCustomer("Regular","11Sep2020", "12Sep2020");
		assertEquals("BridgeWood with Totalrate = 200", cheapHotel);
		String BestRate = hotelreservation.BestRatedHotelForRegularCustomer();
		assertEquals("RidgeWood with Totalrate = 370", BestRate);
	}
	@Test
	public void checkCheapestHotelWhenGivenDateRangeForRewardCustomer() 
	{
		String cheapHotel = hotelreservation.cheapHotelForRegularCustomer("Reward","11Sep2020","12Sep2020");
		assertEquals("RidgeWood with Totalrate = 140",cheapHotel);
	}
}
