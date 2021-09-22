package userRegistration.HotelReservationWorskshop;

import java.util.*;
public class HotelReservationSystem {
	List<Hotels> hotelReservation = new ArrayList<>();
	public Boolean listHotel(String name,double WeekDayRegularRate,double WeekDayRewardRate,double WeekendRegularRate,double WeekendRewardRate) {
		hotelReservation.add(new Hotels(name,WeekDayRegularRate, WeekDayRewardRate, WeekendRegularRate, WeekendRewardRate));
		return true;
	}
	
}
