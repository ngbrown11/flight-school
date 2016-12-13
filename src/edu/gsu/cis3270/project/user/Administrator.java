package edu.gsu.cis3270.project.user;

import java.sql.Date;

public interface Administrator {

  boolean addFlight(String cityFrom, String cityTo, Date date, 
			String exactTime, String timeOfDay, int seatsAvailable);

  boolean updateFlight(String cityFrom, String cityTo, Date date, 
			String exactTime, String timeOfDay, int seatsAvailable, int FID);
  
  boolean deleteFlight(int...flightID);
}
