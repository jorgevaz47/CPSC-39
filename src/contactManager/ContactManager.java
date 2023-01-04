package contactManager;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
	
	private HashMap<String, Contact> nameContactHashMap = new HashMap<String, Contact>();

	// Option 2
	void addContact(Contact contact, List<Contact> contactList) {
		contactList.add(contact);
	}

	Contact createContact(Scanner input) {
		input.nextLine();
		
		System.out.println("First Name: ");
		String firstName = input.nextLine();
		System.out.println("Last Name: ");
		String lastName = input.nextLine();
		System.out.println("Email Address: ");
		String emailAddress = input.nextLine();
		System.out.println("Phone Number: ");
		String phoneNumber = input.nextLine();
		
		if(firstName.isBlank() || lastName.isBlank() || phoneNumber.isBlank()) {
			System.out.println("Contact must contain a first name, last name, and phone number. Press any button to try again.");
			return createContact(input);
		}

		Contact tempContact = new Contact(firstName, lastName, emailAddress, phoneNumber);

		addToHashMap(firstName, lastName, tempContact);

		System.out.println("Contact successfully created...");

		return tempContact;
	}
	
	// Option 1
	void listContacts(List<Contact> contactList) {
		
		if(contactList.size() <= 0) {
			System.out.println("No contacts to list. Returning...");
			return;
		}
		
		System.out.println("Listing contacts: ");

		for (Contact contact : contactList) {
			System.out.println("---".repeat(5));
			contact.printInfo();
		}
		
		System.out.println("Total contacts: " + contactList.size());
	}

	// Option 3
	void editExistingContact(Scanner input) {
		
		input.nextLine();
		
		System.out.println("First Name: ");
		String firstName = input.nextLine();
		System.out.println("Last Name: ");
		String lastName = input.nextLine();
		
		Contact contactToEdit = searchContact(firstName, lastName);
		
		if(contactToEdit == null) {
			System.out.println("Contact with name " + firstName + " " + lastName + " was not found. Returning to main menu.");
			return;
		}

		String oldFN = contactToEdit.getFirstName();
		String oldLN = contactToEdit.getLastName();
		
		System.out.println("Editing: ");
		contactToEdit.printInfo();
		System.out.println("Leave blank if you wish to not edit that field.");
		
		System.out.println("New First Name: ");
		String newFirstName = input.nextLine();
		System.out.println("New Last Name: ");
		String newLastName = input.nextLine();
		System.out.println("New Email Address: ");
		String newEmailAddress = input.nextLine();
		System.out.println("New Phone Number: ");
		String newPhoneNumber = input.nextLine();
		
		if(!newFirstName.isBlank()) {
			contactToEdit.setFirstName(newFirstName);
		}
		if(!newLastName.isBlank()) {
			contactToEdit.setLastName(newLastName);
		}
		if(!newEmailAddress.isBlank()) {
			contactToEdit.setEmailAddress(newEmailAddress);
		}
		if(!newPhoneNumber.isBlank()) {
			contactToEdit.setPhoneNumber(newPhoneNumber);
		}
		
		updateHashMap(oldFN, oldLN, contactToEdit.getFirstName(), contactToEdit.getLastName());
		
		
	}
	
	// Option 4
	void deleteContact(Scanner input, List<Contact> contactList) {
		input.nextLine();
		
		System.out.println("First Name: ");
		String firstName = input.nextLine();
		System.out.println("Last Name: ");
		String lastName = input.nextLine();
		
		Contact contactToDelete = searchContact(firstName, lastName);
		
		if(contactToDelete == null) {
			System.out.println("Contact with name " + firstName + " " + lastName + " was not found. Returning to main menu.");
			return;
		}
		
		System.out.println("Are you sure you wish to delete this contact (y/n)? ");
		String token = input.nextLine();
		
		if(token.equals("y")) {
			contactList.remove(contactList.indexOf(contactToDelete));
			nameContactHashMap.remove(contactToDelete.getFirstName() + " " + contactToDelete.getLastName());
		}
	}
	
	// Method that Option 3 and Option 4 use
	Contact searchContact(String firstName, String lastName) {
		
		Contact tempContact = nameContactHashMap.get(firstName + " " + lastName);
		
		if(tempContact == null) {
			System.out.println("No contact associated with that name.");
			return null;
		}
		
		return tempContact;

	}

	
	void addToHashMap(String firstName, String lastName, Contact contact) {
		nameContactHashMap.put(firstName + " " + lastName, contact);
	}
	
	void updateHashMap(String oldFN, String oldLN, String newFN, String newLN) {
		Contact contact = nameContactHashMap.remove(oldFN + " " + oldLN);
		nameContactHashMap.put(newFN + " " + newLN, contact);
	}
	
	void printHashMap() {
		System.out.println(nameContactHashMap);
	}
}
