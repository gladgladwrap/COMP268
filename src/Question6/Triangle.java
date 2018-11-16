package Question6;

/*
 * Assignment 1, COMP268
 * Class: Triangle.java
 * 
 * This class can make a triangle and check if a triangle is a right triangle
 *  
 * @author Dylan Cooper
 * StudentID: 3352271
 * @since 14/11/2018 
 * @version 1.0
 * 
 */

public class Triangle {
	
	private boolean rightTriangle;	// Why on earth is this in the API if it does not have a set method and it is private?
	//adjacent side of triangle
	private double a;
	//opposite side of triangle
	private double b;
	//hypotenuse
	private double c;
	
	/*
	 * Construcor for class Triangle
	 * @param a = the adjacent side
	 * @param b = the opposite side
	 * @param c = the hypotenuse
	 */
	public Triangle(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	//Accessor methods
	
	
	/*
	 * This does not calculate the adjacent side given the opposite side and hypotenuse
	 * @return double a is the adjacent side of triangle
	 */
	public double getA() {
		return this.a;
	}
	
	/*
	 * This does not calculate the opposite side given the adjacent and hypotenuse
	 * @return double b is the opposite side of triangle
	 */
	public double getB() {
		return this.b;
	}
	
	/*
	 * This does not calculate the hypotensue given the adjacent and opposite sides
	 * @return double c is the hypotenuse of triangle
	 */
	public double getC() {
		return this.c;
	}
	
	
	/*
	 * isRightTriangle checks to see if a triangle is a right angle triangle
	 * by using the Pythagorean Theorem
	 * @return a boolean isRightTriangle
	 */
	public boolean isRightTriangle( ) {
		boolean isRightTriangle = false;
		
		if ( Math.pow(this.a, 2) + Math.pow(this.b, 2) == Math.pow(this.c, 2)  )
			isRightTriangle = true;
		
		return isRightTriangle;
	}

}
