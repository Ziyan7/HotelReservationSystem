package userRegistration.HotelReservationWorskshop;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.stream.*;
import java.time.DayOfWeek;

/*
 * Class containing list of hotels
 * @param name is for hotel name
 * @param weekDayRegularRate is price for regular customer on weekdays
 * @param WeekendRegularRate is price for regular customer on weekends
 */
public class HotelReservationSystem {
	List<Hotels> hotelReservation = new ArrayList<>();
	Map<String, Integer> map = new HashMap<>();
	Map<String, Integer> Ratemap = new HashMap<>();
	Map<String, Integer> bestRateMap = new HashMap<>();
	

	// defining weekends as constants using enum
	public enum weekEnds {
		SATURDAY, SUNDAY;
	}

	// method to add hotel
	public Boolean listHotel(String name, Integer WeekDayRegularRate, Integer WeekEndRegularRate , Integer Ratings) {
		hotelReservation.add(new Hotels(name, WeekDayRegularRate, WeekEndRegularRate, Ratings));
		return true;
	}

	// method to check if the day is Saturday or Sunday
	public boolean checkDay(DayOfWeek day) {
		switch (day) {
		case SATURDAY:
			return true;
		case SUNDAY:
			return true;
		default:
			return false;
		}
	}

	public String cheapHotelForRegularCustomer(String rangeStart, String rangeEnd) {
		// inbuilt function for converting into dates with given pattern
		DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMMyyyy");
		LocalDate startDate = LocalDate.parse(rangeStart, format);
		LocalDate endDate = LocalDate.parse(rangeEnd, format);
		int numOfDays = Period.between(startDate, endDate).getDays()+1; // inbuilt function to count number of range
		int min = Integer.MAX_VALUE;
		String cheapestHotel1 = null;
		String cheapestHotel2 = null;
		String cheapestHotel = null;
		Integer cheapHotelRate1 = 0;
		Integer cheapHotelRate2 = 0;

		List<LocalDate> listOfDates = Stream.iterate(startDate, date -> date.plusDays(1)) // to obtain dates between starDate and endDate
										.limit(numOfDays).collect(Collectors.toList());

		for (Hotels perHotel : hotelReservation) {
			int totalRate = 0; // variable for total rates of hotel for given range of dates
			for (LocalDate date : listOfDates) {
				if (checkDay(date.getDayOfWeek())) {
					totalRate += perHotel.getWeekEndRegularRate();
				} else {
					totalRate += perHotel.getWeekDayRegularRate();
				}
			}
			map.put(perHotel.getName(), totalRate);
			Ratemap.put(perHotel.getName(), perHotel.getRatings());
			System.out.println(perHotel.getName() + perHotel.getRatings());
			System.out.println(perHotel.getName() + totalRate);
		}
		for (Map.Entry permap : map.entrySet()) {      
			if(min > (int)permap.getValue()) 
			{
				min = (int)permap.getValue();
				cheapestHotel1 = (String)permap.getKey();
				for(Map.Entry ratemap : Ratemap.entrySet()) {
					if(ratemap.getKey().equals(cheapestHotel1)) {
						cheapHotelRate1 = (Integer) ratemap.getValue();
					}
				}
			}
			else if(min == (int)permap.getValue()){
				cheapestHotel2= (String)permap.getKey();
				for(Map.Entry ratemap : Ratemap.entrySet()) {
					if(ratemap.getKey().equals(cheapestHotel2)) {
						cheapHotelRate2 = (Integer) ratemap.getValue();
					}
				}
			}
			if(cheapHotelRate1<cheapHotelRate2)
				return cheapestHotel2;
		}

		return cheapestHotel1;

	}

}