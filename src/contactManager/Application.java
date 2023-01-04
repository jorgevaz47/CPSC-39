package contactManager;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Application {

	// Variable to count the amount of user errors
	static int errorCounter;

	public static void main(String[] args) {

		// Creating the contactManager object, contactList array list and the scanner
		// for input
		ContactManager contactManager = new ContactManager();
		List<Contact> contactList = new ArrayList<>();
		Scanner input = new Scanner(System.in);

		// Going to the main menu method which controls most of the program
		mainMenu(input, contactManager, contactList);

		// Closing the scanner before application is terminated
		input.close();

	}

	public static void mainMenu(Scanner input, ContactManager contactManager, List<Contact> contactList) {

		// Setting error counter to 0. Works as a reset every time the mainMenu is
		// called
		errorCounter = 0;

		// Printing main menu information to the user
		System.out.println("------Main Menu------");
		System.out.println("Please input a number corresponding with the action you would like to take.");
		System.out.println(
				"1) List contacts\t\t2) Create new contact\n3) Edit existing contact\t4) Delete contact\n5) More options (WIP)\t\t0) Quit application");
		System.out.println("---------------------");

		// Creating token variable which holds the value that hte user inptus
		int token = -1;

		// Prompting user for input and then checking that input to see if it is a valid
		// Int and if not prompt user to enter again
		System.out.print("Input: ");

		try {
			token = input.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error: ");
			errorCounter++;
			/*
			 * I initially had this to prevent a stack overflow with my mainMenu method, but
			 * I can't seem to recreate the issue again. I left this if-termination
			 * statement
			 * though as I felt it is a good part of the applicaiton.
			 */
			if (errorCounter >= 10) {
				System.out.println("Too many failed attempts. Closing application.");
				return;
			}
		}

		System.out.println("---------------------");

		// Using a switch statement to determine what is the next path of the application given the user's input
		/*
		 * Case 0 is to quit the application
		 * Case 1 is to list the contact in the contactList 
		 * Case 2 is to create a new contact
		 * Case 3 is to edit an existing contact
		 * Case 4 is to delete an existing contact
		 * Case 5 is meant to hold more options for the user such as checking for duplicates and deleting duplicates, sorting the arrayList, etc.
		 * Tne default case prompts the user to input a valid value (0-5) 
		 */
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
				contactManager.addContact(contactManager.createContact(input), contactList);
				mainMenu(new Scanner(System.in), contactManager, contactList);
				break;
			case 3:
				System.out.println("Please enter the first and last name of the contact you wish to edit: ");
				contactManager.editExistingContact(input);
				mainMenu(new Scanner(System.in), contactManager, contactList);
				break;
			case 4:
				System.out.println("Deleting contact...");
				contactManager.deleteContact(input, contactList);
				mainMenu(new Scanner(System.in), contactManager, contactList);
				break;
			case 5:
				System.out.println("More options is currently in development. Returning to main menu.");
				mainMenu(new Scanner(System.in), contactManager, contactList);
				break;
			default:
				System.out.println("Please enter a valid number. Returning to Main Menu.");
				mainMenu(new Scanner(System.in), contactManager, contactList);
				break;
		}
	}

}
