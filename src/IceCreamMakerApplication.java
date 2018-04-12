import javax.swing.JFrame;

/**
 * An application to make ice cream
 * 
 * @author Emma Nguyen
 * @version March 29, 2018
 */
public class IceCreamMakerApplication {

	/**
	 * Main method
	 * 
	 * @param args
	 *            runtime-parameters
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create a frame holding the application
		JFrame frame = new JFrame("Ice Cream Maker");

		// set the frame size
		frame.setSize(465, 600);

		// add an ice cream maker to the frame
		frame.getContentPane().add(new IceCreamMaker());

		// set frame to be visible
		frame.setVisible(true);

		// set frame's exit operation
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
