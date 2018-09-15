package Week02;

import java.util.Arrays;
import Assignments.Sorting;

/**
 * This Class checks the quicksort algorithm and the quick3 sort algorithm.
 * There are three subroutines in the class.
 * Subroutine checks correctness of the quicksort compared with the built-in Java sort method - Unit Testing -.
 * Subroutine checks correctness of the quick3 sort compared with the built-in Java sort method - Unit Testing -.
 * Subroutine compares the speed of quick sort vs quick3 sort.
 * @author Tarek
 *
 */
public class AlgorithmsComparison {


	/**
	 * Compares the speed of Quick sort vs Quick3 sort for the same arrays.
	 * prints the number of times of which each algorithm was faster than the other.
	 */
	public static void QuickVsQuick3() 
	{
		int IterationsCount = 0; //Number of comparisons made. 
		int maxValue = 10; //the maximum possible value of the array's elements.
		int arrSize = 6; //Size of the generated Arrays.
		int quickNums = 0; //Number of times of which Quick sort was faster than Quick3 Sort.
		int quick3Nums = 0; //Number of times of which Quick3 sort was faster than Quick Sort.

		while(true) 
		{
			IterationsCount++; //Increment number of iterations.

			//For each 10 iterations.
			if(IterationsCount % 10 == 0) 
			{
				maxValue *= 10; //Increase the maximum value of the elements of the array.
				arrSize++; //Increase the size of the array.
			}

			int[] A = Sorting.RandomArray(arrSize , maxValue); //Creating a random array of size 
			int[] B = Arrays.copyOf(A, A.length); //Copy the generated array into another.

			double quick3Start = System.currentTimeMillis(); //Start Time of the quick3 sort.
			Quick3Sort.StartQuick3Sort(A); //Implement Quick3 Sort.
			double quick3Time = System.currentTimeMillis() - quick3Start; //Actual taken time to implement Quick3 sort.

			double quickStart = System.currentTimeMillis(); //Start Time of the quick sort.
			QuickSort.StartQuickSort(B); //Implement Quick Sort.
			double quickTime = System.currentTimeMillis() - quickStart; //Actual taken time to implement Quick sort.

			if(quick3Time < quickTime) quick3Nums++; //If quick3 was faster, Increase the number of times in which it was faster.
			else if (quick3Time > quickTime) quickNums++; //If quick was faster, Increase the number of times in which it was faster.

			System.out.printf("Quick3 = %d , Quick = %d \n", quick3Nums, quickNums); //Print the number of times each in which algorithm was faster.
		}

	}


	/**
	 * Compares Quick Sort with the built-in sorting java method to check the correctness of this new algorithm.
	 * It uses unit-testing.
	 */
	public static void CompareQuickSort() 
	{
		int IterationsCount = 0;  //Number of comparisons made. 
		int maxValue = 10; //the maximum possible value of the array's elements.
		int arrSize = 6; //Size of the generated Arrays.

		while(true) 
		{
			IterationsCount++; //Increment number of iterations.

			//For each 10 iterations.
			if(IterationsCount % 10 == 0) 
			{
				maxValue *= 10; //Increase the maximum value of the elements of the array.
				arrSize++; //Increase the size of the array.
			}

			int[] A = Sorting.RandomArray(arrSize , maxValue); //Creating a random array of size 
			int[] B = Arrays.copyOf(A, A.length); //Copy the generated array into another.

			QuickSort.StartQuickSort(A); //Implement Quick Sort.
			Arrays.sort(B); //Implement the built in java Sort.
			
			//if both sorted arrays are equal, continue testing.
			if(Arrays.equals(A,B)) 
			{
				System.out.printf("True, number of compares is %d \n", IterationsCount);
			}
			
			//if sorted arrays are different, report an error.
			else {
				System.out.println("Error");
				System.out.println(Arrays.toString(A));
				System.out.println(Arrays.toString(B));
				break; //break outside of the loop.
			}
		}
		return;

	}

	/**
	 * Compares Quick3 Sort with the built-in sorting java method to check the correctness of this new algorithm.
	 * It uses unit-testing.
	 */
	public static void CompareQuick3Sort() 
	{
		int IterationsCount = 0;  //Number of comparisons made. 
		int maxValue = 10; //the maximum possible value of the array's elements.
		int arrSize = 6; //Size of the generated Arrays.

		while(true) 
		{
			IterationsCount++; //Increment number of iterations.

			//For each 10 iterations.
			if(IterationsCount % 10 == 0) 
			{
				maxValue *= 10; //Increase the maximum value of the elements of the array.
				arrSize++; //Increase the size of the array.
			}

			int[] A = Sorting.RandomArray(arrSize , maxValue); //Creating a random array of size 
			int[] B = Arrays.copyOf(A, A.length); //Copy the generated array into another.

			Quick3Sort.StartQuick3Sort(A); //Implement Quick3 Sort.
			Arrays.sort(B); //Implement the built in java Sort.
			
			//if both sorted arrays are equal, continue testing.
			if(Arrays.equals(A,B)) 
			{
				System.out.printf("True, number of compares is %d \n", IterationsCount);
			}
			
			//if sorted arrays are different, report an error.
			else {
				System.out.println("Error");
				System.out.println(Arrays.toString(A));
				System.out.println(Arrays.toString(B));
				break; //break outside of the loop.
			}
		}
		return;

	}
}
