package Question7;

import java.util.Scanner;
import java.util.ArrayList;

/*
 * Assignment 1, COMP268
 * Class: HailstoneSequence.java
 * 
 * This class provides a static method to produce the hailstone sequence
 * for a user-given number.
 * If the number is even, it divides the number by 2 and then adds that number to
 * the array list.
 * If the number is odd, it multiplies it by 3 and adds 1 and then adds that number
 * to the array list.
 * The sequence is complete when 1 is reached.
 *  
 * @author Dylan Cooper
 * StudentID: 3352271
 * @since 14/11/2018 
 * @version 1.0
 * 
 */

public class HailstoneSequence {

	public static void main(String[] args) {
		
		//Initialize scanner to receive user input
		Scanner keyboard = new Scanner(System.in);
		
		int input = 0; 	//Hold the user's integer
		
		boolean validInput = false;	//To check if the user has entered the right value
		
		do {
			System.out.println("Please enter an integer greater than 1:");
			
			input = keyboard.nextInt();
			
			if  (input > 1 ) {
				validInput = true;
				continue;
			}
				
			System.out.println("Please follow the instructions.");
		}
		while ( !validInput );
		
		System.out.println( HailstoneSequence.getHailstoneSequence(input) );
		
		//Print off the size of the Array List
		System.out.println("\nNumber of steps: " + HailstoneSequence.getHailstoneSequence(input).size() );
		keyboard.close();
		
	}
	
	/*
	 * static method getHailstoneSequence brings the number entered back to 1 through a hailstone sequence
	 * @param n = an int that the user enters 
	 * @return an ArrayList of integers containing the hailstone sequence
	 */
	public static ArrayList<Integer> getHailstoneSequence(int n) {
		
		//Initialize ArrayList
		ArrayList<Integer> sequence = new ArrayList<Integer>();
		
		while (n != 1) {
			
			// if n is even
			if ( n % 2 == 0 ) {
				n = n / 2;
				sequence.add(n);
			}
			
			else {
				n = n * 3 + 1;
				sequence.add(n);
			}
		}
				
		return sequence;
	}
}
