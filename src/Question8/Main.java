package Question8;

/*
 * Assignment 1, COMP268
 * Class: Main.java
 * 
 * Has the array of Candidates
 * and calls getEligibleCandidates 
 * so we can have a list of who is eligible
 * to be interviewed by Google
 *  
 * @author Dylan Cooper
 * StudentID: 3352271
 * @since 14/11/2018 
 * @version 1.0
 * 
 */

public class Main {

	public static void main(String[] args) {
		
		Candidate[] cands = { 
				new Candidate("Elena", "Brandon", 82.30, "poor", true, 0.5),
				new Candidate("Thomas", "Molson", 85.10, "poor", false, 1.0),
				new Candidate("Hamilton", "Winn", 77.77, "average", false, 0.8),
				new Candidate("Suzie", "Sarandin", 69.93, "average", false, 0.0),
				new Candidate("Philip", "Winn", 93.03, "average", true, 1.0),
				new Candidate("Alex", "Trebok", 88.61, "poor", true, 0.7),
				new Candidate("Emma", "Pivoto", 55.99, "excellent", false, 0.8),
				new Candidate("John", "Lenthen", 87.49, "excellent", true, 0.9),
				new Candidate("James", "Lean", 88.00, "excellent", false, 0.5),
				new Candidate("Jane", "Ostin", 91.20, "average", true, 0.6),
				new Candidate("Emily", "Car", 66.79, "excellent", false, 0.3),
				new Candidate("Daniel", 76.65, "average", true, 0.2),
				new Candidate("Neda", "Bazdar", 55.89, "excellent", true, 0.5),
				new Candidate("Aaron", "Smith", 90.01, "excellent", false, 0.3),
				new Candidate("Kate", "Hen", 87.90, "poor", false, 0.8)
		};

		System.out.println( Candidate.getEligibleCandidates(cands) );
		
		
	}

}
