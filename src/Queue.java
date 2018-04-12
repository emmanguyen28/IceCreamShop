/**
 * The queue interface
 * 
 * @author Emma Nguyen
 * @version March 31, 2018
 */
public interface Queue<T> {

	/**
	 * Get the front element in the queue
	 * 
	 * @return the first element
	 */
	public T peek();

	/**
	 * Delete the front element in the queue and return it
	 * 
	 * @return the front element in the queue
	 */
	public T dequeue();

	/**
	 * Insert an element to the end of the queue
	 * 
	 * @param data
	 *            element to be inserted
	 */
	public void enqueue(T data);

	/**
	 * Check whether the queue is empty
	 * 
	 * @return true if the queue is empty; false otherwise
	 */
	public boolean isEmpty();

	/**
	 * Get a string representation of the queue
	 * 
	 * @return the queue as a string
	 */
	public String toString();
}
