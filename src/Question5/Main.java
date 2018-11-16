package Question5;

/*
 * Assignment1, COMP268
 * Class: Main.java
 * 
 * Instantiate our array of EmployeeSavings and generate
 * random savings data for each person.
 * We print off a report of all the savings for each person
 * 
 * @author Dylan Cooper
 * StudentID: 3352271
 * @since 14/11/2018
 * @version 1.0
 */

public class Main {

	public static void main(String[] args) {
		
		//Bring in the name data for all of the runners 
		EmployeeSavings[] runners = { 
				new EmployeeSavings("Elena", "Brandon"),
				new EmployeeSavings("Thomas", "Molson"),
				new EmployeeSavings("Hamilton", "Winn"),
				new EmployeeSavings("Suzie", "Sarandin"),
				new EmployeeSavings("Philip", "Winn"),
				new EmployeeSavings("Alex", "Trebok"),
				new EmployeeSavings("Emma", "Pivoto"),
				new EmployeeSavings("John", "Lenthen"),
				new EmployeeSavings("James", "Lean"),
				new EmployeeSavings("Jane", "Ostin"),
				new EmployeeSavings("Emily", "Car"),
				new EmployeeSavings("Daniel"),
				new EmployeeSavings("Neda", "Bazdar"),
				new EmployeeSavings("Aaron", "Smith"),
				new EmployeeSavings("Kate", "Hen")
		};
		
		
		for (int i = 0; i < runners.length; i++ )
			
			runners[i].monthlySavings = runners[i].generateMonthlySavings(); 
			
		System.out.println( EmployeeSavings.getReport(runners) );
		
		
	}

}
