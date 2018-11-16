package Question4;


public class Main {

	public static void main(String[] args) {
		
		BanffMarathonRunner fastest; //To hold the fastest time
		BanffMarathonRunner secondFastest; // To hold the second fastest time
		
		BanffMarathonRunner[] runners = { 
				new BanffMarathonRunner("Elena", "Brandon", 341, 1),
				new BanffMarathonRunner("Thomas", "Molson", 273, 2),
				new BanffMarathonRunner("Hamilton", "Winn", 278, 5),
				new BanffMarathonRunner("Suzie", "Sarandin", 329, 7),
				new BanffMarathonRunner("Philip", "Winn", 445, 9),
				new BanffMarathonRunner("Alex", "Trebok", 275, 3),
				new BanffMarathonRunner("Emma", "Pivoto", 275, 4),
				new BanffMarathonRunner("John", "Lenthen", 243, 1),
				new BanffMarathonRunner("James", "Lean", 334, 1),
				new BanffMarathonRunner("Jane", "Ostin", 412, 1),
				new BanffMarathonRunner("Emily", "Car", 393, 4),
				new BanffMarathonRunner("Daniel", 299, 4),
				new BanffMarathonRunner("Neda", "Bazdar", 343, 3),
				new BanffMarathonRunner("Aaron", "Smith", 317, 6),
				new BanffMarathonRunner("Kate", "Hen", 265, 8)
		};
		
		// Print out the details of the fastest runner
		fastest = BanffMarathonRunner.getFastestRunner(runners);
		System.out.println("Fastest runner in the marathon: \n");
		System.out.println(fastest);
		
		// Print out the details of the second fastest runner
		secondFastest = BanffMarathonRunner.getSecondFastestRunner(runners);
		System.out.println("Second fastest runner in the marathon: \n");
		System.out.println(secondFastest);
		System.out.println("The fastest runner was " + (secondFastest.getTime() - fastest.getTime() )
				+ " minutes faster than " + secondFastest.getFirstName() + ".\n" );
		
		
		// Print out the average time of all runners
		System.out.println("The average time to complete the marathon was " 
		+ BanffMarathonRunner.getAverageTime(runners) + " minutes.\n");
		
		System.out.println("Runners faster than the average time:\n");
		System.out.println( BanffMarathonRunner.getAboveAverageRunners(runners) );
	}

}
