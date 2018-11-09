import java.util.Scanner;

public class AddressController {

	public static void main(String[] args) {
		
//		Complete class constructor
//		AddressBook contact = new AddressBook("Dylan", "Watson", "Cooper", "405 Mackay Street", "613 447 0997", "613 744 7777", "613 447 0997", "www.pareprogramming.io", "SkypeDylan", "dcooper92" );
		
//		Create an empty AddressController object 
		AddressBook contact = new AddressBook();
		
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
