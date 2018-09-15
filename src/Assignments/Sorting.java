package Assignments;

import java.util.Arrays;

/**
 * This Class is used to compare the running time of Insertion sort and the built-in sorting function in Arrays.
 * @author Tarek
 *
 */
public class Sorting {
	
	/**
	 * Prints the running time of insertion sort algorithm and the built-in sorting algorithm.
	 * @param n is the length of the array.
	 */
	public void CompareSorting(int n) 
	{
		
		 //Object of Sorting Class.
		
		
		int[] arr; //Generated Array with random values.
		final int arrLength = n; //Length of the generated array.
		double startTime; //Time of the beginning of Sorting.
		double actualTime; //Taken time to sort the array.
		
		
		//Sorting using the Insertion Sort Method.
		{
			//Generating a random Array.
			arr = Sorting.RandomArray(arrLength);
			
			startTime = System.currentTimeMillis();		
			this.InsertionSort(arr);
			actualTime = System.currentTimeMillis() - startTime;
			System.out.println("The insertion sort running time is: " + actualTime);
		}
		
		
		
		//Sorting using the built-in Sort Method.
		{
			//Generating New array with the same length.
			arr = Sorting.RandomArray(arrLength);
			
			startTime = System.currentTimeMillis();
			Arrays.sort(arr);
			actualTime = System.currentTimeMillis() - startTime;
			System.out.println("The Built-in sort running time is: " + actualTime);
		}
	}
	
	
	/**
	 * Returns an array of length arrLength, filled with random values.
	 * @param arrLength = length of the Array.
	 * @return Array filled with random values.
	 */
	public static int[] RandomArray(int arrLength, int... length) 
	{
		int[] randomArray = new int[arrLength]; //Array to be filled with Random values.
		if(length.length == 1) 
		{
			for(int i = 0; i < arrLength; i++) 
			{
				randomArray[i] = (int)(length[0] * Math.random());
			}
		}
		
		else 
		{
			for(int i = 0; i < arrLength; i++) 
			{
				randomArray[i] = (int)(Integer.MAX_VALUE * Math.random());
			}
		}
		
		
		return randomArray;
		
	}
	
	
	private void InsertionSort(int A[] ) 
	{
		for(int itemsSorted = 1; itemsSorted < A.length; itemsSorted++) 
		{
			int temp = A[itemsSorted]; // The item to be inserted.
			int loc = itemsSorted - 1; // Start at end of list.
			
			while (loc >= 0 && A[loc] > temp) {
				A[loc + 1] = A[loc]; // Bump item from A[loc] up to loc+1.
				loc = loc - 1; // Go on to next location.
			}
			A[loc + 1] = temp;
		}
	}
	


}
