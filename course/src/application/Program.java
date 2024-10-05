package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
	
	Scanner sc = new Scanner(System.in);
	SimpleDateFormat dt = new SimpleDateFormat("dd/MM/yyyy");
	
	System.out.println("Room number: ");
	int number = sc.nextInt();
	System.out.println("Check-in date (dd/MM/yyyy)");
	Date checkIn = dt.parse(sc.next());
	System.out.println("Check-out date (dd/MM/yyyy)");
	Date checkout = dt.parse(sc.next());
	
	
	if(!checkout.after(checkIn)) {
		System.out.println("Error in reservation: check-out date must be after check-in date");
	} else {
		Reservation reservation = new Reservation(number, checkIn, checkout);
		System.out.println("Reservation " + reservation);
		
		
		System.out.println();
		System.out.println("Enter data to update the reservation");
		System.out.println("Check-in date (dd/MM/yyyy)");
		checkIn = dt.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy)");
		checkout = dt.parse(sc.next());
		
		Date now = new Date();
		if(checkIn.before(now) || checkout.before(now)) {
			System.out.println("Error in reservation: Reservation dates for update must be future dates");
		} else if(!checkout.after(checkIn)) {
			System.out.println("Error in reservation: check-out date must be after check-in date");
		} else {
			reservation.updateDates(checkIn, checkout);
			System.out.println("Reservation " + reservation);
		}
		
		
	}
	
	sc.close();
	
	
	}

}
