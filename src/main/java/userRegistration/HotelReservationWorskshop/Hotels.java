package userRegistration.HotelReservationWorskshop;

//
public class Hotels {
	public String name;
	public Double WeekDayRegularRate;
	public Double WeekDayRewardRate;
	public Double WeekendRegularRate;
	public Double WeekendRewardRate;
	public Hotels(String name,double WeekDayRegularRate,double WeekDayRewardRate,double WeekendRegularRate,double WeekendRewardRate) {
		this.name= name;
		this.WeekDayRegularRate = WeekDayRegularRate;
		this.WeekDayRewardRate = WeekDayRewardRate;
		this.WeekendRegularRate = WeekendRegularRate;
		this.WeekendRewardRate = WeekendRewardRate;
	}
	
	
}
