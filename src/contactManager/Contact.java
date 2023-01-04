package contactManager;


public class Contact {
	
	private String firstName;
	private String lastName;
	private String emailAddress;
	private String phoneNumber;
	
	public Contact() {
		this.firstName = null;
		this.lastName = null;
		this.emailAddress = null;
		this.phoneNumber = null;
	}
	
	public Contact(String firstName, String lastName, String emailAddress, String phoneNumber) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}
	
	public void printInfo() {
		System.out.println("First Name:\t" + this.firstName);
		System.out.println("Last Name:\t" + this.lastName);
		System.out.println("Email Address:\t" + this.emailAddress);
		System.out.println("Phone Number:\t" + this.phoneNumber);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
