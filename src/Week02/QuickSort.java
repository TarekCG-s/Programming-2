package Week02;



/**
 * This class implements the quick sort algorithm which is considered one of the fastest sorting 
 * algorithms so far.
 * @author Tarek
 *
 */
public class QuickSort {
	
	
	public static void StartQuickSort(int[] A) 
	{
		QuickSort.QuickSortProcess(A, 0, A.length - 1);
	}
	
	
	
	
	private static int QuickSortStep(int[] A, int low, int high) 
	{
		int pivot = A[low];

		while(high > low) 
		{

			while(high > low && A[high] > pivot) high--;

			if(high == low) break;

			A[low] = A[high];
			low++;


			while(low < high && A[low] < pivot) low++;
			if(high == low) break;

			A[high] = A[low];
			high--;


		}
		A[low] = pivot;

		return low;
	}
	
	private static void QuickSortProcess(int[] A, int low, int high) 
	{
		if(high <= low) return;

		int pivotLoc = QuickSortStep(A,low, high);
		QuickSortProcess(A, low , pivotLoc - 1);
		QuickSortProcess(A, pivotLoc + 1 ,high);
		return;
	}
	
	
	
	
	

}
