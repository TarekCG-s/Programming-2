package Week02;

import java.util.Arrays;


public class Quick3Sort {

	public static void StartQuickSort(int[] A) 
	{
		Quick3Sort.QuickSortProcess(A, 0, A.length - 1);
	}

	

	private static int QuickSortStep(int[] A, int low, int high) 
	{
		int[] pivotArray = new int[] {low, high, high/2};
		int pivot = Quick3Sort.Median(new int[] {A[low], A[high], A[high/2] });
		for (int i = 0; i < pivotArray.length; i++) 
		{
			if (A[pivotArray[i]] == pivot) {
				int temp = A[low];
				A[low] = pivot;
				A[pivotArray[i]] = temp;
				break;
			}
		}



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

	private static int Median(int[] A) 
	{
		Arrays.sort(A);

		return A[1];

	}
}
