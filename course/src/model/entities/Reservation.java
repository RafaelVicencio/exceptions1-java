package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNUmber;
	private Date checkin;
	private Date checkOut;
	
	private static SimpleDateFormat dt  = new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}

	public Reservation(Integer roomNUmber, Date checkin, Date checkOut) {
		if(!checkOut.after(checkin)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		
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
	
	public void updateDates(Date checkIn, Date checkOut) {
		Date now = new Date();
		if(checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException( "Reservation dates for update must be future dates");
		} 
		if(!checkOut.after(checkIn)) {
			throw new DomainException("Error in reservation: check-out date must be after check-in date");
		}
		this.checkin = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override
	public String toString() {
		return "Room "
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
