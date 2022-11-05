package contactManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {

	static int errorCounter = 0;

	public static void main(String[] args) {

		ContactManager contactManager = new ContactManager();
		List<Contact> contactList = new ArrayList<>();
		Scanner input = new Scanner(System.in);

		mainMenu(input, contactManager, contactList);

		input.close();

	}

	public static void mainMenu(Scanner input, ContactManager contactManager, List<Contact> contactList) {

		System.out.println("------Main Menu------");
		System.out.println("Please input a number corresponding with the action you would like to take.");
		System.out.println(
				"1) List contacts\t\t2) Create new contact\n3) Edit existing contact\t4) Delete contact\n0) Quit application");

		int token = -1;

		try {
			token = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error: ");
			errorCounter++;
			if (errorCounter >= 10) {
				System.out.println("Too many failed attempts. Closing application.");
				return;
			}
		}

		switch (token) {
		case 0:
			System.out.println("Quitting application...");
			break;
		case 1:
			contactManager.listContacts(contactList);
			mainMenu(new Scanner(System.in), contactManager, contactList);
			break;
		case 2:
			System.out.println("Creating new contact...");
			contactManager.addContact(contactManager.createContactInput(input), contactList);
			System.out.println("Contact successfully created.");
			mainMenu(new Scanner(System.in), contactManager, contactList);
			break;
		case 3:
			System.out.println("Editing existing contact...");
			break;
		case 4:
			System.out.println("Deleting contact...");
			break;
		default:
			System.out.println("Please enter a valid number. Returning to Main Menu.");
			mainMenu(new Scanner(System.in), contactManager, contactList);
		}
	}

}
