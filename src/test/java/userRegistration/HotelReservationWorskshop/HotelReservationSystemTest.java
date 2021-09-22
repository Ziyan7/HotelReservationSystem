package userRegistration.HotelReservationWorskshop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;


public class HotelReservationSystemTest {
	HotelReservationSystem hotelreservation = new HotelReservationSystem();

	@Before
	public void HotelAdded() {
		assertTrue(hotelreservation.listHotel("Lakewood", 110));
		assertTrue(hotelreservation.listHotel("BridgeWood", 160));
		assertTrue(hotelreservation.listHotel("RidgeWood", 220));
		int hotelCount = hotelreservation.hotelCount();
		assertEquals(3,hotelCount);
	}

	@Test
	public void checkCheapHoteForRegalurCustomer() {
		String cheapHotel = hotelreservation.cheapHotelForRegularCustomer("10Sep2020", "11Sep2020");
		assertEquals("Lakewood", cheapHotel);
	}
}
