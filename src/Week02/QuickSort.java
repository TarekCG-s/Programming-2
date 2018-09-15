package Week02;



/**
 * This class implements the quick sort algorithm which is considered one of the fastest sorting 
 * algorithms so far.
 * @author Tarek
 *
 */
public class QuickSort {
	
	/**
	 * Implements the quick sort Algorithm on Array.
	 * @param A The array to sort.
	 */
	public static void StartQuickSort(int[] A) 
	{
		//Calling Quick Sort providing the entire array.
		QuickSort.QuickSortProcess(A, 0, A.length - 1);
	}
	
	/**
	 * Places the pivot in the correct position, with smaller numbers on the left of the pivot, and larger numbers on the right. 
	 * @param A The array in which the pivot will be placed in the correct position.
	 * @param low the index of the first item to sort.
	 * @param high the index of the last item to sort.
	 * @return the index of the pivot.
	 */
	private static int QuickSortStep(int[] A, int low, int high) 
	{
		int pivot = A[low]; //Initializing the pivot to be the first index of the Array.

		while(high > low) 
		{

			while(high > low && A[high] > pivot) high--; //Skip numbers bigger than the pivot to keep them on the right of the pivot.

			if(high == low) break; //Pivot in the correct position.

			A[low] = A[high]; //if a number is smaller than the pivot, place it on the left.
			low++;


			while(low < high && A[low] < pivot) low++; //Skip numbers smaller than the pivot to keep them on the left of the pivot.
			if(high == low) break; //Pivot in the correct position.

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
	private static void QuickSortProcess(int[] A, int low, int high) 
	{
		if(high <= low) return; //list is less than 2 numbers.

		int pivotLoc = QuickSortStep(A,low, high); // returns the location of the pivot.
		QuickSortProcess(A, low , pivotLoc - 1); //Sort the left side of the pivot.
		QuickSortProcess(A, pivotLoc + 1 ,high); //Sort the right side of the pivot.
		return;
	}
	
	
	
	
	

}
