package userRegistration.HotelReservationWorskshop;

public class HotelReservationException extends Exception {
	public enum ExceptionType {
		WRONG_DATE,
		WRONG_CUSTOMER
	}
	public ExceptionType type;
	public HotelReservationException(ExceptionType type,String message) {
		super(message);
		this.type = type;
	}

}
