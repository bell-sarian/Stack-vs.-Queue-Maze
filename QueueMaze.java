

public class QueueMaze<T> {

	//static QueueMaze stackMaze = new QueueMaze();

	private Coord front; // Reference to first node
	private Coord back; // reference to last node
	private int numberOfEntries; // number of entries in queue

	/** Adds a new entry to the back of the queue.
    @param newCoord, the object to be added as a new entry in the queue.
    @return True. */
	public boolean enqueue(Coord newCoord) // OutOfMemoryError possible
	{
		// Add to stack:
		if (isEmpty()) {			// if the stack is empty
			back = newCoord;		// the back of the queue = the new coordinate
			front = newCoord;		// the front of the queue = the new coordinate 
			numberOfEntries++;		// increase the number of entires
		} // end if
		else {
			back.next = newCoord;	 	// Make new coord reference rest of chain (firstNode is null if chain is empty)
			back = newCoord;			// New coord is at beginning of chain
			numberOfEntries++;			// add to number of entires
		} // end else
		return true;

	}

	/** Removes front entry from this queue, if possible.
    @return Coord that was removed if the removal was successful */
	public Coord dequeue() {
		Coord r = front;			// creates a new coord out of the front of the queue
		if (!isEmpty()) { 			// if the queue is not empty
			front = front.next;		// the first node (front of queue) will equal the new coord
		} // end if
		
		numberOfEntries--;			// decrease number of entires
		return r;					// return the coord that was removed
	}

	/** Retrievs front item in the queue, but does not remove
    @return Coord at the front of the queue, null if queue is empty*/
	public Coord peek() {
		Coord r = front;
		return r ;
	}

	/** Sees whether this queue is empty.
    @return true if the queue is empty, or false if not */
	public boolean isEmpty() {
		return numberOfEntries == 0;
	} // end isEmpty


	@SuppressWarnings("unused")
	/** Checks if queue is full
    @return True if queue is full, or false otherwise. */
	public boolean isFull() {
		Coord newCoord = new Coord(0,0);
		if (newCoord == null) {
			return true;
		}
		return false;
	}

	/** Checks if a path exists in a given map from a starting coordinate to an ending coordinate
    @param char[][] maze, starting Coord, and ending Coord
    @return True if there is a path, or false otherwise. */
	public static boolean pathExists(char[][] maze, Coord start, Coord end) {
		QueueMaze<Coord> queueMaze = new QueueMaze<Coord>(); // Create queue for passed in maze
		queueMaze.enqueue(start); // add starting coordinate to queue
		int numVisited = 1;

		// DEBUG
		//		for (char[] i : maze) {
		//			System.out.println(i);
		//		} 
		// END DEBUG

		maze[start.getRow()][start.getCol()] = '-'; // set starting coordinate position on map to new char '-'

		while (!queueMaze.isEmpty()) { // While the queue for the given maze is not empty
			Coord current = queueMaze.dequeue(); // take the coord at the front of the queue

			// DEBUG
//			System.out.println(current.getRow() + ", " + current.getCol());
//			for (char[] i : maze) {
//				System.out.println(i);
//			}
			// DEBUG END

			if (current.getRow() == end.getRow() && current.getCol() == end.getCol()) { // if the start coordinate = the end coordinate
				//System.out.println(current.getRow() + ", " +current.getCol());
				for (char[] i : maze) {
					System.out.println(i);
				}
				System.out.println("Cells visited QUEUE: " + numVisited+"\n\n");
				return true; // return true, a path exists	
			} // end if
			else {
				// If you can move NORTH and haven't encountered that cell yet
				if (maze[current.getRow()-1][current.getCol()] != '-' &&  maze[current.getRow()-1][current.getCol()] != 'X') 
				{
					Coord nextCoord = new Coord(current.getRow()-1, current.getCol());
					queueMaze.enqueue(nextCoord); // enqueue the coordinate nextCoord onto the queue
					maze[current.getRow()-1][current.getCol()] = '-'; // update maze[row-1][ col] to indicate the algorithm has encountered it.
					numVisited++;
				} // end if

				// If you can move EAST and haven't encountered that cell yet
				if (maze[current.getRow()][current.getCol()+1] != '-' && maze[current.getRow()][current.getCol()+1] != 'X') 
				{
					Coord nextCoord = new Coord(current.getRow(), current.getCol()+1);
					queueMaze.enqueue(nextCoord); // enqueue the coordinate nextCoord onto the queue
					maze[current.getRow()][current.getCol()+1] = '-'; // update maze[row][col+1] to indicate the algorithm has encountered it.
					numVisited++;
				} // end if

				// If you can move SOUTH and haven't encountered that cell yet
				if (maze[current.getRow()+1][current.getCol()] != '-' && maze[current.getRow()+1][current.getCol()] != 'X')
				{
					Coord nextCoord = new Coord(current.getRow()+1, current.getCol());
					queueMaze.enqueue(nextCoord); // enqueue the coordinate nextCoord onto the queue
					maze[current.getRow()+1][current.getCol()] = '-'; // update maze[row+1][ col] to indicate the algorithm has encountered it.
					numVisited++;
				}// end if

				// If you can move WEST and haven't encountered that cell yet
				if (maze[current.getRow()][current.getCol()-1] != '-' && maze[current.getRow()][current.getCol()-1] != 'X') 
				{
					Coord nextCoord = new Coord(current.getRow(), current.getCol()-1);
					queueMaze.enqueue(nextCoord); // enqueue the coordinate nextCoord onto the queue
					maze[current.getRow()][current.getCol()-1] = '-'; // update maze[row][ col-1] to indicate the algorithm has encountered it.
					numVisited++;
				} // end if
			} // end else
		} // end while

		return false; // return false if there is no path
	} // end pathExists



}
