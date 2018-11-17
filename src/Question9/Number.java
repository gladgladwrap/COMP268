package Question9;
import java.util.ArrayList;

/*
 * Assignment 1, COMP268
 * Class: Number.java
 * 
 * This class has no fields. 
 * It only contains static methods.
 * These methods check if each number, from 1 to 113
 * is divisible by 5, 7 is odd, and is prime.
 *  
 * @author Dylan Cooper
 * StudentID: 3352271
 * @since 14/11/2018 
 * @version 1.0
 * 
 */
public class Number {
	
	public static void main(String[] args) {
		
		System.out.println( Number.iterate() );
		
	}
		
	
	
	/*
	 * Iterate over numbers 1 to 113
	 * Runs the other static methods and adds an expression to
	 * the array list if they run true, as follows: 
	 * isOdd adds "is odd", 
	 * isDivisibleBy5 adds "hi five"
	 * isDivisibleby7 adds "wow" if the sue of the number and the
	 * one after it are divisible by 7, 
	 * isPrime adds "prime".
	 * @return an array list of the random expressions
	 */
	public static ArrayList<String> iterate() {
		
		ArrayList<String> message = new ArrayList<String>();
		
		// iterate from 1 to 113
		for ( int i = 1; i <= 113; i++ ) {
			
			//We need to convert the integer to a String
			//in order to add it to the array list of type String
			message.add( "\n" + Integer.toString( i ) );
			
			
			if ( Number.isOdd( i ) )
				
				message.add("is odd" );
			
			
			if ( Number.isDivisibleBy5( i ) )
				
				message.add( "hi five" );
			
			
			if ( Number.isDivisibleBy7( i + (i + 1 ) ) )
				
				message.add( "wow" );
			
			if ( Number.isPrime( i ) )
				
				message.add( "prime" );
		}
		
		return message;
	}
	
	/*
	 * Check if a number is odd by using the remainder operator
	 * @param n is an int
	 * @return true if it is odd, false if not
	 */
	public static boolean isOdd( int n ) {
		
		if ( n % 2 == 1)
			
			return true;
		else
			return false;
	}
	
	
	/*
	 * Check if a number is divisible by 5
	 * @param n is an int
	 * @return true if it is divisible by 5
	 */
	public static boolean isDivisibleBy5( int n ) {
		
		if ( n % 5 == 0)
			
			return true;
		else
			return false;
	}
	
	/*
	 * Check if a number is divisible by 7
	 * @param n is an int
	 * @return true if it is divisible by 7
	 */
	public static boolean isDivisibleBy7( int n ) {
		
		if ( n % 7 == 0)
			return true;
		else
			return false;
	}
	
	
	/*
	 * Check if a number is prime
	 * A prime number has factors of 1 and itself
	 * @param n is an int
	 * @return true if it is prime
	 */
	public static boolean isPrime( int n ) {
		
		// check if the number is a base case
		if ( n == 1 )
			return false;
		
		else if ( n == 2 )
			return true;
		
		// If n divided by a number greater than 1 does not return
		// a remainder then it means it is not prime.
		//
		// We will use (n + 1) / 2 as our upper bounds for the 
		// for loop, because a number  cannot have a factor that is 
		// greater than half of its value.
		// We use n + 1 because we cannot divide an odd number
		// by 2, and an odd number plus 1 is always even.
		
		else {
			if (n % 2 == 0 )
				return false;
			else {
				for (int i = 3; i < ((n + 1)/2); i++ ) {
					if (n % i == 0)
						return false;
				}
				return true;	
			}
			
		}
	}
	
}
