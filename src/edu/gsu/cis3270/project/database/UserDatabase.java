package edu.gsu.cis3270.project.database;

import java.util.List;

import edu.gsu.cis3270.project.user.Customer;

import java.util.ArrayList;
import java.sql.*;

public class UserDatabase {
	
	List customers = new ArrayList<Customer>();
	// SQL strings for prepared statements
	static String selectsql = "SELECT UID "
			+ "FROM USERS "
			+ "WHERE USER_USERNAME = ? AND USER_PASSWORD = ?";
	
	static String insertsql = "INSERT INTO USERS "
	+"(USER_LNAME, USER_FNAME, USER_ADDRESS, USER_ZIP, USER_STATE, "
	+"USER_EMAIL, USER_SSN, USER_USERNAME, USER_PASSWORD, "
	+"USER_SECURITY_QUESTION, USER_SECURITY_ANSWER, USER_TYPE)"
	+"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	static String updatesql = null;
	static String deletesql = "DELETE FROM USERS WHERE UID = ?";
	
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
	
	// Search the database to validate the user
	public static boolean searchUser(String username, String password) throws SQLException {
		int ID = 0;
		
		select.setString(1, username);
		select.setString(2, password);
		ResultSet rs = select.executeQuery();
		return rs.first();
	}
	
	// Add a user to the database
	public static void createUser(String firstName, String lastName, String address, 
			int zip, String state, String email, String SSN, String username, 
			String password, int securityQuestion, String securityQuestionAnswer, String userType) throws SQLException {
		
		insert.setString(1, firstName);
		insert.setString(2, lastName);
		insert.setString(3, address);
		insert.setInt(4, zip);
		insert.setString(5, state);
		insert.setString(6, email);
		insert.setString(7, SSN);
		insert.setString(8, username);
		insert.setString(9, password);
		insert.setInt(10, securityQuestion);
		insert.setString(11, securityQuestionAnswer);
		insert.setString(12, "A");
		insert.execute();
	}
	
	// Update user information
	public static void updateUser(String firstName, String lastName, 
			String address, int zip, String state, String email, String username, 
			String password, int securityQuestion, String securityQuestionAnswer) {
		
		
	}
	
	// Delete user from the database
	public static int deleteUser(int UID) {
		
		return 1;
	}
}
