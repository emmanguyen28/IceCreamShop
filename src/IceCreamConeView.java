import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

/**
 * Create the view for the ice cream maker
 * 
 * @author Emma Nguyen
 * @version March 28, 2018
 */
public class IceCreamConeView extends JComponent {

	// the colors of the ice cream scoops
	public static final Color[] SCOOP_COLORS = { new Color(243, 229, 171), new Color(123, 63, 0), new Color(210, 14, 7),
			new Color(255, 130, 67), new Color(255, 229, 180) };

	// width of the cone
	public static double CONE_WIDTH = 50;

	// height of the cone
	public static double CONE_HEIGHT = 100;

	// diameter of the scoop
	public static double SCOOP_DIAMETER = 70;

	// overlap area between scoops
	public static double SCOOP_OVERLAP = 20;

	// an ice cream cone
	private IceCreamCone cone;

	/**
	 * Construct an ice cream cone view
	 * 
	 * @param cone
	 *            an ice cream cone
	 */
	public IceCreamConeView(IceCreamCone cone) {

		// set the cone
		this.cone = cone;

		// repaint
		repaint();
	}

	/**
	 * Paint the view
	 */
	public void paint(Graphics g) {

		// paint the cone
		paintCone(g);

		// paint the ice cream scoops
		paintScoops(g);
	}

	/**
	 * Paint the cone
	 * 
	 * @param g
	 *            a graphics object to draw on
	 */
	private void paintCone(Graphics g) {

		// set the cone's color
		g.setColor(new Color(244, 212, 135));

		// array of x-coordinates to draw the cone
		int[] x = { (int) (getWidth() / 2 - (CONE_WIDTH * cone.getScale()) / 2),
				(int) (getWidth() / 2 + (CONE_WIDTH * cone.getScale()) / 2), getWidth() / 2 };

		// array of y-coordinates to draw the cone
		int[] y = { (int) (getHeight() - (CONE_HEIGHT * cone.getScale())),
				(int) (getHeight() - (CONE_HEIGHT * cone.getScale())), (getHeight()) };

		// draw the cone
		g.fillPolygon(x, y, 3);
	}

	/**
	 * Draw a single scoop
	 * 
	 * @param g
	 *            a graphics object to draw on
	 * @param flavor
	 *            the scoop flavor to draw
	 * @param x
	 *            the x-coordinate to draw the scoop
	 * @param y
	 *            the y-coordinate to draw the scoop
	 */
	private void paintScoop(Graphics g, String flavor, int x, int y) {

		// draw the scoop
		g.fillOval(x, y, (int) (SCOOP_DIAMETER * cone.getScale()), (int) (SCOOP_DIAMETER * cone.getScale()));
	}

	/**
	 * Draw the scoops (use a temporary stack to paint, as the order should be
	 * reverse from what is in the stack)
	 * 
	 * @param g
	 *            a graphics object to draw on
	 * @param x
	 *            the x-coordinate of the scoops
	 * @param y
	 *            the y-coordinate of the scoops
	 */
	private void paintScoops(Graphics g) {

		// get the stack of flavors
		StackLL<String> flavors = cone.getScoopFlavors();

		// create a temporary stack to hold the flavors in reverse order (for drawing
		// purposes)
		StackLL<String> temp = new StackLL<String>();

		// traverse the original stack
		while (!flavors.isEmpty()) {

			// push the flavors from the original stack into the temp stack
			temp.push(flavors.pop());
		}

		// y coordinate of a scoop
		int y = (int) (getHeight() - (CONE_HEIGHT * cone.getScale()) + (SCOOP_OVERLAP * cone.getScale())
				- (SCOOP_DIAMETER * cone.getScale()));

		// draw the stack of scoops
		while (!temp.isEmpty()) {

			// get the top scoop
			String flavor = temp.pop();

			// if there is a flavor in the stack
			if (flavor != null) {

				// push the scoop back to the original stack
				flavors.push(flavor);

				// set the scoop's color
				g.setColor(getScoopColor(flavor));

				// paint the scoop
				paintScoop(g, flavor, (int) (getWidth() / 2 - (SCOOP_DIAMETER * cone.getScale()) / 2), y);

				// update the y coordinate for each scoop
				y = (int) (y + (SCOOP_OVERLAP * cone.getScale()) - (SCOOP_DIAMETER * cone.getScale()));
			}
		}
	}

	/**
	 * Get the scoop color
	 * 
	 * @param flavor
	 *            the flavor of the scoop
	 * @return the color of the scoop based on the flavor
	 */
	private Color getScoopColor(String flavor) {

		// get the color of each scoop based on flavor and return the color

		if (flavor.equals(IceCreamCone.FLAVORS[0]))
			return SCOOP_COLORS[0];

		else if (flavor.equals(IceCreamCone.FLAVORS[1]))
			return SCOOP_COLORS[1];

		else if (flavor.equals(IceCreamCone.FLAVORS[2]))
			return SCOOP_COLORS[2];

		else if (flavor.equals(IceCreamCone.FLAVORS[3]))
			return SCOOP_COLORS[3];

		else
			return SCOOP_COLORS[4];
	}
}
