package Question10;

import java.util.Scanner;

/*
 * Assignment 1, COMP268
 * Class: TaxReturn.java
 * 
 * This class calculates the taxes that must be paid
 * by a person, determined by their marital status.
 * A credit of $5000 is given per child to single parents.
 *  
 * @author Dylan Cooper
 * StudentID: 3352271
 * @since 17/11/2018 
 * @version 1.0
 * 
 */

public class TaxReturn
{  
   /**
      Constructs a TaxReturn object for a given income and 
      marital status, and computes the tax.
      @param anIncome the taxpayer income
      @param aStatus either SINGLE or MARRIED
   */   
   public TaxReturn(double anIncome, int aStatus) {  
      
	  this.income = anIncome;
      this.status = aStatus;
   }
   
   /**
   Constructs a TaxReturn object for a given income, 
   marital status, and number of children. It then computes the tax.
   @param anIncome the taxpayer income
   @param aStatus either SINGLE or MARRIED
*/
   public TaxReturn(double anIncome, int aStatus, int someChildren) {
	  
	   this.income = anIncome;
	   this.status = aStatus;
	   this.children = someChildren;
   }

   public double getTax()
   {  
      double tax = 0;

      if (status == SINGLE)
      {  
         if (income <= SINGLE_BRACKET1)
            tax = RATE1 * income;
         else if (income <= SINGLE_BRACKET2)
            tax = RATE1 * SINGLE_BRACKET1
                  + RATE2 * (income - SINGLE_BRACKET1);
         //You would think this would compare to bracket3 but
         //Bracket3 is actually Bracket4 and 4 doesn't really exist.
         else if (income < SINGLE_BRACKET4)
        	 tax = RATE1 * SINGLE_BRACKET1
             + RATE2 * (SINGLE_BRACKET2 - SINGLE_BRACKET1)
             + RATE3 * (income - SINGLE_BRACKET2);
         else
        	 tax = RATE1 * SINGLE_BRACKET1
             + RATE2 * (SINGLE_BRACKET2 - SINGLE_BRACKET1)
             + RATE3 * (income - SINGLE_BRACKET2)
             + (0.25 * ( income - SINGLE_BRACKET3 ) );
      }
      // if the person is a single parent
      // compute the same tax as a SINGLE 
      // but reduce taxes by $5000/ child
      // This means that they get a credit for having children
      else if (status == SINGLE_PARENT)
      {  
         if (income <= SINGLE_BRACKET1)
            tax = RATE1 * income - ( children * 5000 );
         else if (income <= SINGLE_BRACKET2)
            tax = RATE1 * SINGLE_BRACKET1 - ( children * 5000 )
                  + RATE2 * (income - SINGLE_BRACKET1);
         else
            tax = RATE1 * SINGLE_BRACKET1 - ( children * 5000 )
                  + RATE2 * (SINGLE_BRACKET2 - SINGLE_BRACKET1)
                  + RATE3 * (income - SINGLE_BRACKET2);
      }
      else if (status == MARRIED)
      {  
         if (income <= MARRIED_BRACKET1)
            tax = RATE1 * income;
         else if (income <= MARRIED_BRACKET2)
            tax = RATE1 * MARRIED_BRACKET1
                  + RATE2 * (income - MARRIED_BRACKET1);
         else if (income <= MARRIED_BRACKET4)
            tax = RATE1 * MARRIED_BRACKET1
                  + RATE2 * (MARRIED_BRACKET2 - MARRIED_BRACKET1)
                  + RATE3 * (income - MARRIED_BRACKET2);
         else
        	 tax = RATE1 * MARRIED_BRACKET1
             + RATE2 * (MARRIED_BRACKET2 - MARRIED_BRACKET1)
             + RATE3 * (income - MARRIED_BRACKET2)
             + (0.35 * ( income - MARRIED_BRACKET3 ) );
      }
      
      return tax;
   }

   public static final int SINGLE = 1;
   public static final int MARRIED = 2;
   public static final int SINGLE_PARENT = 3;
   private static final double RATE1 = 0.15;
   private static final double RATE2 = 0.28;
   private static final double RATE3 = 0.31;
   private static final double SINGLE_BRACKET1 = 21450;
   private static final double SINGLE_BRACKET2 = 51900;
   private static final double SINGLE_BRACKET3 = 150000;
   private static final double SINGLE_BRACKET4 = 249999;
   private static final double MARRIED_BRACKET1 = 35800;
   private static final double MARRIED_BRACKET2 = 86500;
   private static final double MARRIED_BRACKET3 = 200000;
   private static final double MARRIED_BRACKET4 = 349999;
   private double income;
   private int status;
   private int children;

   public static void main(String[] args)
   {  
      Scanner in = new Scanner(System.in);
      System.out.print("Please enter your income: ");
      double income = in.nextDouble();

      System.out.print("Enter S (single), M (married), or SP (single parent): ");
      String input = in.next();
      int status = 0;

      if (input.equalsIgnoreCase("S")) 
         status = TaxReturn.SINGLE;
      else if (input.equalsIgnoreCase("M")) 
         status = TaxReturn.MARRIED;
      else if (input.equalsIgnoreCase("SP")) 
          status = TaxReturn.SINGLE_PARENT;
      else 
      {
         System.out.println("You are not single, married, or a single parent.");
         System.out.println("You will be taxed at 33%");
         System.out.println("The tax is " + 0.33 * income);
         in.close();
         return;
      }
      
      if (status == SINGLE_PARENT) {
    	  System.out.print("Please enter number of children: ");
    	  //I would check to make sure children <= 1
          //but since they don't get a tax break, it doesn't matter
          int children = in.nextInt(); 
          TaxReturn aTaxReturn = new TaxReturn(income, status, children);
          System.out.println("The tax is " + aTaxReturn.getTax());
      }
      else {
    	  TaxReturn aTaxReturn = new TaxReturn(income, status);
    	  System.out.println("The tax is " + aTaxReturn.getTax());
      }
      
      in.close();
   }
}

