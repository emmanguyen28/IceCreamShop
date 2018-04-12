import javax.swing.JFrame;

/**
 * An application to run a line of orders of ice cream
 * 
 * @author Emma Nguyen
 * @version March 31, 2018
 */
public class IceCreamLineApplication {

	/**
	 * Main method
	 * 
	 * @param args
	 *            runtime-parameters
	 */
	public static void main(String[] args) {

		// create a frame to hold the application
		JFrame frame = new JFrame("Ice Cream Line");

		// set the frame's size
		frame.setSize(450, 600);

		// add an ice cream line controller to the frame
		frame.getContentPane().add(new IceCreamLineManager());

		// set the frame to be visible
		frame.setVisible(true);

		// set the frame's exit operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
