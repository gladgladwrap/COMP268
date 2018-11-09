package Question2;
import java.text.DecimalFormat;

/*
 * Assignment 1, COMP268
 * Class: CalculateBonus.java
 * Purpose: the user enters an employee's monthly savings commitment 
 * as well as their quarterly savings for one year. The program calculates the employee's 
 * bonus for the year. The total bonus is the sum of quarterly and annual bonuses.
 * 
 * @author Dylan Cooper
 * Student ID: 3352271
 * @since 07/11/2018
 * @version 1.0
 * 
 */

public class CalculateBonus {

	public static void main(String[] args) {
		// Using a Decimal formatter to present the total annual bonus
		DecimalFormat formatter = new DecimalFormat("#,##0.00");
		
		// Print the results for the first employee
		double bonus = computeBonus(2000, 5000, 7000, 4000, 8000);
		System.out.println("Total bonus for the year: $" + formatter.format(bonus) );
		
		System.out.println("\n");
		
		// Print the results for the second employee
		bonus = computeBonus(3000, 6000, 9000, 10000, 17000);
		System.out.println("Total bonus for the year: $" + formatter.format(bonus) );
	}
	
	
	
	
	
	
	
	
	
	
	/**
	 * computeBonus calculates and prints the quarterly and annual bonuses for employees of Space Inc.
	 * It is assumed that quarterly bonuses are not deducted from annual savings.
	 * 
	 * @param commitment is the amount of money that is committed monthly by the employee 
	 * @param q1 are the savings from quarter one
	 * @param q2 are the savings from quarter two
	 * @param q3 are the savings from quarter three
	 * @param q4 are the savings from quarter four
	 * @return the bonus that an employee earns in one year
	 */
	public static double computeBonus(double commitment, double q1, double q2, double q3, double q4) {
		
		double quarterlyMinimum;	// equal to the monthly commitment * 3
		double annualMinimum;		// equal to the monthly commitment * 12
		
		double annualSavings;		// Sum of savings from all four quarters
		double totalBonus = 0;		// To hold the sum of the quarterly and annual bonuses
		
		final double QUARTERLY_BONUS_RATE = 0.03;	// The quarterly bonus is 3% of eligible quarterly savings
		final double ANNUAL_BONUS_RATE = 0.05;		// The annual bonus is 5% of eligible annual savings
		
		//Since we are dealing with money, format doubles to two decimal places
		DecimalFormat formatter = new DecimalFormat("#,##0.00");	
		
		quarterlyMinimum = commitment * 3;
		annualMinimum = commitment * 12;
		annualSavings = q1 + q2 + q3 + q4;
		
		System.out.println("With monthly commitments of $" + formatter.format(commitment) + 
				", the employee will need \nto save over $" + formatter.format(quarterlyMinimum) +
				"/quarter in order to earn a quarterly bonus \nand over $" + formatter.format(annualMinimum) + 
				" in order to earn an annual bonus.");
		System.out.println("\nQuarterly Savings:\n");
		System.out.println("Quarter 1: $" + formatter.format(q1) +"\n" +
				"Quarter 2: $" + formatter.format(q2) +"\n" +
				"Quarter 3: $" + formatter.format(q3) +"\n" +
				"Quarter 4: $" + formatter.format(q4) );
		
		System.out.println("\nAnnual Savings: $" + formatter.format(annualSavings) );
		
		// calculate quarterly bonuses
		if (q1 > quarterlyMinimum)
			totalBonus = (q1 - quarterlyMinimum) * QUARTERLY_BONUS_RATE;
		if (q2 > quarterlyMinimum)
			totalBonus += (q2 - quarterlyMinimum) * QUARTERLY_BONUS_RATE;
		if (q3 > quarterlyMinimum)
			totalBonus += (q3 - quarterlyMinimum) * QUARTERLY_BONUS_RATE;
		if (q4 > quarterlyMinimum)
			totalBonus += (q4 - quarterlyMinimum) * QUARTERLY_BONUS_RATE;
		
		System.out.println("Total quarterly bonuses: $" + formatter.format(totalBonus) );
		
		// calculate the employee's annual bonus based on savings greater than their annual minimum
		if (annualSavings > annualMinimum)
			totalBonus += (annualSavings - annualMinimum) * ANNUAL_BONUS_RATE;
		
		// Add any extra bonuses for annual savings 25% greater than their annual minimum 
		if (annualSavings > annualMinimum * 1.25 )
			totalBonus += (annualSavings - annualMinimum * 1.25 );	
		
		return totalBonus;
	}
}
