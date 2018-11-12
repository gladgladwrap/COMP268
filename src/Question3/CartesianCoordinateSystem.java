package Question3;

/*
 * Assignment 1, COMP268
 * Class: CartesianCoordinateSystem.java
 * Purpose: This program calculates the distance between two points on a Cartesian plane.
 * The user is prompted to enter these two different points.
 * Both points are defined by their x,y coordinates.
 * 
 * @author Dylan Cooper
 * Student ID: 3352271
 * @since 10/11/2018
 * @version 1.0
 * 
 */

public class CartesianCoordinateSystem {
	
	/**
	 * Calculate the distance between two points on a Cartesian plane
	 * @param x1 = x coordinate of point number 1
	 * @param y1 = y coordinate of point number 1
	 * @param x2 = x coordinate of point number 2
	 * @param y2 = y coordinate of point number 2
	 * @return the distance, rounded to 2 decimal places, between both points
	 */

	public static double calculateDistance(double x1, double y1, double x2, double y2) {
		
		double a = Math.sqrt( Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) );
		
		a = Math.round(a * 100.0 ) / 100.0;
		
		return a;
	}
}
