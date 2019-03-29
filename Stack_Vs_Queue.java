
public class Stack_Vs_Queue {


	public static void main(String[] args) {
		

		////////////////////////////////////
		// Test Mazes

		// Generic Maze Test
		char[][] GenericMazeStack = {
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X','.','X','.','.','.','X','.','X','X'},
				{'X','X','X','X','.','X','.','.','X','X'},
				{'X','.','X','X','X','X','.','.','.','X'},
				{'X','.','.','.','.','.','.','X','.','X'},
				{'X','X','X','X','.','X','X','.','.','X'},
				{'X','X','X','.','X','.','.','X','.','X'},
				{'X','.','X','X','X','.','X','X','.','X'},
				{'X','.','.','X','X','.','.','X','X','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};

		char[][] GenericMazeQueue = {
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X','.','X','.','.','.','X','.','X','X'},
				{'X','X','X','X','.','X','.','.','X','X'},
				{'X','.','X','X','X','X','.','.','.','X'},
				{'X','.','.','.','.','.','.','X','.','X'},
				{'X','X','X','X','.','X','X','.','.','X'},
				{'X','X','X','.','X','.','.','X','.','X'},
				{'X','.','X','X','X','.','X','X','.','X'},
				{'X','.','.','X','X','.','.','X','X','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};

		// Test maze 1
		char[][] testMazeStack1 = {
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X','.','.','.','.','.','.','.','.','X'},
				{'X','X','.','X','.','X','X','X','X','X'},
				{'X','.','.','X','.','X','.','.','.','X'},
				{'X','.','.','X','.','.','.','X','.','X'},
				{'X','X','X','X','.','X','X','X','.','X'},
				{'X','.','X','.','.','.','.','X','X','X'},
				{'X','.','.','X','X','.','X','X','.','X'},
				{'X','.','.','.','X','.','.','.','.','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};

		char[][] testMazeQueue1 = {
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X','.','.','.','.','.','.','.','.','X'},
				{'X','X','.','X','.','X','X','X','X','X'},
				{'X','.','.','X','.','X','.','.','.','X'},
				{'X','.','.','X','.','.','.','X','.','X'},
				{'X','X','X','X','.','X','X','X','.','X'},
				{'X','.','X','.','.','.','.','X','X','X'},
				{'X','.','.','X','X','.','X','X','.','X'},
				{'X','.','.','.','X','.','.','.','.','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};

		// Test maze 2
		char[][] testMazeStack2 = {
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X','X','.','.','.','.','.','X','.','X'},
				{'X','X','.','X','X','.','X','X','.','X'},
				{'X','X','.','.','X','.','.','.','.','X'},
				{'X','X','.','X','.','X','X','X','X','X'},
				{'X','X','.','X','.','X','X','X','X','X'},
				{'X','.','.','X','X','.','.','X','.','X'},
				{'X','.','X','X','.','X','.','X','.','X'},
				{'X','.','.','.','.','.','.','.','.','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};

		char[][] testMazeQueue2 = {
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X','X','.','.','.','.','.','X','.','X'},
				{'X','X','.','X','X','.','X','X','.','X'},
				{'X','X','.','.','X','.','.','.','.','X'},
				{'X','X','.','X','.','X','X','X','X','X'},
				{'X','X','.','X','.','X','X','X','X','X'},
				{'X','.','.','X','X','.','.','X','.','X'},
				{'X','.','X','X','.','X','.','X','.','X'},
				{'X','.','.','.','.','.','.','.','.','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};

		// Test maze 3

		char[][] testMazeStack3 = {
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X','X','X','X','X','.','.','X','.','X'},
				{'X','X','X','X','.','X','X','X','X','X'},
				{'X','X','.','.','.','.','.','.','.','X'},
				{'X','.','.','X','X','.','.','X','.','X'},
				{'X','X','.','X','X','.','X','X','.','X'},
				{'X','X','X','X','.','.','.','X','.','X'},
				{'X','.','.','X','.','X','.','X','.','X'},
				{'X','X','.','X','.','.','X','X','X','X'},
				{'X','X','X','X','X','X','X','X','X','X'},
		};

		char[][] testMazeQueue3 = {
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X','X','X','X','X','.','.','X','.','X'},
				{'X','X','X','X','.','X','X','X','X','X'},
				{'X','X','.','.','.','.','.','.','.','X'},
				{'X','.','.','X','X','.','.','X','.','X'},
				{'X','X','.','X','X','.','X','X','.','X'},
				{'X','X','X','X','.','.','.','X','.','X'},
				{'X','.','.','X','.','X','.','X','.','X'},
				{'X','X','.','X','.','.','X','X','X','X'},
				{'X','X','X','X','X','X','X','X','X','X'},
		};

		// Test Maze 4

		char[][] testMazeStack4 = {
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X','X','.','.','.','.','.','X','.','X'},
				{'X','X','.','X','X','.','X','X','.','X'},
				{'X','X','.','.','X','.','.','.','.','X'},
				{'X','X','.','X','.','X','X','X','X','X'},
				{'X','X','.','X','.','X','X','X','X','X'},
				{'X','.','.','X','X','.','.','X','.','X'},
				{'X','.','X','X','.','X','.','X','.','X'},
				{'X','.','.','.','.','.','.','.','.','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};

		char[][] testMazeQueue4 = {
				{'X','X','X','X','X','X','X','X','X','X'},
				{'X','X','.','.','.','.','.','X','.','X'},
				{'X','X','.','X','X','.','X','X','.','X'},
				{'X','X','.','.','X','.','.','.','.','X'},
				{'X','X','.','X','.','X','X','X','X','X'},
				{'X','X','.','X','.','X','X','X','X','X'},
				{'X','.','.','X','X','.','.','X','.','X'},
				{'X','.','X','X','.','X','.','X','.','X'},
				{'X','.','.','.','.','.','.','.','.','X'},
				{'X','X','X','X','X','X','X','X','X','X'}};

		//////////////////////////////////////////////
		// Method Testing							//
		//////////////////////////////////////////////

		///////////////////////////
		// Generic Maze Test Method
		Coord startCoord = new Coord(7,5);
		Coord endCoord = new Coord(1,1);
		System.out.println("////////////////////////////////////////////////////");
		System.out.println("Testing a generic maze where a path does NOT exists:");

		// Stack test
		if (StackMaze.pathExists(GenericMazeStack, startCoord, endCoord) == false) { 
			System.out.println("Your answer is CORRECT");
		}
		else {
			System.out.println("INCORRECT"); 
		}
		if (QueueMaze.pathExists(GenericMazeQueue, startCoord, endCoord) == false) { 
			// Queue test
			System.out.println("Your answer is CORRECT");
		}
		else {
			System.out.println("INCORRECT"); 
		}

		/////////////////////
		// Maze 1 Test Method
		Coord startCoord1 = new Coord(7,8);
		Coord endCoord1 = new Coord(1,8);

		System.out.println("////////////////////////////////////////////////////");

		System.out.println("\nTesting maze 1 where a path exists:");

		/// Stack Test
		if (StackMaze.pathExists(testMazeStack1, startCoord1, endCoord1) == true) {
			System.out.println("Your answer is CORRECT");
		}
		else {
			System.out.println("INCORRECT"); 
		}
		/// Queue Test
		if (QueueMaze.pathExists(testMazeQueue1, startCoord1, endCoord1) == true) { 
			System.out.println("Your answer is CORRECT");
		}
		else {
			System.out.println("INCORRECT"); 
		}

		/////////////////////
		// Maze 2 Test Method		

		Coord startCoord2 = new Coord(7,1);
		Coord endCoord2 = new Coord(6,2);

		System.out.println("////////////////////////////////////////////////////");
		System.out.println("\nTesting maze 2 where a path exists:");

		/// Stack Test
		if (StackMaze.pathExists(testMazeStack2, startCoord2, endCoord2) == true) {
			System.out.println("Your answer is CORRECT");
		}
		else {
			System.out.println("INCORRECT"); 
		}
		/// Queue Test
		if (QueueMaze.pathExists(testMazeQueue2, startCoord2, endCoord2) == true) { 
			System.out.println("Your answer is CORRECT");
		}
		else {
			System.out.println("INCORRECT"); 
		}

		/////////////////////
		// Maze 3 Test Method

		Coord startCoord3 = new Coord(8,4);
		Coord endCoord3 = new Coord(8,2);

		System.out.println("////////////////////////////////////////////////////");
		System.out.println("\nTesting maze 3 where a does NOT exists:");

		//// Stack Test
		if (StackMaze.pathExists(testMazeStack3, startCoord3, endCoord3) == false) {
			System.out.println("Your answer is CORRECT");
		}
		else {
			System.out.println("INCORRECT"); 
		}
		//// Queue Test
		if (QueueMaze.pathExists(testMazeQueue3, startCoord, endCoord3) == false) { 
			System.out.println("Your answer is CORRECT");
		}
		else {
			System.out.println("INCORRECT"); 
		}

		/////////////////////
		// Maze 4 Test Method
		Coord startCoord4 = new Coord(7,8);
		Coord endCoord4 = new Coord(2,8);

		System.out.println("////////////////////////////////////////////////////");
		System.out.println("\nTesting maze 4 where a path exists:");

		/// Stack Test
		if (StackMaze.pathExists(testMazeStack4, startCoord4, endCoord4) == true) {
			System.out.println("Your answer is CORRECT");
		}
		else {
			System.out.println("INCORRECT"); 
		}
		/// Queue Test
		if (QueueMaze.pathExists(testMazeQueue4, startCoord4, endCoord4) == true) { 
			System.out.println("Your answer is CORRECT");
		}
		else {
			System.out.println("INCORRECT"); 
		}
		
		footing();

		//System.out.println(StackMaze.pathExists(testMazeStack1, startCoord1, endCoord1) + "\n-------------end stack------------\n");
		//System.out.println(QueueMaze.pathExists(testMazeQueue1, startCoord1, endCoord1) + "\n-------------end queue------------\n");
		//StackMaze stackMaze = new StackMaze();
		//QueueMaze queueMaze = new QueueMaze();
	}
	
	/***********************************************************************************/
	/*			FUNCTION FOOTING	 	                              */
	/***********************************************************************************/
	public static void footing()
	  {                        // Function footing 
	    System.out.println ();
	    System.out.println ();
	    System.out.println ("END OF OUTPUT");
	    System.out.println ();
	    return;
	  }   // Function footing
	/*********************************************************************************/


}
