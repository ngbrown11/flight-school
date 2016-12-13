package edu.gsu.cis3270.project.database;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
import java.time.LocalDate;

public class FlightDatabase {
	
	//List flights = new ArrayList<Flight>();
	
	/* 
	 * 
	 * SQL strings for prepared statements
	 * 
	 * */
	static String selectsql = "SELECT CITY_FROM, CITY_TO, "
	+ "FLIGHT_DATE, EXACT_TIME, APPROX_TIME, SEATS_AVAILABLE "
	+ "FROM FLIGHTS "
	+ "WHERE CITY_FROM = ? AND CITY_TO = ? AND FLIGHT_DATE = ?"
	+ "ORDER BY EXACT_TIME DESC;";
	
	static String insertsql = "INSERT INTO FLIGHTS "
	+"(CITY_FROM, CITY_TO, FLIGHT_DATE, EXACT_TIME, APPROX_TIME, "
	+"SEATS_AVAILABLE)"
	+"VALUES (?, ?, ?, ?, ?, ?);";
	
	static String updatesql = "UPDATE FLIGHTS "
	+ "SET CITY_FROM=?, CITY_TO=?, FLIGHT_DATE=?, EXACT_TIME=?, APPROX_TIME=?, "
	+ "SEATS_AVAILABLE=? WHERE FID = ?";
	
	static String deletesql = "DELETE FROM FLIGHTS WHERE FID = ?";	
	
	// Variables for database connection
	private static final String DB_URL = "jdbc:mysql://localhost:3306/flightschooldb?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "George18";
	static Connection conn = null;
	static PreparedStatement select = null;
	static PreparedStatement insert = null;
	static PreparedStatement update = null;
	static PreparedStatement delete = null;
	
	static {
		// Define each prepared statement
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			select = conn.prepareStatement(selectsql);
			insert = conn.prepareStatement(insertsql);
			update = conn.prepareStatement(updatesql);
			delete = conn.prepareStatement(deletesql);
			
		} catch (SQLException e) {
				e.getMessage();
		}
	}
	
	// Display flight info using select statement
	public static ResultSet searchFlight(String cityFrom, String cityTo, Date date) throws SQLException {
		
		select.setString(1, cityFrom);
		select.setString(2, cityTo);
		select.setDate(3, date);
		ResultSet results = select.executeQuery();
		return results;
	}
	// Create a new flight using insert statement
	public static void createFlight(String cityFrom, String cityTo, Date date, 
			String exactTime, String timeOfDay, int seatsAvailable) throws SQLException {
		
		insert.setString(1, cityFrom);
		insert.setString(2, cityTo);
		insert.setDate(3, date);
		insert.setString(4, exactTime);
		insert.setString(5, timeOfDay);
		insert.setInt(6, seatsAvailable);
		insert.execute();
	}
	
	// Update a flight using the update statement
	public static void updateFlight(String cityFrom, String cityTo, Date date, 
			String exactTime, String timeOfDay, int seatsAvailable, int FID) throws SQLException {
		
		update.setString(1, cityFrom);
		update.setString(2, cityTo);
		update.setDate(3, date);
		update.setString(4, exactTime);
		update.setString(5, timeOfDay);
		update.setInt(6, seatsAvailable);
		update.setInt(7, FID);
		update.execute();
	}
	
	// Delete a flight using the delete statement
	public static int deleteFlight(int...FID) throws SQLException {
		
		// Search through the array to delete each flight passed
		int counter = 1;
		for(int id : FID) {
			delete.setInt(counter, id);
			delete.executeUpdate();
			counter++;
		}
		return counter; //Amount of rows affected
	}
}
