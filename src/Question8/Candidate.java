package Question8;

import Question1.AddressBook;

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
	 * Constructor
	 * @param fn = first name
	 * @param mn = last name -- remember that superclass' constructor that takes 2 strings uses fn and mn
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
	
	public double getGrade() {
		return this.grade;
	}
	
	public double getRegulation() {
		return this.regulation;
	}
	
	public String getCommunication() {
		return this.communication;
	}
	
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
	
	public void setRegulation( double reg ) {
		this.regulation = reg;
	}
	
	public void setInnovation( boolean innov ) {
		this.innovation = innov;
	}
}
