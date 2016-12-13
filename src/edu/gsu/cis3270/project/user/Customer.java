package edu.gsu.cis3270.project.user;

public class Customer extends User {
	
	private final String SSN; //Initialize this variable in the constructor
	
	public Customer(String firstName, String lastName, String address, int zip,
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
