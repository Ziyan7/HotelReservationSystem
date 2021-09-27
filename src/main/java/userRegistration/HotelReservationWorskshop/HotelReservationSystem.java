package userRegistration.HotelReservationWorskshop;

import java.util.*;
import java.util.Map.Entry;
import java.util.regex.Pattern;
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
	List<Hotels> hotelReservation = new ArrayList<>(); // list for adding different hotels
	Map<String, Integer> map = new HashMap<>();// map for hotel and total rates
	Map<String, Integer> rateMap = new HashMap<>(); // map for hotel and its ratings

	// defining weekends as constants using enum
	public enum weekEnds {
		SATURDAY, SUNDAY;
	}

	// method to add hotel
	public Boolean listHotel(String name, Integer WeekDayRegularRate, Integer WeekEndRegularRate,
			Integer WeekDayRewardRate, Integer WeekEndRewardRate, Integer Ratings) {
		hotelReservation.add(new Hotels(name, WeekDayRegularRate, WeekEndRegularRate, WeekDayRewardRate,
				WeekEndRewardRate, Ratings));
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
	//method to validate the customer type
	public boolean validateCustomerType(String custType)throws HotelReservationException
	{
		String pattern = "^(Regular||Reward)$";
		boolean result = Pattern.matches(pattern, custType);
		if(result == true) {
			return true;
		}else {
			throw new HotelReservationException(HotelReservationException.ExceptionType.WRONG_CUSTOMER, "Please enter a valid customer Type");
		}
	}

	public String cheapHotelForRegularCustomer(String customerType,String rangeStart, String rangeEnd) throws HotelReservationException {
		int numOfDays = 0;
		int min = Integer.MAX_VALUE;
		String cheapestHotel1 = null;
		String cheapestHotel2 = null;
		Integer cheapHotelRate1 = 0;
		Integer cheapHotelRate2 = 0;
		LocalDate startDate = null;
		LocalDate endDate = null;
		
		validateCustomerType(customerType); //call function to validate customer type
		// inbuilt function for converting into dates with given pattern
		DateTimeFormatter format = DateTimeFormatter.ofPattern("ddMMMyyyy");
		
		try {
			startDate = LocalDate.parse(rangeStart, format);
			endDate = LocalDate.parse(rangeEnd, format);
			numOfDays = Period.between(startDate, endDate).getDays()+1; // inbuilt function to count number of range
			if(numOfDays == 0) {
				throw new HotelReservationException(HotelReservationException.ExceptionType.WRONG_DATE, "Please enter proper date range");
			}
		}catch(Exception e) {
			throw new HotelReservationException(HotelReservationException.ExceptionType.WRONG_DATE, "Please enter proper date range");
		}
		
		

		List<LocalDate> listOfDates = Stream.iterate(startDate, date -> date.plusDays(1)) // to obtain dates between
																							// starDate and endDate
				.limit(numOfDays).collect(Collectors.toList());

		for (Hotels perHotel : hotelReservation) {
			int totalRate = 0; // variable for total rates of hotel for given range of dates
			/*
			 * for loop to add total cost based on range checks if day belongs to working
			 * day or weekend
			 */
			for(LocalDate date : listOfDates)
			{
				if(checkDay(date.getDayOfWeek())) 
				{
					if(customerType.equals("Regular")) 
						totalRate += perHotel.getWeekEndRegularRate();
					else
						totalRate += perHotel.getWeekEndRewardRate();
				}
				else
				{
					if(customerType.equals("Regular"))
						totalRate += perHotel.getWeekDayRegularRate();
					else
						totalRate += perHotel.getWeekDayRewardRate();
				}
			}
			map.put(perHotel.getName(), totalRate);
			rateMap.put(perHotel.getName(), perHotel.getRatings());
			System.out.println(perHotel.getName() + perHotel.getRatings());
			System.out.println(perHotel.getName() + totalRate);
		}

		// loop to check for cheap hotel
		for (Map.Entry permap : map.entrySet()) {
			if (min > (int) permap.getValue()) {
				min = (int) permap.getValue();
				cheapestHotel1 = (String) permap.getKey() + " " + "with Totalrate = " + (Integer) permap.getValue();
				
				// loop to check for the best rate
				for (Map.Entry ratemap : rateMap.entrySet()) {
					if (ratemap.getKey().equals(cheapestHotel1)) {
						cheapHotelRate1 = (Integer) ratemap.getValue();
					}
				}
			} else if (min == (int) permap.getValue()) {   //to check if total rates are same for 2 companies
				cheapestHotel2 = (String) permap.getKey() + " with Totalrate = " + (Integer) permap.getValue();
				for (Map.Entry ratemap : rateMap.entrySet()) {
					if (ratemap.getKey().equals(cheapestHotel2)) {
						cheapHotelRate2 = (Integer) ratemap.getValue();
					}
				}
			}
			if (cheapHotelRate1 < cheapHotelRate2) //return hotel with best ratings
				return cheapestHotel2;
		}

		return cheapestHotel1;

	}

	// method to check best rated hotel
	public String BestRatedHotelForRegularCustomer() {
		String bestHotelRate = null;
		String hotelName = null;
		Integer totalRate = null;
		//to obtain hotels name with max total rate
		Entry<String, Integer> maxRatename = Collections.max(rateMap.entrySet(), Comparator.comparing(Entry::getValue));
		hotelName = maxRatename.getKey();
		//to obtain its hotels maximum ratings
		Entry<String, Integer> maxRate = Collections.max(map.entrySet(), Comparator.comparing(Entry::getValue));
		totalRate = maxRate.getValue();
		return bestHotelRate = hotelName + " with Totalrate = " + totalRate;

	}

}