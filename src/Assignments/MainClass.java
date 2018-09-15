package Assignments;

import java.util.Scanner;
public class MainClass {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		
		MainClass.calculator();

	}
	
	public static void calculator() 
	{
		
		boolean repeat = false; //Boolean variable for checking if the user wants to try again.
		
		do 
		{
			//get A, B, C values from the user.
			System.out.print("A: ");
			double a = scanner.nextDouble();
			
			System.out.print("B: ");
			double b = scanner.nextDouble();
			
			System.out.print("C: ");
			double c = scanner.nextDouble();
			
			//initializing the answer with 0.
			double root = 0;
			
			try 
			{
				root = MainClass.root(a,b, c);
				System.out.printf("the root is: %f " , root);
			}
			
			catch (IllegalArgumentException e) 
			{
				//Printing the exception message.
				System.out.println(e.getMessage());
			}
			
			finally 
			{
				//Checking whether the user wants to try again or not.
				System.out.print("Do you wanna try another equation? ");
				repeat = scanner.hasNext();
			}
			
		} while (repeat == true);

		
	}
	static public double root( double A, double B, double C ) 
			throws IllegalArgumentException {
		if (A == 0) {
			throw new IllegalArgumentException("A can't be zero.");
		}
		else {
			double disc = B*B - 4*A*C;
			if (disc < 0)
				throw new IllegalArgumentException("Discriminant < zero.");
			return  (-B + Math.sqrt(disc)) / (2*A);
		}
	}
	
	
	
	

}
