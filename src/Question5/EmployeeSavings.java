package Question5;
import java.util.Random;
import Question1.AddressBook;

/*
 * Assignment 1, COMP268
 * Class: EmployeeSavings
 * 
 * This class generates random savings amounts for all of the runners
 * in the Banff Marathon over the course of one year.
 * Savings are consistently added to the account each month in fixed amounts.
 * The amount of savings over the year, including accumulated interest, is calculated.
 * The amounts each person adds to their account range between $100 to $800, in increments of $50.
 *  
 * @author Dylan Cooper
 * StudentID: 3352271
 * @since 14/11/2018 
 * @version 1.0
 * 
 */
public class EmployeeSavings extends AddressBook {
	
	//We use 13 for the size of monthly savings because index 0 represents day one's initial deposit
	//This should be private
	public double[] monthlySavings = new double[13]; //The savings for each month over the course of one year
	
	public static final double ANNUAL_INTEREST_RATE = 0.05;	// Annual interest rate
	
	Random rand = new Random();	// Class to generate a random number
	
	/*
	 * Constructor with a randomly generated saving amount
	 * We need this constructor because some people don't have a last name.
	 * @param fn = first name
	 */
	public EmployeeSavings(String fn) {
		
		super(fn);
		
		//We want savings values between 100 and 800 in increments of 50
		//Set the initial savings amount to the random savings increment
		this.monthlySavings[0] = ( rand.nextInt( 15 ) + 2 ) * 50;
	}
	
	/*
	 * EmployeeSavings constructor with a randomly generated savings amount
	 * @param fn = first name
	 * @param mn = last name, even though it means middle name in the superclass
	 */
	public EmployeeSavings( String fn, String mn ) {
		
		super(fn, mn);
		
		//We want savings values between 100 and 800 in increments of 50
		//Set the initial savings amount to the random savings increment
		//We set the bound to 15 so we get random numbers 0-14. 
		//We add 2 to deal with the range from 2 to 16. 
		//Lower bound: 2 = 100/50. Higher bound: 16 = 800/50
		this.monthlySavings[0] = ( rand.nextInt( 15 ) + 2 ) * 50;
	}
	
	
	/*
	 * generateMonthlySavings calculates the account value for each month 
	 * @return the array with the account value for each month
	 */
	public double[] generateMonthlySavings() {
		
		//iterate over each index in monthlySavings and set the account value for that month
		for ( int i = 1; i < monthlySavings.length; i++ ) {
			
			//The first month is a special case and we do not want to add the monthly deposit amount
			//as well as the previous month's total balance because that would produce an incorrect result
			// Values are rounded to 2 decimal places
			if (i == 1) 
				monthlySavings[i] = Math.round( monthlySavings[0] * (1 + ANNUAL_INTEREST_RATE/12 ) * 100.0 ) / 100.0;
			 
			//Add the monthly deposit to the previous month's total and multiply by monthly interest rate
			//Values are rounded to 2 decimal places
			else 
				monthlySavings[i] = Math.round( ( monthlySavings[i-1] + monthlySavings[0] ) * (1 + ANNUAL_INTEREST_RATE/12 ) * 100.0 ) / 100.0;			
		}
		
		return monthlySavings;
	}
	
	
	
	/*
	 * Get the last index in the array, since that is where the most recent value is stored
	 * @return the value of the account after accumulating interest and savings
	 */
	public double getAccountValue() {
		
		return this.monthlySavings[this.monthlySavings.length -1];
		
	}
	
	public static String getReport(EmployeeSavings[] runners) {
		
		String report = "";		//The report String that we will return

		//Iterate over the runners array and append the runner's details to the report string
		//We will print out the runner's name, their monthly deposit amount, and the final account value
		
		for (int i = 0; i < runners.length; i++ ) {
				
				if (runners[i].getMiddleName() != null) {
					
					report += "Name: " + runners[i].getFirstName() + " " + runners[i].getMiddleName() + "\n"
							
					+ "With monthly deposits of $" + runners[i].monthlySavings[0] + ", "
			
					+ runners[i].getFirstName() + " will save $" + runners[i].getAccountValue() + " after one year.\n\n";	
					
				}
					
				else {
					
					report += "Name: " + runners[i].getFirstName() + "\n"
							
					+ "With monthly deposits of $" + runners[i].monthlySavings[0] + ", "
			
					+ runners[i].getFirstName() + " will save $" + runners[i].getAccountValue() + " after one year.\n\n";
					
				}
					
			}
		
		return report;
	}
	

}
