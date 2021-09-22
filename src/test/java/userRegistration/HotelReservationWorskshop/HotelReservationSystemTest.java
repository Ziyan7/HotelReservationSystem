package userRegistration.HotelReservationWorskshop;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class HotelReservationSystemTest {

	@Test
	public void HotelAdded()
	{
		HotelReservationSystem hotelreservation = new HotelReservationSystem();
		String name = "Lakewood";
		double weekdayRegularPrice = 110;
		double weekdayRewardPrice = 80;
		double WeekendRegularRate = 90;
		double WeekendRewardRate = 80;
		
		Boolean check = hotelreservation.listHotel(name, weekdayRegularPrice, weekdayRewardPrice, WeekendRegularRate, WeekendRewardRate);
		assertEquals(true,check);
		
		
	}
}
