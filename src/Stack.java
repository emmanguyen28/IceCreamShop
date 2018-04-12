/**
 * The stack ADT interface
 * 
 * @author Emma Nguyen
 * @version March 27, 2018
 */
public interface Stack<T> {

	/**
	 * Push an element to the stack
	 * 
	 * @param data
	 *            the element to be pushed
	 */
	public void push(T data);

	/**
	 * Pop an element from the stack (remove from the top and return it)
	 * 
	 * @return the top element of the stack
	 */
	public T pop();

	/**
	 * Get the element at the top of the stack without removing it
	 * 
	 * @return the top element of the stack
	 */
	public T peek();

	/**
	 * Check if the stack is empty
	 * 
	 * @return true if the stack is empty; false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Return a string representation of the stack elements
	 * 
	 * @return the stack as a string
	 */
	public String toString();
}
