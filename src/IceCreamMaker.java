import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Make an ice cream (controller for the ice cream maker application)
 * 
 * @author Emma Nguyen
 * @version March 29, 2018
 */
public class IceCreamMaker extends JPanel implements ActionListener {

	/* declare instance variables */

	// an ice cream cone
	private IceCreamCone cone;

	// an ice cream cone view
	private IceCreamConeView view;

	// an array of buttons holding scoop flavors
	private JButton[] flavorBtns;

	private JButton eat;

	/**
	 * Construct an ice cream maker
	 */
	public IceCreamMaker() {

		// call the super class constructor with a border layout
		super(new BorderLayout());

		// create an ice cream maker
		reset();

	}

	/**
	 * Refresh the display
	 */
	public void refreshDisplay() {

		// refresh the view
		repaint();
	}

	/**
	 * Add the menu to the screen
	 */
	private void addMenu() {

		// create a panel holding the buttons
		JPanel menuPanel = new JPanel(new GridLayout(2, 1));

		// add the flavor buttons
		menuPanel.add(createFlavorMenu());

		// add the eat button
		menuPanel.add(createEatButton());

		// add the panel to the north side of the screen
		add(menuPanel, BorderLayout.NORTH);

	}

	/**
	 * Create the flavor menu
	 * 
	 * @return the panel holding the flavors
	 */
	private JPanel createFlavorMenu() {

		// create a new panel
		JPanel flavorPanel = new JPanel();

		// set the panel's layout
		flavorPanel.setLayout(new FlowLayout());

		// create the buttons
		flavorBtns = new JButton[5];

		// traverse the array holding the buttons
		for (int i = 0; i < flavorBtns.length; i++) {

			// create a button
			flavorBtns[i] = new JButton();

			// set the button's background color
			flavorBtns[i].setBackground(IceCreamConeView.SCOOP_COLORS[i]);

			// set the opacity
			flavorBtns[i].setOpaque(true);

			// do not paint the border
			flavorBtns[i].setBorderPainted(false);

			// set the text inside the button
			flavorBtns[i].setText(IceCreamCone.FLAVORS[i]);

			// add action listener to the button
			flavorBtns[i].addActionListener(this);

			// add the button to the panel
			flavorPanel.add(flavorBtns[i]);
		}

		// return the panel holding the flavor buttons
		return flavorPanel;
	}

	/**
	 * Create the button to eat the top scoop
	 * 
	 * @return the button to eat the top scoop
	 */
	private JButton createEatButton() {

		// create the button
		eat = new JButton("Eat the top scoop!");

		// set action command
		eat.setActionCommand("Eat the top scoop");

		// add action listener to the button
		eat.addActionListener(this);

		// return the button
		return eat;
	}

	/**
	 * Get the ice cream cone currently in the ice cream maker
	 * 
	 * @return the ice cream cone
	 */
	public IceCreamCone getCone() {

		// return the cone
		return cone;
	}

	/**
	 * Reset the ice cream maker
	 */
	public void reset() {

		// create an ice cream cone
		cone = new IceCreamCone();

		// create an ice cream cone view
		view = new IceCreamConeView(cone);

		// add the menu
		addMenu();

		// add the view to the center of the screen
		add(view, BorderLayout.CENTER);

		// refresh the display
		refreshDisplay();
	}

	/**
	 * Determine what happens when the user clicks on each button
	 */
	// @Override
	public void actionPerformed(ActionEvent e) {

		// if the user clicks on the eat button
		if (e.getActionCommand().equals("Eat the top scoop"))

			// eat the top scoop (pop it)
			cone.popTopScoop();

		// traverse the flavor buttons
		for (int i = 0; i < flavorBtns.length; i++) {

			// if one of them is clicked on
			if (e.getSource() == flavorBtns[i]) {

				// add the scoop with the corresponding flavor to the ice cream cone
				cone.addScoop(flavorBtns[i].getText());
			}
		}

		// refresh the display after each action
		refreshDisplay();
	}

	/**
	 * Get the eat button
	 * 
	 * @return the eat button
	 */
	public JButton getEatButton() {

		// return the eat button
		return eat;
	}

	/**
	 * Get the flavor buttons
	 * 
	 * @return the flavor buttons
	 */
	public JButton[] getFlavorBtns() {

		// return the buttons
		return flavorBtns;
	}

}
