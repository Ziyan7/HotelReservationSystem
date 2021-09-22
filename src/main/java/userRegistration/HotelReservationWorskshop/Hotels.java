package userRegistration.HotelReservationWorskshop;

//Class containing name and different payment
public class Hotels {
	private String name;
	private Integer WeekDayRegularRate;
	private Integer WeekendRegularRate;
	public Hotels(String name,Integer WeekDayRegularRate) {
		this.name= name;
		this.WeekDayRegularRate = WeekDayRegularRate;
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
	
	@Override
	public String toString() {
		return name + WeekDayRegularRate;
	}

	
	
}
