package Question3;

import java.util.Scanner;

/*
 * Assignment1, COMP268
 * FindDistance prompts the user to input the coordinates for 2 points on a Cartesian plane.
 * It includes some input validation, but does not check to make sure numbers have been entered.
 * It only checks to make sure that 2 points are given.
 * The program will break if it is not given a number.
 * 
 * @author Dylan Cooper
 * Student ID 3352271
 * @since 10/11/2018
 * @version 1.0
 */

public class FindDistance {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);	// To accept input from the user
		
		String[] pointBuffer; 	// To hold x and y entered by user
		
		boolean userHasInputted = false; 	// To check if the user has tried to enter a value
		
		
		
		System.out.println("We are going to calculate the distance between two points on a cartesian plane.");
		
		
		// Prompt the user for the first point's x,y coordinates
		// Split the two coordinates into array pointBuffer
		// Make sure that array is of length 2, otherwise user has not entered x,y coordinates
		// Assign the parsed Double value of first index of pointBuffer to x1
		// Assign the parsed Double value of the second index of pointBuffer to y1
		
		do {
			if (userHasInputted)
				
				System.out.println("You must enter only 2 coordinates");
				
			System.out.println("Enter the first (x,y) coordinates:");
			
			pointBuffer = keyboard.nextLine().split(", | |,");	// this allows 5,5 or 5 5 or 5, 5
			
			userHasInputted = true;		// The user has made an attempt to enter coordinates
			
		} while (pointBuffer.length != 2);
		
		double x1 = Double.parseDouble( pointBuffer[0] );	// set x1 to the contents of the first index
		
		double y1 = Double.parseDouble( pointBuffer[1] );	// set y1 to the contents of the second index
		
		
		
		// Return the userHasInputted for the second coordinates to false
		userHasInputted = false;
		
		
		// Prompt the user for the second point's coordinates
		// Everything in this validation is the same as in the previous block
		do {
			if (userHasInputted)
				
				System.out.println("You must enter only 2 coordinates");
				
			System.out.println("Enter the second (x,y) coordinates:");
			
			pointBuffer = keyboard.nextLine().split(", | |,");
			
			userHasInputted = true;
			
		} while (pointBuffer.length != 2);
		
		keyboard.close();
		
		double x2 = Double.parseDouble( pointBuffer[0] );
		
		double y2 = Double.parseDouble( pointBuffer[1] );
		
		
		// Call the function with user inputs
		// Print the distance between the two points
		System.out.println( CartesianCoordinateSystem.calculateDistance(x1, y1, x2, y2) );

	}

}
