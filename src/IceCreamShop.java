import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Build an ice cream shop
 * 
 * @author Emma Nguyen
 * @version April 1, 2018
 */
public class IceCreamShop extends JPanel implements ActionListener {

	/* default score earned with every correct order */
	public static final int CORRECT_MATCH_SCORE = 10;

	/* default score subtracted with every incorrect order */
	public static final int INCORRECT_MATCH_SCORE = 5;

	/* instance variables */

	// create a line of orders
	protected IceCreamLineManager line;

	// create an ice cream maker
	protected IceCreamMaker maker;

	// score of the player
	protected int score;

	// a label that holds the score
	private JLabel scoreLabel;

	// a panel that holds the statistics (score, time left, level)
	protected JPanel statPanel;

	// the button serve
	protected JButton serve;

	/**
	 * Construct an ice cream shop
	 */
	public IceCreamShop() {

		// initiate a line
		line = new IceCreamLineManager();

		// initiate an ice cream maker
		maker = new IceCreamMaker();

		// initialize the score
		score = 0;

		// create the GUI
		createGUI();

		// refresh display
		repaint();

	}

	/**
	 * Create the display of the game
	 */
	private void createGUI() {

		// set the overall layout
		setLayout(new BorderLayout());

		// add the top panel to the north side of the layout
		add(createTopPanel(), BorderLayout.NORTH);

		// add the panel to the west side of the layout
		add(line, BorderLayout.WEST);

		// add the ice cream maker to the center of the layout
		add(maker, BorderLayout.CENTER);
	}

	/**
	 * Create the panel that holds the elements at the top of the display
	 * 
	 * @return the panel
	 */
	private JPanel createTopPanel() {

		// create a panel in grid layout
		JPanel topPanel = new JPanel(new GridLayout(2, 2));

		// create the welcome label
		JLabel welcome = new JLabel();

		// set the welcome text
		welcome.setText("<html><big><strong><em>Welcome to Emma's Ice Cream Shop!</em></strong></big></html>");

		// add the label to the top panel
		topPanel.add(welcome);

		// add the label to the panel
		topPanel.add(createStatisticsPanel());

		// create the label for instructions of playing the game
		JLabel instructions = new JLabel();

		// set the instructions' text
		instructions.setText(
				"<html>  Make ice cream cones to match the next order.<br/>  Correct cone you make, 10 points you earn.<br/>  Wrong cone, ah hah, 5 points you lose.</html>");

		// add the instructions to the top panel
		topPanel.add(instructions);

		// create the serve button
		serve = new JButton("Serve the order");

		// set the button's action command
		serve.setActionCommand("serve");

		// add action listener to the button
		serve.addActionListener(this);

		// add the button to the top panel
		topPanel.add(serve);

		// return the panel
		return topPanel;

	}

	/**
	 * Create a panel that holds the statistics of the game (score, time left,
	 * level)
	 * 
	 * @return a statistics panel
	 */
	private JPanel createStatisticsPanel() {

		// create a panel in grid layout
		statPanel = new JPanel(new GridLayout(1, 3));

		// create a score label
		scoreLabel = new JLabel();

		// set the label's text
		scoreLabel.setText("Score: " + score);

		// add the label to the panel
		statPanel.add(scoreLabel);

		// return the panel
		return statPanel;

	}

	/**
	 * Serve an order
	 */
	public void serve() {

		// get the next order in line
		line.getLine().getNextOrder();

		// remove the current ice cream maker
		remove(maker);

		// create a new ice cream maker
		maker = new IceCreamMaker();

		// add the new maker
		add(maker);

		// update the score
		scoreLabel.setText("Score:   " + score);

		// after serving, refresh display
		repaint();
	}

	/**
	 * Update the score
	 */
	private void updateScore() {

		// get the cone in the making
		IceCreamCone inTheMaking = maker.getCone();

		// get the order line
		Queue<IceCreamCone> orders = line.getLine().getOrderLine();

		// get the first order
		IceCreamCone order = orders.peek();

		// if there is an order
		if (order != null) {

			// compare the cone currently being made and the cone in the oder
			if (matches(inTheMaking, order)) {

				// if they match, increase the score
				score += CORRECT_MATCH_SCORE;

			} else {

				// if they do not match, decrease the score
				score -= INCORRECT_MATCH_SCORE;

			}

			// serve the order regardless of whether the ice cream cones matched
			serve();
		}

	}

	/**
	 * Compare if two cones have same scoops
	 * 
	 * @param c1
	 *            the first cone
	 * @param c2
	 *            the second cone
	 * @return true if the two ice cream cone are the same; false otherwise
	 */
	public boolean matches(IceCreamCone c1, IceCreamCone c2) {

		// get the scoop flavors of one cone
		StackLL<String> scoopsC1 = c1.getScoopFlavors();

		// get the scoop flavors of the other cone
		StackLL<String> scoopsC2 = c2.getScoopFlavors();

		// if both stacks are empty
		if (scoopsC1.isEmpty() && scoopsC2.isEmpty())

			// return true
			return true;

		// if one of the stacks is empty
		if (scoopsC1.isEmpty() || scoopsC2.isEmpty())

			// return false
			return false;

		// compare the two stacks of scoops
		while (c1.hasScoop() && c2.hasScoop()) {

			// top scoop of one cone
			String top1 = scoopsC1.pop();

			// top scoop of the other cone
			String top2 = scoopsC2.pop();

			// if the two scoops are not equal
			if (!top1.equals(top2)) {

				// push the scoops back to its corresponding stacks
				scoopsC1.push(top1);
				scoopsC2.push(top2);

				// return false
				return false;
			}
		}

		// if after the loop, either of the cone still has more scoops
		if (c1.hasScoop() || c2.hasScoop())

			// return false
			return false;

		// if all conditions passed, return true
		return true;
	}

	/**
	 * Determine what happens when the user clicks on the buttons
	 */
	public void actionPerformed(ActionEvent e) {

		// if the button is "serve the order"
		if (e.getActionCommand().equals("serve")) {

			// update the score
			updateScore();
		}

		// if the button is "add"
		else if (e.getActionCommand().equals("add")) {

			// add an order to the line
			line.getLine().addRandomOrder();
		}

		// refresh the display
		repaint();
	}

}
