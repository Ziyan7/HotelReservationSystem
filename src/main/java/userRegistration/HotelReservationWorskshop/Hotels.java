package userRegistration.HotelReservationWorskshop;

//Class containing name and different payment
public class Hotels {
	private String name;
	private Integer WeekDayRegularRate;
	private Integer WeekEndRegularRate;
	private Integer Ratings;
	public Hotels(String name,Integer WeekDayRegularRate, Integer WeekEndRegularRate, Integer Ratings) {
		this.name= name;
		this.WeekDayRegularRate = WeekDayRegularRate;
		this.WeekEndRegularRate = WeekEndRegularRate;
		this.Ratings = Ratings;
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
	public Integer getRatings() {
		return Ratings;
	}
	public void setRatings(Integer ratings) {
		Ratings = ratings;
	}
	
	

	
	
}
