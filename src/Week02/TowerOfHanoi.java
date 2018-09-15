package Week02;

/**
 * This Class implements the Tower Of Hanoi game, It provides the user with the steps to be taken 
 * in order to solve the game.
 * @author Tarek
 *
 */
public class TowerOfHanoi {
	
	/**
	 * Constructor to initialize the game.
	 * @param discs the number of discs that needs to be moved.
	 * @param from is the stack from which discs needs to move.
	 * @param to is the stack to which discs will go.
	 * @param spare is an empty supplementary stack for the algorithm to work.
	 */
	public TowerOfHanoi(int discs , int from , int to , int spare) 
	{		
		this.Play(discs , from , to , spare);
		System.out.printf("Minimum number of movements is %d \n", movesCount);
	}

	private int movesCount = 0; //Minimum number of moves to solve the game.
	
	 
	//The play method which implements the algorithm.	 
	private void Play(int discs , int from , int to , int spare) 
	{
		this.movesCount++; //Increment the number of steps in each recursive call.
		
		if (discs == 1) //Base case for recursion.
		{
			System.out.printf("Move %d from stack %d to stack %d \n", discs, from, to);
			return;
		}
		
		else 
		{
			Play(discs - 1, from, spare, to); 
			System.out.printf("Move %d from stack %d to stack %d \n", discs, from, to);
			Play(discs - 1, spare, to, from);
			return;
		}
	}
}
