// Matthew Korkola

// This class represents a Stack implemented with an array data structure.
// It must work for the generic type T and must implement StackADT<T>.
public class ArrayStack<T> implements StackADT<T> {
	
	// Declare the variables.
	private T[] array;
	private int top;
	
	// Create the first constructor.
	public ArrayStack() {
		// Initialize the array with 10 slots and top = 9.
		array = (T[]) (new Object[10]);
		top = 9;
	}
	
	// Create the second constructor.
	public ArrayStack(int N) {
		// Initialize the array with N slots and top = N - 1, where N is the input parameter.
		array = (T[]) (new Object[N]);
		top = N - 1;
	}
	
	// Method that adds the element in the input parameter to the top of the stack
	public void push(T element) {
		// If the stack is full, add 5 new spaces to the stack and ensure
		// all the elements are stored in the correct slots.
		if (top == 0) {
			expandCapacity();
			top = 5;
		}
		//array[9 - top] = element;
		array[array.length - 1 - top] = element;
		// Update top
		top--;
	}
	
	// Private helper method that adds 5 new spaces to the stack if it is full
	private void expandCapacity() {
		T[] arrayPlusFive = (T[]) (new Object[array.length + 5]);
		
		for (int i = 0; i < array.length; i++) {
			arrayPlusFive[i] = array[i];
		}
		
		array = arrayPlusFive;
	}
	
	// Method that removes and returns the element from the top of the stack
	public T pop() throws StackException {
		// Throw a StackException if the stack is empty.
		if (top == array.length - 1) {
			throw new StackException("Empty Stack");
		}
		// Update top
		top++;
		T itemTop = array[array.length - 1 - top];
		array[array.length - 1 - top] = null;
		return itemTop;
	}
	
	// Method that returns (without removing) the element from the top of the stack
	public T peek() throws StackException {
		// Throw a StackException if the stack is empty.
		if (top == array.length - 1) {
			throw new StackException("Empty Stack");
		}
		return array[array.length - 1 - top - 1];
	}
	
	// Method that returns true if the stack contains 0 elements; otherwise, it returns false
	public boolean isEmpty() {
		return (top == array.length - 1);
	}
	
	// Method that returns the number of elements on the stack
	public int size() {
		return array.length - 1 - top;
	}
	
	// Method that returns the number of slots in the array
	public int getLength() {
		return array.length;
	}
	
	// Method that returns the top index
	public int getTop() {
		return top;
	}
	
	// Method that returns a string representation of the stack
	public String toString() {
		// If the stack if empty, return "The stack is empty.".
		if (top == array.length - 1) {
			return "The stack is empty.";
		}
		
		// The string should start with "Stack: ".
		String returnString = "Stack: ";
		// The string should then contain each of the stack's elements in order
		// from the top (most recent) to the bottom (earliest) with a comma
		// and space between each of the elements.
		for (int i = array.length - 1 - top; i >= 0; i--) {
			// Only add the elements if they are not null.
			if (array[i] != null) {
				returnString = returnString + array[i].toString();
				if (i != 0) {
					returnString = returnString + ", ";
				} else {
					// The last element should end with a period instead.
					returnString = returnString + ".";
				}
			}
		}
			
		
		return returnString;
	}
	
}
