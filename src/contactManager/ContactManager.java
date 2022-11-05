package contactManager;

import java.util.List;
import java.util.Scanner;

/*
 *  NOTE The two methods "createContact" and "createContactInput" are essentially the same thing. 
 *  		Should I just merge these two methods into one for readability? 
 */

public class ContactManager {

	Contact createContact(String firstName, String lastName, String emailAddress, String phoneNumber) {
		return new Contact(firstName, lastName, emailAddress, phoneNumber);
	}

	Contact createContactInput(Scanner input) {
		input.nextLine();
		System.out.println("First Name: ");
		String firstName = input.nextLine();
		System.out.println("Last Name: ");
		String lastName = input.nextLine();
		System.out.println("Email Address: ");
		String emailAddress = input.nextLine();
		System.out.println("Phone Number: ");
		String phoneNumber = input.nextLine();
		return createContact(firstName, lastName, emailAddress, phoneNumber);
	}

	void addContact(Contact contact, List<Contact> contactList) {
		contactList.add(contact);
	}

	// TODO Create method
	Contact searchContact(String firstName) {
		return null;

	}

	void listContacts(List<Contact> contactList) {
		System.out.println("Listing contacts: ");

		for (Contact contact : contactList) {
			System.out.println("---".repeat(5));
			contact.printInfo();
		}
		
		System.out.println("Total contacts: " + contactList.size());
	}

}
