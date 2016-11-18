package edu.gsu.cis3270.project;

public class User {
	
	private String username;
	private String password;
	private char securityQuestion;
	private String securityQuestionAnswer;
	
	/*
	* 
	* Methods for:
	* Searching flight database for flights
	* using various criteria
	* 
	* Book a flight and add it to the account,
	* same flight cannot be booked multiple times
	*
	* Delete a flight from the account
	*
	* Warn about conflicting flights when booking
	* and restrict purchase
	*
	* Keep track of the number seats booked and 
	* restrinct booking after the flight is full
	* */

	public void login(String username, String password) {
		//Log the user in and send to next screen
	}
	public void logout() {
		//Log the user out and send to the main screen
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public char getSecurityQuestion() {
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

	public void setSecurityQuestion(char securityQuestion) {
		this.securityQuestion = securityQuestion;
	}

	public void setSecurityQuestionAnswer(String securityQuestionAnswer) {
		this.securityQuestionAnswer = securityQuestionAnswer;
	}
	
	
}

class Admin extends User {

	public void update() {

	}

	public void delete() {

	}
}

class Customer extends User {
	
	public void add() {
		
	}
	
	public void delete() {
		
	}
}
