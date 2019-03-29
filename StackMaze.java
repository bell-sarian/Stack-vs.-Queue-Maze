
public class StackMaze<T>{

	//static StackMaze<Coord> stackMaze = new StackMaze<Coord>();

	private Coord firstNode; // Reference to first node
	private int numberOfEntries; // Number of entries in Stack

	/** Adds a new entry to this stack.
    @param newCoord, the object to be added as a new entry in the stack.
    @return True. */
	public boolean push(Coord newCoord) // OutOfMemoryError possible
	{
		// Add to stack:
		if (!isEmpty()) {					// if the stack is NOT empty
			newCoord.next = firstNode;	 	// Make new coord reference rest of chain (firstNode is null if chain is empty)
			firstNode = newCoord; 			// New coord is at beginning of chain
			numberOfEntries++;				// Add to number of entries
		} // end if
		else {								// if the stack IS empty
			firstNode = newCoord;			// first coord will be the new coord
			numberOfEntries++;				// add to number of entires
		} // end else
		return true;						// return true


	} // end push()

	/** Removes top entry from this stack, if possible.
    @return Coord that was removed if the removal was successful */
	public Coord pop() {
		Coord r = firstNode;				// creates a new coord out of the top coord on the stack
		if (!isEmpty()) {					// if the stack is not empty
			firstNode = firstNode.next;		// the first node (top node on stack) will equal next, which is null
		} // end if
		numberOfEntries--;					// decrease number of entries
		return r; 							// return r, the coord that was "popped" off
	} // end pop()

	/** Retrievs top item in the stack, but does not remove
    @return Coord at the top of the stack, null if stack is empty*/
	public Coord peek() {
		Coord r = firstNode; // assigns new 
		return r ;
	}

	/** Sees whether this stack is empty.
    @return true if the stack is empty, or false if not */
	public boolean isEmpty() {
		return numberOfEntries == 0; 		// returns true/false if the stack is empty
	} // end isEmpty

	@SuppressWarnings("unused")
	/** Checks if stack is full
    @return True if stack is full, or false otherwise. */
	public boolean isFull() {
		Coord newCoord = new Coord(0,0); 	// creates a new coord
		if (newCoord == null) { 			// if the new coord is null because of an outOfMemory error
			return true; 					// return true, the stack is full
		}
		return false; 						// else, return false, the stack is not full
	}

	/** Checks if a path exists in a given map from a starting coordinate to an ending coordinate
    @param char[][] maze, starting Coord, and ending Coord
    @return True if there is a path, or false otherwise. */
	public static boolean pathExists(char[][] maze, Coord start, Coord end) {
		StackMaze<Coord> stackMaze = new StackMaze<Coord>(); // create stack for passed in maze
		stackMaze.push(start); // add starting coordinate to stack
		int numVisited = 1;
		
		// DEBUG
		//		for (char[] i : maze) {
		//			System.out.println(i);
		//		} 
		// END DEBUG

		maze[start.getRow()][start.getCol()] = '-'; // set starting coordinate position on map to new char '-'

		while (!stackMaze.isEmpty()) { 				// While the stack for the given maze is not empty
			Coord current = stackMaze.pop(); // take the coord at the top of the stack

			// DEBUG
//			System.out.println(current.getRow() + ", " +current.getCol());
//			for (char[] i : maze) {
//				System.out.println(i);
//			}
			// DEBUG END

			if (current.getRow() == end.getRow() && current.getCol() == end.getCol()) { // if the start coordinate = the end coordinate
				//System.out.println(current.getRow() + ", " +current.getCol());
				System.out.println("");
				for (char[] i : maze) {
					System.out.println(i);
				}
				System.out.println("Cells visited STACK: " + numVisited +"\n\n");
				return true; // return true, a path exists			
			} // end if
			else {
				// If you can move NORTH and haven't encountered that cell yet
				if (maze[current.getRow()-1][current.getCol()] != '-' &&  maze[current.getRow()-1][current.getCol()] != 'X') 
				{
					Coord nextCoord = new Coord(current.getRow()-1, current.getCol());
					stackMaze.push(nextCoord); // push the coordinate nextCoord onto the stack
					maze[current.getRow()-1][current.getCol()] = '-'; // update maze[row-1][ col] to indicate the algorithm has encountered it.
					numVisited++;
				} // end if
				
				// If you can move EAST and haven't encountered that cell yet
				if (maze[current.getRow()][current.getCol()+1] != '-' && maze[current.getRow()][current.getCol()+1] != 'X') 
				{
					Coord nextCoord = new Coord(current.getRow(), current.getCol()+1);
					stackMaze.push(nextCoord); // push the coordinate nextCoord onto the stack
					maze[current.getRow()][current.getCol()+1] = '-'; // update maze[row-1][ col] to indicate the algorithm has encountered it.
					numVisited++;
				} // end if
				
				// If you can move SOUTH and haven't encountered that cell yet
				if (maze[current.getRow()+1][current.getCol()] != '-' && maze[current.getRow()+1][current.getCol()] != 'X')
				{
					Coord nextCoord = new Coord(current.getRow()+1, current.getCol());
					stackMaze.push(nextCoord); // push the coordinate nextCoord onto the stack
					maze[current.getRow()+1][current.getCol()] = '-'; // update maze[row-1][ col] to indicate the algorithm has encountered it.
					numVisited++;
				}// end if
				
				// If you can move WEST and haven't encountered that cell yet
				if (maze[current.getRow()][current.getCol()-1] != '-' && maze[current.getRow()][current.getCol()-1] != 'X') 
				{
					Coord nextCoord = new Coord(current.getRow(), current.getCol()-1);
					stackMaze.push(nextCoord); // push the coordinate nextCoord onto the stack
					maze[current.getRow()][current.getCol()-1] = '-'; // update maze[row-1][ col] to indicate the algorithm has encountered it.
					numVisited++;
				} // end if
				
				
			} // end else
		} // end while
		return false; // return false if no path exists
	} // end pathExists


}
