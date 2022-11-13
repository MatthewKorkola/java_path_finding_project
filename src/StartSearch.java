import java.io.FileNotFoundException;
import java.io.IOException;

// Matthew Korkola

// This class is the heart of the program which contains the algorithm
// that performs a search on a given map file.
// This program must use an ArrayStack to keep track of the MapCells
// that have been visited or attempted to be visited.
public class StartSearch {
	
	// Declare the instance variable.
	private Map map;
	
	// Create the constructor.
	public StartSearch(String fileMap) throws FileNotFoundException, IOException {
		try {
			map = new Map(fileMap);
		}
		catch (InvalidMapException e) {System.out.println("Error");}
		catch (FileNotFoundException e) {System.out.println("Error");}
		catch (IOException e) {System.out.println("Error");}
	}
	
	// Method that determines the best (unmarked) cell from the
	// current cell to continue the path by following the rules
	public MapCell bestCell (MapCell cellMap) {
		// The parameter, cellMap, is the current cell.
		
		// Create four variable designed to determine
		// which direction is the best.
		int northBest = 0;
		int eastBest = 0;
		int southBest = 0;
		int westBest = 0;
		
		// Include try-catch statements that handle an InvalidNeighbourIndexException
		// that could be thrown from the getNeighbour() method.
		try {
			
			// Only consider unmarked cells.
			// The priority order goes as follows: destination cell, donut cell, cross path cell,
			// and horizontal or vertical cell.
			// If the current cell is orthogonally adjacent to a Covid cell, null is
			// immediately returned.
			
			// If the current cell is a horizontal cell, the path can only continue
			// in the east and west directions.
			// If the current cell is a vertical cell, the path can only continue
			// in the north and south directions.
			
			// If the current cell is a cross path cell or a donut cell, watch out for
			// potential illegal movement into horizontal cells or vertical cells.
			
			// Check the neighbour cell to the north (index 0).
			if (!cellMap.isHorizontalPath()) {
				if (cellMap.getNeighbour(0) != null) {
					if (cellMap.getNeighbour(0).isCovid()) {
						return null;
					}
					else if (cellMap.getNeighbour(0).isExit() && !cellMap.getNeighbour(0).isMarked()) {
						northBest = 4;
					}
					
					else if (cellMap.getNeighbour(0).isDonut() && !cellMap.getNeighbour(0).isMarked()) {
						northBest = 3;
					}
					
					else if (cellMap.getNeighbour(0).isCrossPath() && !cellMap.getNeighbour(0).isMarked()) {
						northBest = 2;
					}
					
					else if (cellMap.getNeighbour(0).isHorizontalPath() && !cellMap.getNeighbour(0).isMarked() && !cellMap.isCrossPath() && !cellMap.isDonut()) {
						northBest = 1;
					}
					
					else if (cellMap.getNeighbour(0).isVerticalPath() && !cellMap.getNeighbour(0).isMarked()) {
						northBest = 1;
					}
					else {
						// The neighbour to the north is not a valid option.
					}
				}
			}
			
			
			// Check the neighbour cell to the east (index 1).
			if (!cellMap.isVerticalPath()) {
				if (cellMap.getNeighbour(1) != null) {
					if (cellMap.getNeighbour(1).isCovid()) {
						return null;
					}
					else if (cellMap.getNeighbour(1).isExit() && !cellMap.getNeighbour(1).isMarked()) {
						eastBest = 4;
					}
					
					else if (cellMap.getNeighbour(1).isDonut() && !cellMap.getNeighbour(1).isMarked()) {
						eastBest = 3;
					}
					
					else if (cellMap.getNeighbour(1).isCrossPath() && !cellMap.getNeighbour(1).isMarked()) {
						eastBest = 2;
					}
					
					else if (cellMap.getNeighbour(1).isHorizontalPath() && !cellMap.getNeighbour(1).isMarked()) {
						eastBest = 1;
					}
					
					else if (cellMap.getNeighbour(1).isVerticalPath() && !cellMap.getNeighbour(1).isMarked() && !cellMap.isCrossPath() && !cellMap.isDonut()) {
						eastBest = 1;
					}
					else {
						// The neighbour to the east is not a valid option.
					}
				}
			}
			
			
			// Check the neighbour cell to the south (index 2).
			if (!cellMap.isHorizontalPath()) {
				if (cellMap.getNeighbour(2) != null) {
					if (cellMap.getNeighbour(2).isCovid()) {
						return null;
					}
					else if (cellMap.getNeighbour(2).isExit() && !cellMap.getNeighbour(2).isMarked()) {
						southBest = 4;
					}
					
					else if (cellMap.getNeighbour(2).isDonut() && !cellMap.getNeighbour(2).isMarked()) {
						southBest = 3;
					}
					
					else if (cellMap.getNeighbour(2).isCrossPath() && !cellMap.getNeighbour(2).isMarked()) {
						southBest = 2;
					}
					
					else if (cellMap.getNeighbour(2).isHorizontalPath() && !cellMap.getNeighbour(2).isMarked() && !cellMap.isCrossPath() && !cellMap.isDonut()) {
						southBest = 1;
					}
					
					else if (cellMap.getNeighbour(2).isVerticalPath() && !cellMap.getNeighbour(2).isMarked()) {
						southBest = 1;
					}
					else {
						// The neighbour to the south is not a valid option.
					}
				}
			}
			
			
			
			// Check the neighbour cell to the west (index 3).
			if (!cellMap.isVerticalPath()) {
				if (cellMap.getNeighbour(3) != null) {
					if (cellMap.getNeighbour(3).isCovid()) {
						return null;
					}
					else if (cellMap.getNeighbour(3).isExit() && !cellMap.getNeighbour(3).isMarked()) {
						westBest = 4;
					}
					
					else if (cellMap.getNeighbour(3).isDonut() && !cellMap.getNeighbour(3).isMarked()) {
						westBest = 3;
					}
					
					else if (cellMap.getNeighbour(3).isCrossPath() && !cellMap.getNeighbour(3).isMarked()) {
						westBest = 2;
					}
					
					else if (cellMap.getNeighbour(3).isHorizontalPath() && !cellMap.getNeighbour(3).isMarked()) {
						westBest = 1;
					}
					
					else if (cellMap.getNeighbour(3).isVerticalPath() && !cellMap.getNeighbour(3).isMarked() && !cellMap.isCrossPath() && !cellMap.isDonut()) {
						westBest = 1;
					}
					else {
						// The neighbour to the west is not a valid option.
					}
				}
			}
			
			
			
		}
		catch (InvalidNeighbourIndexException e) {System.out.println("Error");}
		
		// Determine whether to return the north neighbour, the east neighbour, the
		// south neighbour, the west neighbour, or null.
		
		MapCell north = cellMap.getNeighbour(0);
		MapCell east = cellMap.getNeighbour(1);
		MapCell south = cellMap.getNeighbour(2);
		MapCell west = cellMap.getNeighbour(3);
		MapCell direction = null;
		
		if (northBest == 0 && eastBest == 0 && southBest == 0 && westBest == 0) {
			// None of the neighbours are valid options.
			return null;
		}
					
		// If any values tie, prioritize north, then east, then south, then west.
		// North outweighs east, south, and west in a possible tie.
		// East outweighs south and west in a possible tie.
		// South only outweighs west in a possible tie.
		// West outweighs nothing in a possible tie.
		
					
		else if (northBest >= eastBest && northBest >= southBest && northBest >= westBest) {
			// North is the best direction.
			//return cellMap.getNeighbour(0);
			direction = north;
		}
					
		else if (eastBest > northBest && eastBest >= southBest && eastBest >= westBest) {
			// East is the best direction.
			//return cellMap.getNeighbour(1);
			direction = east;
		}
					
		else if (southBest > northBest && southBest > eastBest && southBest >= westBest) {
			// South is the best direction.
			//return cellMap.getNeighbour(2);
			direction = south;
		}
					
					
		else if (westBest > northBest && westBest > eastBest && westBest > southBest) {
			// West is the best direction.
			//return cellMap.getNeighbour(3);
			direction = west;
		}
		
		return direction;
		
	}
	
	
	// Method that runs the algorithm that searches for a valid path from the start point (yellow house)
	// to the destination (Middlesex College) while following all the rules and restrictions
	// This method makes use of the bestCell() method.
	// It returns the string of actions that contains the entire sequence of visited cells
	// separated with hyphens and suffixed with the energy level.
	public String findPath() {
		
		// A stack will keep track of which cells are in the path, and it cannot be recursive.
		// Create and initialize a stack.
		ArrayStack<MapCell> pathStack = new ArrayStack<MapCell>();
		
		// Create an actionString variable.
		String actionString = "";
		
		// Create a status flag to indicate whether or not the destination has been found.
		boolean destinationFlag = false;
		
		// Get the start cell using the methods of the supplied class Map.
		MapCell startCell = map.getStart();
		 
		// Push the starting cell into the stack and mark the cell as inStack
		// (use methods of the class MapCell to mark a cell).
		pathStack.push(startCell);
		startCell.markInStack();
		
		// Create a variable for the energy level and set it to 10 at the start.
		int energyLevel = 10;
		
		// While the stack is not empty and the destination has not been reached, perform
		// the following steps:
		while (!pathStack.isEmpty() && !destinationFlag) {
			
			// Peek at the top of the stack to get the current cell.
			MapCell current = pathStack.peek();
			
			// Find the next unmarked neighbouring cell.
			MapCell next = bestCell(pathStack.peek());
			
			// Update the actionString to contain the cell being visited.
			// Include a hyphen between each pair of cell IDs.
			
			actionString = actionString + current.toString() + "-";
			
			// If such a next cell exists and the energy level is above 0:
			if (next != null && energyLevel > 0) {
				// Check if the next cell is the destination.
				// If so, set the status flag to true.
				if (next.isExit()) {
					destinationFlag = true;
				}
				else if (next.isDonut()) {
					energyLevel += 3;
				}
				
				// Push the neighbouring cell into the stack and mark it as inStack.
				pathStack.push(next);
				next.markInStack();
				
				// Decrease the energy level by 1 because of this single movement.
				energyLevel -= 1;
			}
			
			// Otherwise, since there are no unmarked neighbouring cells that can be added
			// to the path, perform the following steps:
			else {
				// Pop the top cell from the stack and mark it as out of stack.
				MapCell temp = pathStack.pop();
				temp.markOutStack();
				
				// If that top cell is a donut cell, decrease the energy level by 3 (because
				// we are undoing a donut consumption).
				if (temp.isDonut()) {
					energyLevel -= 3;
				}
				
				// If that top cell is anything other than the start point, increase the energy
				// level by 1 (because we are undoing a single movement).
				if (!temp.isStart()) {
					energyLevel += 1;
				}
			}
			
		}
		
		// While the stack is not empty, perform the following:
		while (!pathStack.isEmpty()) {
			// Pop the top cell from the stack and mark it as out of stack.
			pathStack.pop().markOutStack();
		}
		
		// Return the actionString that contains a sequence of all the cells
		// that were visited, even if they ended up being backtracked.
		// Append the energy level at the end of the string in the format "E#" where # is
		// the energy level after finishing the path finding algorithm.
		/*
		if (energyLevel < 0) {
			energyLevel = 0;
		}
		*/
		actionString = actionString + "E" + energyLevel;
		return actionString;
		
		
	}
	
	// Method that starts the program
	public static void main (String[] args) throws FileNotFoundException, IOException {
		// If one argument is given, use it to initialize a StartSearch object with that
		// map name. Call the findPath method on the StartSearch object.
		if (args.length < 1) {
			System.out.println("You must provide the name of the input file");
		}
		try {
			String mapFile = args[0];
			StartSearch ss = new StartSearch(mapFile);
			ss.findPath();
		}
		catch (FileNotFoundException e) {System.out.println("Error");}
		catch (IOException e) {System.out.println("Error");}
	}
}
