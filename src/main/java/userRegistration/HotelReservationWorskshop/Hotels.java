package userRegistration.HotelReservationWorskshop;

//Class containing name and different payment
public class Hotels {
	private String name;
	private Integer WeekDayRegularRate;
	private Integer WeekEndRegularRate;
	public Hotels(String name,Integer WeekDayRegularRate, Integer WeekEndRegularRate) {
		this.name= name;
		this.WeekDayRegularRate = WeekDayRegularRate;
		this.setWeekEndRegularRate(WeekEndRegularRate);
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWeekDayRegularRate() {
		return WeekDayRegularRate;
	}

	public void setWeekDayRegularRate(Integer weekDayRegularRate) {
		WeekDayRegularRate = weekDayRegularRate;
	}
	public Integer getWeekEndRegularRate() {
		return WeekEndRegularRate;
	}
	public void setWeekEndRegularRate(Integer weekEndRegularRate) {
		WeekEndRegularRate = weekEndRegularRate;
	}
	
	

	
	
}
