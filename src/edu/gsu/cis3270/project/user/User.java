package edu.gsu.cis3270.project.user;

import edu.gsu.cis3270.project.database.FlightDatabase;

public abstract class User {

	private String firstName;
	private String lastName;
	private String address;
	private int zipCode;
	private String state;
	private String email;
	private String username;
	private String password;
	private int securityQuestion;
	private String securityQuestionAnswer;

	/*
	*
	* Methods for:
	* Book a flight and add it to the account,
	* same flight cannot be booked multiple times
	*
	* Delete a flight from the account
	*
	* Warn about conflicting flights when booking
	* and restrict purchase
	*
	* Keep track of the number seats booked and
	* restrict booking after the flight is full
	* */
	
	
	//Create a new user and add to the database
	/*static boolean registerUser(String firstName, String lastName, String address,
	String state, int zipCode, String SSN, String email, String username, String password,
	int securityQuestion, String securityQuestionAnswer) {
		//Add code here
		return true;
	}*/

	//Log the user in and send to next screen
	protected abstract void login(String username, String password);
	//Log the user out and send to the main screen
	protected abstract void logout();

	boolean bookFlight() {
		//Add a flight to user account
		return true;
	}

	boolean cancelFlight() {
		//Delete a flight from user account
		return true;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public int getSecurityQuestion() {
		return securityQuestion;
	}

	public String getSecurityQuestionAnswer() {
		return securityQuestionAnswer;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSecurityQuestion(int securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getAddress() {
		return address;
	}
	public int getZipCode() {
		return zipCode;
	}
	public String getState() {
		return state;
	}
	public String getEmail() {
		return email;
	}
	abstract String getSSN();
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public void setState(String state) {
		this.state = state;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
