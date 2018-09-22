import java.util.Scanner;

/**
 * this class is used to calculate the fibonacci and factorials of number.
 * it contains two methods, one for the  fibonacci and the other is for factorials.
 * @author Tarek
 *
 */
public class Fibonacci {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in); //Using scanner to get input from user.
		
		System.out.print("What's your number for factorial: ");
		int input = scanner.nextInt(); //integer input from the user.
		System.out.println(factorial(input)); //prints out the output of the factorial function.
		
		System.out.print("What's your number for fibonacci: ");
		input = scanner.nextInt();//integer input from the user.
		System.out.println(fibonacci(input)); //prints out the output of the fibonacci function.
		
		scanner.close(); //Closing the scanner.

	}

	/**
	 *Calculating the fibonacci sum of a number using recursion.
	 * @param n the integer of which we need to calculate fibonacci. 
	 * @return the fibonacci of the input number.
	 */
	public static int fibonacci(int n)
	{
		
		if(n ==0 || n == 1)
			return 1;
		else if( n < 0) 
			return 0;
		
		return (fibonacci(n - 1) + fibonacci(n - 2));
		
	}
	
	/**
	 * Calculates the factorial number of the input
	 * @param n is the number to which the 
	 * @return
	 */
	public static int factorial(int n) 
	{ 
		if(n == 0)
			return 1;
		return (n * factorial(n -1));
		
	}
}
