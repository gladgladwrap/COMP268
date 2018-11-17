package Question8;

import Question1.AddressBook;
import java.util.ArrayList; 

/*
 * Assignment 1, COMP268
 * Class: Candidate.java
 * 
 * This class extends the AddressBook class
 * The Candidate class contains fields that represent
 * a candidate's innovative ability, their average grade
 * from their bachelor's degree, their ability to regulate their
 * own skill, and their communication skills.
 * 
 * The static methodgetEligibleCandidates can be called on
 * an array of Candidate type to produce an array list of
 * who is eligible to be interviewed by Google.
 *  
 * @author Dylan Cooper
 * StudentID: 3352271
 * @since 14/11/2018 
 * @version 1.0
 * 
 */

public class Candidate extends AddressBook{
	
	private boolean innovation;
	private double grade;
	private double regulation;
	private String communication;
	
	
	/*
	 * Constructor
	 * @param fn = first name
	 * @param mn = last name -- remember that superclass' constructor that takes 2 strings uses fn and mn
	 * @param grade in percentage
	 * @param comm = communication skills
	 * @param innov = true or false if they are innovative
	 * @param reg = from 0-1 how can they regulate their own skill
	 */
	public Candidate(String fn, String mn, double grade, String comm, boolean innov, double reg) {	
		super(fn, mn);
		this.grade = grade;
		this.communication = comm;
		this.innovation = innov;
		this.regulation = reg;		 
	}
	
	
	/*
	 * Constructor for people without last names
	 * @param fn = first name
	 * @param grade in percentage
	 * @param comm = communication skills
	 * @param innov = true or false if they are innovative
	 * @param reg = from 0-1 how can they regulate their own skill
	 */
	public Candidate(String fn, double grade, String comm, boolean innov, double reg) {	
		super(fn);
		this.grade = grade;
		this.communication = comm;
		this.innovation = innov;
		this.regulation = reg;		 
	}
	
	
	//Accessor methods
	
	
	/*
	 * Get the candidates grade in percentage
	 * @return their grade, a double, that candidate received in their bachelor's degree
	 */
	public double getGrade() {
		return this.grade;
	}
	
	/*
	 * Get the candidates ability to regulate his or her own skill level
	 * @return double value between 0.0 and 1.0 
	 */
	public double getRegulation() {
		return this.regulation;
	}
	
	/*
	 * Get the candidates communication skill
	 * @return communication skill string
	 */
	public String getCommunication() {
		return this.communication;
	}
	
	/*
	 * Should be called getInnovation
	 * @return whether the candidate is innovative or not, a boolean
	 */
	public boolean isInnovative() {
		return this.innovation;
	}
	
	
	//Mutator methods
	public void setCommunication( String comm ) {
		this.communication = comm;
	}
	
	public void setGrade( double grade ) {
		this.grade = grade;
	}
	
	/*
	 * Set the candidate's ability to regulate their own skill
	 * @param reg = regulatory capability 
	 */
	public void setRegulation( double reg ) {
		this.regulation = reg;
	}
	
	/*
	 * Set whether the candidate is innovative or not
	 * @param innov = innovation
	 */
	public void setInnovation( boolean innov ) {
		this.innovation = innov;
	}
	
	
	/*
	 * Google is considering candidates to hire
	 * 
	 * They will consider candidates with average marks > 85%
	 * unless they have poor communication skills and are not innovative.
	 * 
	 * They will consider candidates with average marks < 85% if 
	 * their regulatory abilities are at least 0.5 and 
	 * communication skills are at least "average".
	 * 
	 * They will only consider a candidate with poor communication 
	 * skills if they are innovative.
	 * Example: someone with grade > 85 with poor communication skills 
	 * and who is not innovative will not be considered.
	 * 
	 * @return eligibles, an array list of Candidate objects of those who are eligible.
	 */
	public static ArrayList<Candidate> getEligibleCandidates(Candidate[] cands) {
		
		ArrayList<Candidate> eligibles = new ArrayList<Candidate>();
		
		//Use an enhanced for loop
		for (Candidate person : cands) {
			
			
			// if the person has marks over 85
			// but if they have poor communication
			// and they are not innovative
			// then get rid of them
			if ( person.getGrade() > 85.0 ) {
				
				if ( person.getCommunication().equals("poor") && !person.isInnovative() )
					continue;
				else
					eligibles.add(person);
			}
			
			// If marks are less than 85
			// but communication skills are average or excellent
			// and the person's regulatory skills > 0.5
			// then add them to the list
			
			// If marks < 85
			// and they have poor communication
			// but they are innovative
			// do not add them to the list.
			
			
			else if ( person.getGrade() < 85.0 ) {
				
				if ( person.getCommunication().equals("average") || person.getCommunication().equals("excellent") ) {
					
					if ( person.getRegulation() >= 0.5 )
						eligibles.add(person);
				}
			}
				
		}
		
		return eligibles;
	}
	
	
	
	/*
	 * Override the toString from AddressBook
	 * @return stats, a string representing the stats of the candidate.
	 */
	public String toString() {
		
		String stats = "";
		
		if (this.getMiddleName() != null) {
			
			stats += "Name: " + this.getFirstName() + " " + this.getMiddleName()	
			
			+ "\nGrade: " + this.getGrade()
			
			+ "\nCommunication skills: " + this.getCommunication() 
			
			+ "\nInnovative: " + this.isInnovative() 
			
			+ "\nSelf-Regulatory Abilities: " + this.getRegulation() + "\n\n";
		}
			
		else {
			
			stats += "Name: " + this.getFirstName()
					
			+ "\nGrade " + this.getGrade()
	
			+ "\nCommunication skills: " + this.getCommunication() 
			
			+ "\nInnovative: " + this.isInnovative() 
			
			+ "\nSelf-Regulatory Abilities: " + this.getRegulation() + "\n\n";
			
		}
		
		return stats;
	}
}
