import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Manage an ice cream line (controller for ice cream line application)
 * 
 * @author Emma Nguyen
 * @version March 31, 2018
 */
public class IceCreamLineManager extends JPanel implements ActionListener {

	// create an ice cream line
	private IceCreamLine line;

	// create a panel
	private JPanel main;

	private JButton add;

	/**
	 * Construct an ice cream line controller
	 */
	public IceCreamLineManager() {

		// call the superclass constructor
		super();

		// initialize the line
		line = new IceCreamLine();

		// create the view
		initiateGUI();

		// refresh the display
		repaint();

	}

	/**
	 * Initiate the GUI of the ice cream line
	 */
	private void initiateGUI() {

		// set the layout
		setLayout(new BorderLayout());

		// add the ice cream line
		add(line, BorderLayout.CENTER);

		// add the buttons (controls)
		add(createControls(), BorderLayout.NORTH);
	}

	/**
	 * Create a panel, add and display the line's components, including the buttons
	 * and the orders
	 */
	private JPanel createControls() {

		// create a panel that holds the button
		JPanel main = new JPanel(new GridLayout(2, 1));

		// add the add order button
		main.add(createAddOrderButton());

		// add the serve order button
		// main.add(createServeButton()); // for the Ice Cream Shop application, there's
		// no need for this button

		// return the panel
		return main;

	}

	/**
	 * Create a "add order" button
	 * 
	 * @return the "add order" button
	 */
	private JButton createAddOrderButton() {

		// create the add order button
		add = new JButton("Add a random order");

		// set the button's action command
		add.setActionCommand("Add order");

		// add action listener to the button
		add.addActionListener(this);

		// return the button
		return add;
	}

	/**
	 * Create a "serve" button
	 * 
	 * @return the "serve" button
	 */
	private JButton createServeButton() {

		// create a serve button
		JButton serve = new JButton("Serve the next order");

		// set the button's action command
		serve.setActionCommand("serve");

		// add action listener to the button
		serve.addActionListener(this);

		// return the button
		return serve;
	}

	/**
	 * Handle what happens when the user clicks on the buttons
	 * 
	 * @param e
	 *            an action event
	 */
	public void actionPerformed(ActionEvent e) {

		// if the user clicks on the "add order" button
		if (e.getActionCommand().equals("Add order")) {

			// a random order to the line
			line.addRandomOrder();

		} else if (e.getActionCommand().equals("serve")) {

			// get the next order
			line.getNextOrder();
		}

		// refresh display
		repaint();

	}

	/**
	 * Get the order line
	 * 
	 * @return the ice cream line
	 */
	public IceCreamLine getLine() {

		// return the line
		return line;
	}

	/**
	 * Get the add button
	 * 
	 * @return the add button
	 */
	public JButton getAddButton() {

		// return the button
		return add;
	}
}
