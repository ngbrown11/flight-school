package edu.gsu.cis3270.project.user;

import java.sql.Date;
import java.sql.SQLException;

import edu.gsu.cis3270.project.database.FlightDatabase;

public class Admin extends User implements Administrator {
	
	private final String SSN; //Initialize this variable in the constructor
	
	public Admin(String firstName, String lastName, String address, int zip,
			String state, String SSN, String email, String username, String password,
			int securityQuestion, String securityQuestionAnswer) {

		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddress(address);
		this.setZipCode(zip);
		this.setState(state);
		this.SSN = SSN;
		this.setEmail(email);
		this.setUsername(username);
		this.setPassword(password);
		this.setSecurityQuestion(securityQuestion);
		this.setSecurityQuestionAnswer(securityQuestionAnswer);
	}

	public boolean addFlight(String cityFrom, String cityTo, Date date, 
			String exactTime, String timeOfDay, int seatsAvailable) {
		
		try {	// Add new flight to database	
			FlightDatabase.createFlight(cityFrom, cityTo, date, exactTime, timeOfDay, seatsAvailable);
			
		} catch(SQLException e1) {
			e1.getMessage();
			return false;
		} catch(Exception e2) {
			e2.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public boolean updateFlight(String cityFrom, String cityTo, Date date, 
			String exactTime, String timeOfDay, int seatsAvailable, int FID) {
		
		try {	// Update a flight in database
			FlightDatabase.updateFlight(cityFrom, cityTo, date, exactTime, timeOfDay, seatsAvailable, FID);
			
		} catch(SQLException e1) {
			e1.getMessage();
			return false;
		} catch(Exception e2) {
			e2.printStackTrace();
			return false;
		}
		return true;
	}

	public boolean deleteFlight(int...flightID) {
		
		try {	// Delete flight(s) from database
			FlightDatabase.deleteFlight(flightID);
			
		} catch(SQLException e1) {
			e1.getMessage();
			return false;
		} catch(Exception e2) {
			e2.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public void login(String username, String password) {
		//Log the user in and send to next screen

	}

	@Override
	public void logout() {
		//Log the user out and send to the main screen

	}

	@Override
	public String getSSN() {
		return SSN;
	}
}
