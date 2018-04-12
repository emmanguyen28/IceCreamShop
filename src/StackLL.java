/**
 * Define a stack using a linked list
 * 
 * @author Emma Nguyen
 * @version March 27, 2018
 */
public class StackLL<T> implements Stack<T> {

	// create a stack represented by a linked list
	private LinkedList<T> stack;

	/**
	 * Construct a stack
	 */
	public StackLL() {

		// initiate a stack with a linked list
		stack = new LinkedList<T>();
	}

	/**
	 * Push an element onto the stack
	 */
	@Override
	public void push(T data) {
		// TODO Auto-generated method stub

		// insert the element into the list
		stack.insertFirst(data);
	}

	/**
	 * Remove the top element of the stack and return the element
	 */
	@Override
	public T pop() {
		// TODO Auto-generated method stub

		// if the stack is empty, return null
		if (isEmpty())
			return null;

		// get the element at the top
		T element = stack.getFirst();

		// remove it
		stack.deleteFirst();

		// return the element
		return element;
	}

	/**
	 * Get the top element of the stack
	 */
	@Override
	public T peek() {
		// TODO Auto-generated method stub

		// if the stack is empty, return null
		if (isEmpty())
			return null;

		// return the list's top element
		return (stack.getFirst());
	}

	/**
	 * Check whether the stack is empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub

		// return whether the list is empty
		return (stack.isEmpty());
	}

	/**
	 * Get a string representation of the stack
	 */
	@Override
	public String toString() {

		// return a string representation of the list
		return (stack.toString());
	}

}
