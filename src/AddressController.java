import java.util.Scanner;

/*
 *  Assignment1, COMP268
 *  Class: AddressController.java
 *  
 * AddressController implements the AddressBook class in a variety of ways.
 * There is a fully loaded, uncommented, constructor to give the user a quick example
 * of how the toString() of the class appears. The toString is called implicitly 
 * by our call to print off our instance of the AddressBook class
 * If the user uncomments the empty constructor and the call to promptNewContact()
 * they can enter their own details into an instance of AddressBook.
 * These details are not saved to any files at the moment.
 * 
 * AddressController also demonstrates the AddressBook's static method compareNames()
 * in which the user must provide two complete sets of first, middle, and last names.
 * The method will return a string explaining if each name is the same or different, regardless of case.
 * This method is static because it does not relate to any instances of our AddressBook class, 
 * therefore it does not use either mutator or accessor methods, despite that being an instruction.
 * 
 *
 * @author Dylan Cooper
 * @since 04/11/2018
 */

public class AddressController {

	public static void main(String[] args) {
		
//		Complete class constructor
		AddressBook contact = new AddressBook("Dylan", "Watson", "Cooper", "405 Mackay Street", "613 447 0997", "613 744 7777", "613 447 0997", "www.pareprogramming.io", "SkypeDylan", "dcooper92" );
		
//		Create an empty AddressController object 
//		AddressBook contact = new AddressBook();
		
//		Prompt the user for all of the contact's details
//		contact.promptNewContact();
		
//		Print the AddressBook object
		System.out.println(contact);
		
		
		
		
		//Initiate scanner to accept input for compareNames
		Scanner keyboard = new Scanner(System.in);
		
		String name1 = "",	// to hold the first person's full name
			   name2 = "";  // to hold the second person's full name
		
		System.out.println("Compare Two names\n");
		
		// Prompt for the first person's name
		do {
			System.out.println("Please enter the first person\'s complete name (first middle last) ");
			name1 = keyboard.nextLine();
			
			if ( ((name1.split(" ")).length) != 3) {
				System.out.println("Name must be of format: firstName middleName lastName");
			}
		} while ( ((name1.split(" ")).length) != 3);

		
		// Prompt for the second person's name
		do {
			System.out.println("Please enter the second person\'s complete name (first middle last) ");
			name2 = keyboard.nextLine();
			
			if ( ((name2.split(" ")).length) != 3) {
				System.out.println("Name must be of format: firstName middleName lastName");
			}
		} while ( ((name2.split(" ")).length) != 3);
		
		System.out.println("Comparing " + name1 + " with " + name2 + ": ");
		
		System.out.println( AddressBook.compareNames(name1, name2) );
		
		//Close scanner and System.in
		keyboard.close();
		
		System.exit(0);
		
	}

}
