/**
 * Implement a queue using a linked list
 * 
 * @author Emma Nguyen
 * @version March 31, 2018
 */
public class QueueLL<T> implements Queue<T> {

	// create a linked list
	private LinkedList<T> list;

	/**
	 * Construct a queue
	 */
	public QueueLL() {

		// initialize the list
		list = new LinkedList<T>();
	}

	/**
	 * Get the first element in the queue
	 */
	@Override
	public T peek() {
		// TODO Auto-generated method stub

		// if the queue is empty, return null
		if (isEmpty())
			return null;

		// return the first element in the list
		return (list.getFirst());
	}

	/**
	 * Get the first element in the queue and delete it
	 */
	@Override
	public T dequeue() {
		// TODO Auto-generated method stub

		// if the queue is empty, return null
		if (isEmpty())
			return null;

		// get the first element
		T elem = list.getFirst();

		// delete it
		list.deleteFirst();

		// return the element
		return elem;
	}

	/**
	 * Insert an element to the end of the queue
	 */
	@Override
	public void enqueue(T data) {
		// TODO Auto-generated method stub

		// insert the element to the end of the list
		list.insertLast(data);
	}

	/**
	 * Check whether the queue is empty
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub

		// return whether the list is empty
		return (list.isEmpty());
	}

	/**
	 * Get a string representation of the queue
	 */
	@Override
	public String toString() {

		// return a string representation of the list
		return (list.toString());
	}

}
