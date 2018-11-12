import java.util.Scanner;

/**
 *  Assignment 1, COMP268
 *  Class:	AddressBook.java
 *  
 *  The AddressBook class contains the blueprint for
 *  a single contact entry in an address book. 
 *  
 *  Using promptNewContact() we can prompt the user for all of their contact details
 *  static method compareNames() allows us to compare names
 *  promptNewContact() runs input validation before passing off arguments to the constructor
 * 
 * @author Dylan
 * Student Id: 3352271
 * @since 04/11/2018
 * @version 1.0
 * 
 */

public class AddressBook {
	
	private String firstName, 
		   middleName,
		   lastName,
		   homeAddress,
		   businessPhone,
		   homePhone,
		   cellPhone,
		   personalWebsite,
		   skypeId,
		   facebookId;
	
	/**
	 * Empty AddressBook constructor
	 */
	public AddressBook() {
	}
	
	/**
	 *  Create a new instance of the AddressBook class. 
	 *  @param fn = first name of the new contact 
	 */
	public AddressBook(String fn) {
		this.firstName = fn;
	}
	
	/**
	 *  Create a new instance of the AddressBook class. 
	 *  @param fn = first name of the new contact 
	 *  @param mn = middle name
	 */
	public AddressBook(String fn, String mn) {
		this.firstName = fn;
		this.middleName = mn;
		}	
	
	/**
	 *  Create a new instance of the AddressBook class. 
	 *  @param fn = first name of the new contact 
	 *  @param mn = middle name
	 *  @param ln = last name
	 */
	public AddressBook(String fn, String mn, String ln) {
		this.firstName = fn;
		this.middleName = mn;
		this.lastName = ln;
	}	
	
	/**
	 *  Create a new instance of the AddressBook class with a fully loaded constructor.
	 *  @param fn = first name of the new contact 
	 *  @param mn = middle name
	 *  @param ln = last name
	 *  @param homeAddress
	 *  @param businessPhone can be 
	 *  @param homePhone
	 *  @param cellPhone
	 *  @param personalWebsite
	 *  @param skypeId
	 *  @param facebookId
	 */
	public AddressBook(String fn, String mn, String ln, String homeAddress, String businessPhone, String homePhone, String cellPhone, String personalWebsite, String skypeId, String facebookId) {
		this.firstName = fn;
		this.middleName = mn;
		this.lastName = ln;
		this.homeAddress = homeAddress;
		this.businessPhone = businessPhone;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.personalWebsite = personalWebsite;
		this.skypeId = skypeId;
		this.facebookId = facebookId;
	}
	
	
	// Get methods
	public String getFirstName() {
		return this.firstName;
	}
	public String getMiddleName() {
		return this.middleName;
	}
	public String getLastName() {
		return this.lastName;
	}
	public String getHomeAddress() {
		return this.homeAddress;
	}
	public String getBusinessPhone() {
		return this.businessPhone;
	}
	public String getHomePhone() {
		return this.homePhone;
	}
	public String getCellPhone() {
		return this.cellPhone;
	}
	public String getPersonalWebsite() {
		return this.personalWebsite;
	}
	public String getSkypeId() {
		return this.skypeId;
	}
	public String getFacebookId() {
		return this.facebookId;
	}
	
	
	// Set methods
	public void setFirstName(String fname) {
		this.firstName = fname;
	}
	public void setMiddleName(String mname) {
		this.middleName = mname;
	}
	public void setLastName(String lname) {
		this.lastName = lname;
	}
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}
	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public void setPersonalWebsite(String personalWebsite) {
		this.personalWebsite = personalWebsite;
	}
	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}
	public void setFacebookId(String facebookId) {
		this.facebookId = facebookId;
	}
	
	
	/**
	 * compareNames compares two complete names 
	 * It splits each String into its own array. 
	 * Each array is of size 3, which is checked before this method can be called
	 * @param name1 contains firstName + middleName + lastName
	 * @param name2 is of the same format as name1
	 * @return String message explaining the differences between names
	 * 
	 */
	public static String compareNames(String name1, String name2) {
			
		String[] name1Array = name1.split(" ");
		String[] name2Array = name2.split(" ");
		String message; 	// to hold the returned String
		if ( name1Array[0].equalsIgnoreCase(name2Array[0]) )
			message = "The first names are both " + name1Array[0] + ".";
		else
			message = "The first names are not the same.";
		
		if ( name1Array[1].equalsIgnoreCase(name2Array[1]) )
			message += "The middle names are both " + name1Array[1] + ".";
		else
			message += "The middle names are not the same.";
		
		if ( name1Array[2].equalsIgnoreCase(name2Array[2]) )
			message += "The last names are both " + name1Array[2] + ".";
		else
			message += "The last names are not the same.";
		
		return message;
	}
	
	
	/**
	 * promptNewContact prompts the user to fill out a user's contact details
	 * It will use the AddressBook class's set methods to set each field
	 * Input Validation is performed on a select inputs
	 * Not all fields are validated because I just wanted to demonstrate my 
	 * ability to use regular expressions in Java
	 * 
	 */
	public void promptNewContact() {
		
		//Create a scanner object for keyboard input
		Scanner keyboard = new Scanner(System.in);	
		
		boolean failsValidation;	// used as a flag for the do-while loop
		
		// First name
		do {
			System.out.println("Enter your first name");
			String input = keyboard.nextLine();
			
			if ( input.matches(".*\\d+.*") ) {
				failsValidation = true;
				System.out.println("Names may only contain letters.");
		}
			else if ( input.length() < 2 ){
				failsValidation = true;
				System.out.println("Names must be at least 2 letters long.");
			}
			else { 
				this.setFirstName(input);
				failsValidation = false;
			}		
		} while (failsValidation);
		
		
		// Middle name
		do {
			System.out.println("Enter your middle name");
			String input = keyboard.nextLine();
			
			if ( input.matches(".*\\d+.*") ) {
				failsValidation = true;
				System.out.println("Names may only contain letters and special characters");
		}
			else if ( input.length() < 2 ){
				failsValidation = true;
				System.out.println("Names must be at least 2 letters long.");
			}
			else { 
				this.setMiddleName(input);
				failsValidation = false;
			}		
		} while (failsValidation);
		
		
		// Last name
		do {
			System.out.println("Enter your last name");
			String input = keyboard.nextLine();
			
			if ( input.matches(".*\\d+.*") ) {
				failsValidation = true;
				System.out.println("Names may only contain letters.");
		}
			else if ( input.length() < 2 ){
				failsValidation = true;
				System.out.println("Names must be at least 2 letters long.");
			}
			else { 
				this.setLastName(input);
				failsValidation = false;
			}		
		} while (failsValidation);
		
		
		// If the user just wants to press enter instead of entering their details
		// then that is just fine with me
		System.out.println("Enter your home address");
		this.setHomeAddress(keyboard.nextLine());
		
		
		// business phone, no extensions permitted
		do {
			System.out.println("Enter your 10 or 11 digit business phone number");
			String input = keyboard.nextLine();
			
			if (! input.matches("\\d?[- ]?\\d{3}[- ]?\\d{3}[- ]?\\d{4}") ) {
				failsValidation = true;
				System.out.println("Phone numbers may only contain numbers, whitespace, and dashes.");
			}
			else { 
				this.setBusinessPhone(input);
				failsValidation = false;
			}		
		} while (failsValidation);
		
		
		
		// home phone
		do {
			System.out.println("Enter your 10 digit home phone number");
			String input = keyboard.nextLine();
			
			if (! input.matches("\\d{3}[- ]?\\d{3}[- ]?\\d{4}") ) {
				failsValidation = true;
				System.out.println("Phone numbers may only contain numbers, whitespace, and dashes.");
			}
			else { 
				this.setHomePhone(input);
				failsValidation = false;
			}		
		} while (failsValidation);
		
		
		// cell phone
		do {
			System.out.println("Enter your 10 digit cell phone number");
			String input = keyboard.nextLine();
			
			if (! input.matches("\\d{3}[- ]?\\d{3}[- ]?\\d{4}") ) {
				failsValidation = true;
				System.out.println("Phone numbers may only contain numbers, whitespace, and dashes.");
			}
			else { 
				this.setCellPhone(input);
				failsValidation = false;
			}		
		} while (failsValidation);
		
		
		
		System.out.println("Enter your personal website address");
		this.setPersonalWebsite(keyboard.nextLine());
		
		System.out.println("Enter your Skype Id");
		this.setSkypeId(keyboard.nextLine());
		
		System.out.println("Enter your Facebook Id");
		this.setFacebookId(keyboard.nextLine());
		
		//Close scanner and System.in because of resource leak
		//keyboard.close();
	}
	
	
	/**
	 * 
	 * toString  
	 * @return String of the AddressBook object in key-value format
	 */
	public String toString() {
		return "Name: " + this.getFirstName() + " " + this.getMiddleName() + " " + this.getLastName() +"\n"+
		"Home Address: " + this.getHomeAddress() + "\n" +
		"Business Phone: " + this.getBusinessPhone() + "\n" +
		"Home Phone: " + this.getHomePhone() + "\n" +
		"Cell Phone: " + this.getCellPhone() + "\n" +
		"Web Site: " + this.getPersonalWebsite() + "\n" +
		"Skype Id: " + this.getSkypeId() + "\n" +
		"Facebook Id: " + this.getFacebookId() + "\n";
	}
}
