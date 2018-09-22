import java.util.*;
import java.math.*;

public class SortingAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arrayTest1 = new int[100000];
		int[] arrayTest2 = new int[100000];

		arrayTest2 = arrayTest1;

		for (int i = 0; i < arrayTest1.length; i++) {

			arrayTest1[i] = (int) (Math.random()*1000);

		}//end row	 

		/** This section of code is to test both array that point to the same 
		 * object against Array.sort and selection sort. Also this is the 
		 * beginning of the current time method for the runtime
		 * The run time @ 1000 elements is 2ms
		 * the run time @ 10000 elements is 11ms
		 * the run time @100000 elements is 40ms*/

		{
			long startTime = System.currentTimeMillis();
			Arrays.sort(arrayTest1);
			
			for(int i = 5000; i < 5020; i++)
			{
				System.out.print(arrayTest2[i] + " ");
			}
			
			for (int elements: arrayTest1) {

				//System.out.println("This is array test 1 with Array.sort sorting     " + elements);	

			}

			long runTime = System.currentTimeMillis() - startTime;

			System.out.println("This is the runTime of the block using Arrayi.sort   - " + runTime + "ms");
		}// the runtime of the Array.short block


		

		{
			/**The beginning of the testing time for the selection sort
		@1000 elements it ran at 1ms
		@10000 elements 2622ms
		@100000 elements 11977ms*/

			long startTime = System.currentTimeMillis();	

			for (int lastPlace = arrayTest2.length-1; lastPlace > 0; lastPlace--) {
				// Find the largest item among A[0], A[1], ...,
				// A[lastPlace], and move it into position lastPlace
				// by swapping it with the number that is currently
				// in position lastPlace.
				int maxLoc = 0; // Location of largest item seen so far.
				for (int j = 1; j <= lastPlace; j++) {
					if (arrayTest2[j] >arrayTest2[maxLoc]) {
						// Since A[j] is bigger than the maximum we’ve seen
						// so far, j is the new location of the maximum value
						// we’ve seen so far.
						maxLoc = j;
					}
				}
				int temp = arrayTest2[maxLoc]; // Swap largest item with A[lastPlace].
				arrayTest2[maxLoc] = arrayTest2[lastPlace];
				arrayTest2[lastPlace] = temp;
			} // end of for loop

			long runTime = System.currentTimeMillis() - startTime;
			System.out.println("This is the check time for the insertion sorting    - "+ runTime + "ms");  


		}



	}
}









