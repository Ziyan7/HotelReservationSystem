package userRegistration.HotelReservationWorskshop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;


public class HotelReservationSystemTest {
	HotelReservationSystem hotelreservation = new HotelReservationSystem();

	@Before
	public void HotelAdded() {
		assertTrue(hotelreservation.listHotel("Lakewood", 110,90,3));
		assertTrue(hotelreservation.listHotel("BridgeWood", 150,50,4));
		assertTrue(hotelreservation.listHotel("RidgeWood", 220,150,5));
	}

	@Test
	public void checkCheapHoteForRegalurCustomer() {
		String cheapHotel = hotelreservation.cheapHotelForRegularCustomer("11Sep2020", "12Sep2020");
		assertEquals("Lakewood and BridgeWood", cheapHotel);
	}
}
