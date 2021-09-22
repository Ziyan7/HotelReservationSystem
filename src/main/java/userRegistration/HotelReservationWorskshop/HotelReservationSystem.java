package userRegistration.HotelReservationWorskshop;
import java.text.ParseException;

import java.util.*;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

/*
 * Class containing list of hotels
 * @param name is for hotel name
 * @param weekDayRegularRate is price for regular customer on weekdays
 * @param WeekendRegularRate is price for regular customer on weekends
 */
public class HotelReservationSystem {
	List<Hotels> hotelReservation = new ArrayList<>();
	Map<String, Integer> map = new HashMap<>();

	// method to add hotel
	public Boolean listHotel(String name, Integer WeekDayRegularRate) {
		hotelReservation.add(new Hotels(name, WeekDayRegularRate));
		return true;
	}
	public int hotelCount() {
		return hotelReservation.size();
	}

	public String cheapHotelForRegularCustomer(String rangeStart, String rangeEnd) {
		DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMMyyyy"); // inbuilt function for converting into
																				// dates with given pattern
		LocalDate startDate = LocalDate.parse(rangeStart, format);
		LocalDate endDate = LocalDate.parse(rangeEnd, format);
		int numOfDays = Period.between(startDate, endDate).getDays(); // inbuilt function to count number of range

		
		int min = Integer.MAX_VALUE;
		String cheapestHotel = null;
		
		for (Hotels perHotel : hotelReservation) {
			int totalRate = 0;
			for (int i = 0; i < numOfDays; i++) {
				totalRate += perHotel.getWeekDayRegularRate();
			}
			map.put(perHotel.getName(), totalRate);
		}
		for (Map.Entry permap : map.entrySet()) {
			if (min > (int) permap.getValue()) {
				min = (int) permap.getValue();
				cheapestHotel = (String) permap.getKey();
			}
		}
		return cheapestHotel;

	}

}
