/**
 * Create an ice cream cone
 * 
 * @author Emma Nguyen
 * @version March 28, 2018
 */
public class IceCreamCone {

	/* ice cream flavors */
	public static final String[] FLAVORS = { "Vanilla", "Chocolate", "Strawberry", "Mango", "Peach" };

	/* a max number of random scoops in an ice cream */
	public static final int RANDOM_MAX_SCOOPS = 4;

	/* instance variables */

	// a stack of scoop flavors
	private StackLL<String> scoopFlavor;

	// scale of the ice cream
	private double scale;

	/**
	 * Create an ice cream cone
	 */
	public IceCreamCone() {

		// initialize the stack holding the scoop flavors
		scoopFlavor = new StackLL<String>();

		// set the scale;
		scale = 1;
	}

	/**
	 * Get the stack holding the scoop flavors
	 * 
	 * @return the scoop stack
	 */
	public StackLL<String> getScoopFlavors() {

		// return the stack
		return scoopFlavor;
	}

	/**
	 * Add a scoop to the ice cream cone
	 * 
	 * @param flavor
	 *            the flavor to be added
	 */
	public void addScoop(String flavor) {

		// push the flavor on to the stack
		scoopFlavor.push(flavor);
	}

	/**
	 * Add a random scoop to the ice cream cone
	 */
	public void addScoop() {

		// get a random number
		double random = (Math.random() * 5);

		// add a scoop to the cone based on the random number

		if (random < 1)
			scoopFlavor.push(FLAVORS[0]);

		else if (random < 2)
			scoopFlavor.push(FLAVORS[1]);

		else if (random < 3)
			scoopFlavor.push(FLAVORS[2]);

		else if (random < 4)
			scoopFlavor.push(FLAVORS[3]);

		else
			scoopFlavor.push(FLAVORS[4]);
	}

	/**
	 * Check whether the cone still has a scoop
	 * 
	 * @return true if the cone still has a scoop; false otherwise
	 */
	public boolean hasScoop() {

		// return whether the stack has any more flavors
		return (!scoopFlavor.isEmpty());
	}

	/**
	 * Get the top scoop of the cone
	 * 
	 * @return the top scoop
	 */
	public String popTopScoop() {

		// return the top scoop
		return (scoopFlavor.pop());
	}

	/**
	 * Set the cone's scale
	 * 
	 * @param s
	 *            the scale to be set
	 */
	public void setScale(double s) {

		// set the scale
		this.scale = s;
	}

	/**
	 * Get the scale of the cone
	 * 
	 * @return the cone's scale
	 */
	public double getScale() {

		// return the scale
		return scale;
	}

	/**
	 * Create an ice cream cone with random flavors
	 * 
	 * @return an ice cream cone
	 */
	public static IceCreamCone createRandom() {

		// create an ice cream cone
		IceCreamCone random = new IceCreamCone();

		// number of scoops of the cone
		int numScoops = 0;

		// until the number of scoops is larger than 0
		while (numScoops == 0) {

			// create a random number of scoops
			numScoops = (int) (Math.random() * RANDOM_MAX_SCOOPS);
		}

		// add random scoops to the cone
		for (int i = 0; i < numScoops; i++) {
			random.addScoop();
		}

		// return the cone
		return random;
	}

}
