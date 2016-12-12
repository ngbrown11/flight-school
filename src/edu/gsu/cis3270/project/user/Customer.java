package edu.gsu.cis3270.project.user;

public class Customer extends User {
	
	public Customer(String firstName, String lastName, String address, int zip,
					String state, String email, int socialSecurity) {
		
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setAddress(address);
		this.setZipCode(zip);
		this.setState(state);
		this.setEmail(email);
		this.setSocialSecurity(socialSecurity);
	}
	
	public void add() {
		
	}
	
	public void delete() {
		
	}

	@Override
	protected void login(String username, String password) {
		//Log the user in and send to next screen
		
	}

	@Override
	protected void logout() {
		//Log the user out and send to the main screen
		
	}
}
