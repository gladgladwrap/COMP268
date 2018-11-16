package Question4;

import Question1.AddressBook;

/**
 * Assignment 1, COMP268
 * Class:	BanffMarathonRunner.java
 *  
 * This class stores all of a runner's contact information and additionally stores 
 * his or her runner information, including their marathon time in minutes and 
 * number of years competing.
 * 
 * @author Dylan
 * Student Id: 3352271
 * @since 11/11/2018
 * @version 1.0
 * 
 */

public class BanffMarathonRunner extends AddressBook {
	
	private int time; 	// The runner's time in minutes
	private int years; 	// Number of years the runner has participated
	
	
	//constructors
	
	/*
	 * Empty constructor of BanffMarathonRunner
	 */
	public BanffMarathonRunner() {
		super();
	}
	
	/*
	 * Build an instance of BanffMarathonRunner without a middle and last name
	 * @param fn = first name
	 * @param time = number of minutes to run the marathon
	 * @param years = number of years participating in marathon
	 */
	public BanffMarathonRunner(String fn, int time, int years) {
		super(fn);
		this.time = time;
		this.years = years;
	}
	
	/*
	 * Build an instance of BanffMarathon runner without a middle name
	 * @param fn = first name
	 * @param mn = last name ... is this a trick????
	 * @param time = number of minutes to run the marathon
	 * @param years = number of years participating in marathon
	 */
	public BanffMarathonRunner(String fn, String mn, int time, int years) {
		super(fn, mn);
		this.time = time;
		this.years = years;
	}
	
	//Mutator methods
	
	/*
	 * Set the marathon time of a runner in minutes
	 * @param time is given in minutes
	 */
	public void setTime(int time) {
		this.time = time;
	}
	
	/*
	 *  Set the number of years that the runner has competed in the marathon
	 *  @param years = number of years athlete has participated
	 */
	public void setYears(int years) {
		this.years = years;
	}
	
	//Accessor methods
	
	/*
	 * getTime()
	 * @return Time in minutes that the runner completed the marathon
	 */
	public int getTime() {
		return this.time;
	}
	
	/*
	 * getYears()
	 * @return the number of years that a runner has participated in the marathon
	 */
	public int getYears() {
		return this.years;
	}
	
	
	/*
	 * getFastestRunner finds the object with the fastest marathon time
	 * It iterates over all objects in the array and calls getTime() on each
	 * and compares that against the the time of the runner stored in
	 * the instance variable fastest.
	 * @param runners is an array of BanffMarathonRunner objects.
	 * @returns the object with the fastest time.
	 */
	public static BanffMarathonRunner getFastestRunner(BanffMarathonRunner[] runners) {
		
		BanffMarathonRunner fastest = runners[0]; 	//Set this to the one with fastest time
		
		for (int i=0; i<runners.length; i++) {
			if ( runners[i].getTime() < fastest.getTime() )
				fastest = runners[i];
		}
		
		return fastest;
	}
	
	/*
	 * getSecondFastestRunner finds the second fastest runner of all participants.
	 * @param runners[] is an array of BanffMarathonRunners
	 * @return BanffMarathonRunner object with the second fastest time.
	 */
	public static BanffMarathonRunner getSecondFastestRunner(BanffMarathonRunner[] runners) {
		BanffMarathonRunner fastest = BanffMarathonRunner.getFastestRunner(runners);
		BanffMarathonRunner secondFastest;	// holds the second fastest runner while we iterate the array
		
		//Set secondFastest to the slower of the first or second objects in our runners array
		if (runners[0].getTime() < runners[1].getTime() )
			secondFastest = runners[1];
		else
			secondFastest = runners[0];
		
		//Set the secondFastest to whomever is faster, but also is slower than the fastest
		for (int i=0; i<runners.length; i++) {
			if ( runners[i].getTime() < secondFastest.getTime() && runners[i].getTime() > fastest.getTime() )
				secondFastest = runners[i];
		}
		
		return secondFastest;
	}
	
	
	/*
	 * getAverageTime calculates the average time of all the runners.
	 * @return a double rounded to 2 decimal places representing the average time in minutes.
	 */
	public static double getAverageTime(BanffMarathonRunner[] runners) {
		double averageTime = 0; 	//Holds the average time
		double totalTime = 0;		//Holds all runners times during the iteration
		
		for (int i = 0; i<runners.length; i++) {
			totalTime += runners[i].getTime();
		}
		
		averageTime = totalTime / runners.length;
		
		return Math.round(averageTime * 100.0) / 100.0 ;
	}
	
	public static String getAboveAverageRunners(BanffMarathonRunner[] runners) {
		
		String aboveAvg = ""; 	//Holds the string of names of runners who are faster than the average completion time.
		
		for (int i = 0; i<runners.length; i++) {
			if ( runners[i].getTime() < BanffMarathonRunner.getAverageTime(runners) )
			aboveAvg += runners[i].getFirstName() + " " + runners[i].getMiddleName()
			+ ", Years competing: " + runners[i].getYears() + ".\n";
		}
		
		return aboveAvg;
	}
	
	
	/*
	 * toString will check to see if the athlete has a last name, which is actually 
	 * being stored as the middle name. I am storing the last name in the middle name
	 * because the API for this question requests that we pass in firstName + lastName.
	 * The conflict here is that the constructor for two Strings in our superclass
	 * is dedicated to firstName + middleName, and I don't want to lose marks on that
	 * question.
	 * If the athlete does not have a last name, we just print his or her first name.
	 * (non-Javadoc)
	 * @see Question1.AddressBook#toString()
	 */
	public String toString() {
		
		if (this.getMiddleName() != null) {
			return "Athlete: " + this.getFirstName() + " " + this.getMiddleName() +"\n"
			+ "Marathon Completion Time: " + this.getTime() + " minutes\n"
			+ "Number of years participating: " + this.getYears() + "\n";
		}
		else
			return "Athlete: " + this.getFirstName() + "\n"
			+ "Marathon Completion Time: " + this.getTime() + " minutes\n"
			+ "Number of years participating: " + this.getYears() + "\n";
	}
}
