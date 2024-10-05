package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	
	private Integer roomNUmber;
	private Date checkin;
	private Date checkOut;
	
	private static SimpleDateFormat dt  = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer roomNUmber, Date checkin, Date checkOut) {
		this.roomNUmber = roomNUmber;
		this.checkin = checkin;
		this.checkOut = checkOut;
	}

	public Integer getRoomNUmber() {
		return roomNUmber;
	}

	public void setRoomNUmber(Integer roomNUmber) {
		this.roomNUmber = roomNUmber;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long  durantion() {
		long diff = checkOut.getTime() - checkin.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		} 
		if(!checkOut.after(checkIn)) {
			return "Error in reservation: check-out date must be after check-in date";
		}
		
		this.checkin = checkIn;
		this.checkOut = checkOut;
		return null; //ser retornar tudo certo deve retornar nulo.
	}
	
	@Override
	public String toString() {
		return "Room"
				+ roomNUmber
				+ ", check-in: "
				+ dt.format(checkin)
				+ ", check-out: "
				+ dt.format(checkOut)
				+ ", "
				+ durantion()
				+ " nights";
	}

}
