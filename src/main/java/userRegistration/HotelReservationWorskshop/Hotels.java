package userRegistration.HotelReservationWorskshop;

//Class containing name and different payment
public class Hotels {
	private String name;
	private Integer WeekDayRegularRate;
	private Integer WeekEndRegularRate;
	private Integer WeekDayRewardRate;
	private Integer WeekEndRewardRate;
	private Integer Ratings;
	public Hotels(String name,Integer WeekDayRegularRate, Integer WeekEndRegularRate, Integer WeekDayRewardRate,Integer WeekEndRewardRate, Integer Ratings) {
		this.name= name;
		this.WeekDayRegularRate = WeekDayRegularRate;
		this.WeekEndRegularRate = WeekEndRegularRate;
		this.WeekDayRewardRate = WeekDayRewardRate;
		this.WeekEndRewardRate = WeekEndRewardRate;
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
	public Integer getWeekDayRewardRate() {
		return WeekDayRewardRate;
	}
	public void setWeekDayRewardRate(Integer weekDayRewardRate) {
		WeekDayRewardRate = weekDayRewardRate;
	}
	public Integer getWeekEndRewardRate() {
		return WeekEndRewardRate;
	}
	public void setWeekEndRewardRate(Integer weekEndRewardRate) {
		WeekEndRewardRate = weekEndRewardRate;
	}
	
	

	
	
}
