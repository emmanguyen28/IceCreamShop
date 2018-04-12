import javax.swing.Box;
import javax.swing.BoxLayout;

/**
 * Create an ice cream line
 * 
 * @author Emma Nguyen
 * @version March 31, 2018
 */
public class IceCreamLine extends Box {

	/* instance variables */

	// create an order line using queue
	private Queue<IceCreamCone> orderLine;

	// create a line of order view using queue
	private Queue<IceCreamConeView> orderLineView;

	/**
	 * Construct an ice cream line
	 */
	public IceCreamLine() {

		// create a box layout that holds the ice cream orders
		super(BoxLayout.Y_AXIS);

		// initialize an order line
		orderLine = new QueueLL<IceCreamCone>();

		// initialize a view line
		orderLineView = new QueueLL<IceCreamConeView>();

	}

	/**
	 * Add an order to the order line
	 * 
	 * @param cone
	 *            the order to be added
	 */
	public void addOrder(IceCreamCone cone) {

		// set the cone's scale
		cone.setScale(0.7);

		// add the order to the order line queue
		orderLine.enqueue(cone);

		// create the cone's view
		IceCreamConeView view = new IceCreamConeView(cone);

		// add the view of the order to the order view line
		orderLineView.enqueue(view);

		// add the view to the box
		add(view);

		// validate that the view was added
		validate();
		//
		// repaint the display now that there are changes
		repaint();

	}

	/**
	 * Add a random order to the order line
	 */
	public void addRandomOrder() {

		// create a new ice cream cone
		IceCreamCone cone = IceCreamCone.createRandom();

		// add the ice cream
		addOrder(cone);
	}

	/**
	 * Get the next order in the line
	 * 
	 * @return the next order
	 */
	public IceCreamCone getNextOrder() {

		// get the next order in line
		IceCreamCone order = orderLine.dequeue();

		// if there is no order
		if (order == null)

			// return null
			return null;

		// if there is an order
		else {

			// get the order's view
			IceCreamConeView view = orderLineView.dequeue();

			// remove the view
			remove(view);

			// removed the view from the box
			validate();

			// repaint the display
			repaint();

			// return the order
			return order;
		}

	}

	/**
	 * Get the line of orders
	 * 
	 * @return order line
	 */
	public Queue<IceCreamCone> getOrderLine() {

		// return the line
		return orderLine;
	}

}
