package edu.gsu.cis3270.project.flight;

import java.sql.Date;

public class Flight {
	
	/*
	 * Variables pertaining to each flight
	 * */
	int flightNumber;
	String cityFrom;
	String cityTo;
	Date date;
	String exactTime;
	String timeOfDay;
	int seatsAvailable;
	int seatsBooked;
	boolean full;
	
	public Flight(String cityFrom, String cityTo, Date date, 
		String exactTime, String timeOfDay, int seatsAvailable) {
		this.cityFrom = cityFrom;
		this.cityTo = cityTo;
		this.date = date;
		this.exactTime = exactTime;
		this.timeOfDay = timeOfDay;
		this.seatsAvailable = seatsAvailable;
	}
	
	public void updateSeatsBooked(int booking) {
		this.seatsBooked = (this.seatsBooked + booking);
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}
	
	public int getSeatsAvailable() {
		return seatsAvailable;
	}
	public boolean isFull() {
		//Check if the flight is fully booked
		if( this.getSeatsAvailable() > 0 )
			return false;
		
		return true;
	}
}
