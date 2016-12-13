package edu.gsu.cis3270.project.database;

import java.sql.*;

public class CreateDatabase {
	
	//Variables to connect to make a connection
	private static final String DB_URL = "jdbc:mysql://localhost:3306/?useSSL=false";
	private static final String USER = "root";
	private static final String PASS = "George18";
	private static final String createDB = "CREATE DATABASE flightschooldb";
	private static final String useDB = "USE flightschooldb";
	/*
	 * 
	 * All of the create statements 
	 * for the tables in the database
	 * 
	 * */
	private static final String createFlights = "CREATE TABLE FLIGHTS"
			+ "(FID INT NOT NULL AUTO_INCREMENT,"
			+ "CITY_FROM CHAR(3) NOT NULL,"
			+ "CITY_TO CHAR(3) NOT NULL,"
			+ "FLIGHT_DATE DATE NOT NULL,"
			+ "EXACT_TIME VARCHAR(8) NOT NULL,"
			+ "APPROX_TIME CHAR(1) NOT NULL,"
			+ "SEATS_AVAILABLE INT NOT NULL,"
			+ "SEATS_BOOKED INT NOT NULL,"
			+ "PRIMARY KEY (FID));";
	private static final String createUsers = "CREATE TABLE USERS"
			+ "(UID INT NOT NULL AUTO_INCREMENT,"
			+ "USER_LNAME VARCHAR(20) NOT NULL,"
			+ "USER_FNAME VARCHAR(20) NOT NULL,"
			+ "USER_ADDRESS VARCHAR(50) NOT NULL,"
			+ "USER_ZIP INT NOT NULL,"
			+ "USER_STATE CHAR(2) NOT NULL,"
			+ "USER_EMAIL VARCHAR(50) NOT NULL,"
			+ "USER_SSN VARCHAR(11) NOT NULL,"
			+ "USER_USERNAME VARCHAR(20) NOT NULL,"
			+ "USER_PASSWORD VARCHAR(20) NOT NULL,"
			+ "USER_SECURITY_QUESTION INT NOT NULL,"
			+ "USER_SECURITY_ANSWER VARCHAR(50) NOT NULL,"
			+ "USER_TYPE CHAR(1) NOT NULL,"
			+ "CHECK (USER_TYPE='A' OR USER_TYPE='C'),"
			+ "CONSTRAINT USERS_UNIQUE UNIQUE (USER_SSN, USER_USERNAME, USER_PASSWORD),"
			+ "PRIMARY KEY (UID));";
	private static final String createReservation = "CREATE TABLE RESERVATION"
			+ "(RID INT NOT NULL AUTO_INCREMENT,"
			+ "UID INT NOT NULL,"
			+ "FID INT NOT NULL,"
			+ "RSVP_DATE DATE NOT NULL,"
			+ "RSVP_TIME VARCHAR(10) NOT NULL,"
			+ "PRIMARY KEY (RID),"
			+ "FOREIGN KEY (UID) REFERENCES USERS (UID),"
			+ "FOREIGN KEY (FID) REFERENCES FLIGHTS (FID));";
	private static final String createUserFlights = "CREATE TABLE USER_FLIGHTS"
			+ "(UID INT NOT NULL,"
			+ "FID INT NOT NULL,"
			+ "CITY_FROM CHAR(3) NOT NULL,"
			+ "CITY_TO CHAR(3) NOT NULL,"
			+ "FLIGHT_DATE DATE NOT NULL,"
			+ "EXACT_TIME VARCHAR(8) NOT NULL,"
			+ "CONSTRAINT USER_FLIGHTS_PK PRIMARY KEY (UID, FID));";
	
	private static final String createTables = createFlights + createUsers + createReservation + createUserFlights;
	private static Connection conn = null;
	public static Statement stmt = null;
	public static String sql = null;
	
	public static void main(String[] args) {
		
		try {
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
			stmt = conn.createStatement();	
			//Create the database
			sql = createDB;
			stmt.execute(sql);	
			//Select the database
			sql = useDB;			
			stmt.execute(sql);
			//Create the tables
			sql = createTables;			
			stmt.execute(sql);
			
		} catch(SQLException ex1) {	//If the database already exists, just connect to it
			
			try {
				
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/flightschooldb?useSSL=false", USER, PASS);
				
				//Select the database
				sql = useDB;			
				stmt.execute(sql);
				//Create the tables
				sql = createTables;			
				stmt.execute(sql);
				
			} catch(Exception ex) {	//If the tables already exist
				
				ex.printStackTrace();
			}
		} catch(Exception ex2) {
			
			ex2.printStackTrace();
		}
		
	}

}
