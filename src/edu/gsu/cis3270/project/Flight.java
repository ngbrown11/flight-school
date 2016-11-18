package edu.gsu.cis3270.project;

public class Flight {
	
	int seatsAvailable;
	int seatsBooked;
	boolean full;

	public void setSeatsBooked(int booking) {
		this.seatsBooked = (this.seatsBooked + booking);
	}

	public int getSeatsBooked() {
		return seatsBooked;
	}
	
	public boolean isFull() {
		return false;
	}
}
