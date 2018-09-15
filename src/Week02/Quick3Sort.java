package Week02;

import java.util.Arrays;

/**
 * This class implements the quick3 sort algorithm which is faster - in some cases - than quick sort.
 * @author Tarek
 *
 */
public class Quick3Sort {


	/**
	 * Implements the quick3 sort Algorithm on Array.
	 * @param A
	 */
	public static void StartQuick3Sort(int[] A) 
	{
		Quick3Sort.Quick3SortProcess(A, 0, A.length - 1);
	}



	/**
	 * Places the pivot in the correct position, with smaller numbers on the left of the pivot, and larger numbers on the right. 
	 * @param A The array in which the pivot will be placed in the correct position.
	 * @param low the index of the first item to sort.
	 * @param high the index of the last item to sort.
	 * @return the index of the pivot.
	 */
	private static int Quick3SortStep(int[] A, int low, int high) 
	{
		int[] pivotArray = new int[] {low, high, high/2}; //Array of 3 indices of potential pivots.

		int pivot = Quick3Sort.Median(new int[] {A[low], A[high], A[high/2] }); //Selecting the Median value of the 3 potential pivots.
		for (int i = 0; i < pivotArray.length; i++) 
		{
			//Placing the pivot on the most left of the array.
			if (A[pivotArray[i]] == pivot) {
				int temp = A[low];
				A[low] = pivot;
				A[pivotArray[i]] = temp;
				break;
			}
		}



		while(high > low) 
		{

			while(high > low && A[high] > pivot) high--; //Skip numbers bigger than the pivot to keep them on the right of the pivot.

			if(high == low) break; //pivot in the correct position.

			A[low] = A[high]; //if a number is smaller than the pivot, place it on the left.
			low++;


			while(low < high && A[low] < pivot) low++; //Skip numbers smaller than the pivot to keep them on the left of the pivot.
			if(high == low) break; //pivot in the correct position.

			A[high] = A[low]; //If a number is bigger than the pivot, place it on the available place on the right 
			high--;


		}
		A[low] = pivot; //set the value of the pivot in the middle.

		return low;
	}


	/**
	 * Implement the QuickSortStep Recursively.
	 * @param A the array to sort.
	 * @param low the index of the first item to sort.
	 * @param high the index of the last item to sort.
	 */
	private static void Quick3SortProcess(int[] A, int low, int high) 
	{
		if(high <= low) return; //list is less than 2 numbers.

		int pivotLoc = Quick3SortStep(A,low, high); //Returns the location of the pivot
		Quick3SortProcess(A, low , pivotLoc - 1); //Sort the left side of the pivot.
		Quick3SortProcess(A, pivotLoc + 1 ,high); //Sort the right side of the pivot.
		return;
	}

	
	/**
	 * Determines the median value of the 3 potential pivots.
	 * @param A Array of 3 potential pivots values.
	 * @return The median value.
	 */
	private static int Median(int[] A) 
	{
		Arrays.sort(A); //Sorts Values.
		return A[1]; //Returns the median value.

	}
}
