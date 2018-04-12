import javax.swing.JFrame;

/**
 * Application to run the ice cream shop
 * 
 * @author Emma Nguyen
 * @version April 1, 2018
 */
public class IceCreamShopApplication {

	/**
	 * Main method
	 * 
	 * @param args
	 *            runtime-parameters
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create a frame
		JFrame frame = new JFrame("Emma's Ice Cream Shop");

		// set the frame's size
		frame.setSize(950, 700);

		// add an ice cream shop to the frame
		frame.getContentPane().add(new TimedIceCreamShop());

		// set the frame to be visible
		frame.setVisible(true);

		// set the frame's operation on close
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
