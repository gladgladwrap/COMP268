package Question6;

/*
 * Assignment 1, COMP268
 * Class: Main.java
 * 
 * This class just hardcodes the Pythagorean Theorem to find the opposite side of two different triangles
 * It would be a lot more elegant to make a class to do that but here I am following the API I was given.
 *  
 * @author Dylan Cooper
 * StudentID: 3352271
 * @since 14/11/2018 
 * @version 1.0
 * 
 */

public class Main {

	public static void main(String[] args) {
	
		System.out.println("I am going to hard code this because no method accepts any parameters.\n");
		System.out.println("Finding the remaining side:\n");
		
		
		System.out.println("a = 48, c = 80, b = "+ Math.round( Math.sqrt( Math.pow(80, 2) - Math.pow(48, 2) ) ) );
		
		System.out.println("a = 84, c = 91, b = "+ Math.round( Math.sqrt( Math.pow(91, 2) - Math.pow(84, 2) ) ) );
		
		
		Triangle katy = new Triangle(45, 55, 75);
		//The only reason we have private methods is so we can't access the field directly.
		//Am I missing something? yea, I could set the variable to true inside of isRightTriangle()
		//but why is there no set method for the boolean variable rightTriangle? 
//		katy.rightTriangle = katy.isRightTriangle();
		
		Triangle tom = new Triangle(28, 45, 53);
		
		System.out.println("\nChecking to see if these triangles are right triangles:\n");
		
		
		System.out.println("Triangle with sides: " + katy.getA() + ", "
				+ katy.getB() + ", " + katy.getC() + " is a right triangle? " + katy.isRightTriangle() );
		
		System.out.println("Triangle with sides: " + tom.getA() + ", "
				+ tom.getB() + ", " + tom.getC() + " is a right triangle? " + tom.isRightTriangle() );

	}

}
