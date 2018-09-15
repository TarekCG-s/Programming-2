package Week02;

import java.util.Arrays;
import Assignments.Sorting;

public class AlgorithmsComparison {

	
	
	public static void QuickVsQuick3() 
	{
		int IterationsCount = 0;
		int n = 10;
		int quick = 0;
		int quick3 = 0;
				
		while(true) 
		{
			IterationsCount++;

			if(IterationsCount % 10 == 0) 
			{
				n *= 10;
			}
			
			int[] A = Sorting.RandomArray(6 , n);
			int[] B = Arrays.copyOf(A, A.length);
			
			double quickStart = System.currentTimeMillis();
			Quick3Sort.StartQuickSort(A);
			double quickTime = System.currentTimeMillis() - quickStart;
			
			double quick3Start = System.currentTimeMillis();
			QuickSort.StartQuickSort(B);
			double quick3Time = System.currentTimeMillis() - quick3Start;
			
			if(quick3Time < quickTime) quick3++;
			else if (quick3Time > quickTime) quick++;
			
			System.out.printf("Quick3 = %d , Quick = %d \n", quick3, quick);
		}
		
	}
	
	
	
	public static void CompareQuickSort() 
	{
		int IterationsCount = 0;
		int n = 10;
		
		while(true) 
		{
			IterationsCount++;

			if(IterationsCount % 10 == 0) 
			{
				n *= 10;
			}

			int[] A = Sorting.RandomArray(6 , n);
			int[] B = Arrays.copyOf(A, A.length);

			QuickSort.StartQuickSort(A);
			Arrays.sort(B);

			if(Arrays.equals(A,B)) 
			{
				System.out.printf("True, number of compares is %d \n", IterationsCount);
			}

			else {
				System.out.println("Error");
				System.out.println(Arrays.toString(A));
				System.out.println(Arrays.toString(B));
				break;
			}
		}
		return;

	}
	
	
	public static void CompareQuick3Sort() 
	{
		int IterationsCount = 0;
		int n = 10;

		while(true) 
		{
			IterationsCount++;

			if(IterationsCount % 10 == 0) 
			{
				n *= 10;
			}

			int[] A = Sorting.RandomArray(6 , n);
			int[] B = Arrays.copyOf(A, A.length);

			Quick3Sort.StartQuickSort(A);
			Arrays.sort(B);

			if(Arrays.equals(A,B)) 
			{
				System.out.printf("True, number of compares is %d \n", IterationsCount);
			}

			else {
				System.out.println("Error");
				System.out.println(Arrays.toString(A));
				System.out.println(Arrays.toString(B));
				break;
			}
		}
		return;

	}
}
