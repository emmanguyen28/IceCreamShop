import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * An ice cream shop in which the ice cream orders are automatically generated.
 * The game time frame is 1 minute. The player tries to earn as many points as
 * possible within the game's time frame
 * 
 * @author Emma Nguyen
 * @version April 6, 2018
 */
public class TimedIceCreamShop extends IceCreamShop {

	/* declare constants */

	// default time duration of a game
	public static final long GAME_TIME = 60000;

	// time before the next order is generated
	public static final int TIME_FOR_NEW_ORDER = 3000;

	// time interval for Time Remaining timer
	public static final int TIME_INTERVAL = 1000;

	/* declare instance variables */

	// the time remaining
	private long timeRemaining;

	// the level of the game
	private int level;

	// the label that holds the Time Remaining of the game
	private JLabel timeRemainingLabel;

	// the label that holds the level of the game
	private JLabel levelLabel;

	// the timer to generate new orders
	private Timer shopTimer;

	// the timer to count the time remaining of the game
	private Timer timeRemainingTimer;

	/**
	 * Construct a timed ice cream shop
	 */
	public TimedIceCreamShop() {

		// call the super class constructor
		super();

		// initially, the time remaining is the entire game time
		timeRemaining = GAME_TIME;

		// set the level to be 1
		level = 1;

		// create the label that holds the Remaining Time
		createTimeRemainingLabel();

		// create the label that holds the level
		createLevelLabel();

		// set up the timer for remaining time
		setUpTimeRemainingTimer();

		// set up the timer to generate orders
		setUpShopTimer();

		// refresh the display
		repaint();

	}

	/**
	 * Set up the timer to generate orders
	 */
	private void setUpShopTimer() {

		// initialize a timer to generate orders
		shopTimer = new Timer(TIME_FOR_NEW_ORDER, new ActionListener() {

			/**
			 * Handle what happens during the timer
			 */
			public void actionPerformed(ActionEvent e) {

				// if the remaining time is less than 0
				if (timeRemaining <= 0) {

					// end the game
					gameOver();
				}

				// add an order to the line
				line.getLine().addRandomOrder();

				// set the level - the level increases by one with every score of 50 the player
				// earns
				level = ((score / 50) + 1);

				// set new time delay based on the level
				shopTimer.setDelay(TIME_FOR_NEW_ORDER - 500 * (level - 1));

				// update the level label
				levelLabel.setText("Level: " + level);

				// refresh the display
				repaint();
			}

		});

		// set the timer's initial delay to be 0
		shopTimer.setInitialDelay(0);

		// start the timer
		shopTimer.start();
	}

	/**
	 * Set up a timer for counting down the time
	 */
	private void setUpTimeRemainingTimer() {

		// get the initial time when the game starts
		long initial = System.currentTimeMillis();

		// initialize the timer for counting down the time
		timeRemainingTimer = new Timer(TIME_INTERVAL, new ActionListener() {

			/**
			 * Handle what happens during the timer
			 */
			public void actionPerformed(ActionEvent e) {

				// if the time remaining is less than 0
				if (timeRemaining <= 0)

					// end the game
					gameOver();

				// update the label
				timeRemainingLabel.setText("Time left: " + (timeRemaining / 1000) + " seconds");

				// update the time remaining
				timeRemaining = (initial + GAME_TIME - System.currentTimeMillis());

				// refresh the display
				repaint();

			}
		});

		// set the timer's initial delay to be 0
		timeRemainingTimer.setInitialDelay(0);

		// start the timer
		timeRemainingTimer.start();
	}

	/**
	 * Create the label that holds the remaining time
	 */
	private void createTimeRemainingLabel() {

		// create the label
		timeRemainingLabel = new JLabel();

		// add the label to panel
		statPanel.add(timeRemainingLabel);

		// set the label's text
		timeRemainingLabel.setText("Time left: " + (timeRemaining / 1000) + " seconds");
	}

	/**
	 * Create the label that holds the level of the game
	 */
	private void createLevelLabel() {

		// create the label
		levelLabel = new JLabel();

		// add the label to the panel
		statPanel.add(levelLabel);

		// set the label's text
		levelLabel.setText("Level: " + level);

		// set the label to be in the center
		levelLabel.setHorizontalAlignment(JLabel.CENTER);

	}

	/**
	 * Define the game's state when it's over
	 */
	private void gameOver() {

		// stop the timer that generates orders
		shopTimer.stop();

		// stop the timer that counts down the game
		timeRemainingTimer.stop();

		// disable the buttons
		serve.setEnabled(false);
		maker.getEatButton().setEnabled(false);
		line.getAddButton().setEnabled(false);
		JButton[] flavorBtns = maker.getFlavorBtns();
		for (int i = 0; i < flavorBtns.length; i++) {
			flavorBtns[i].setEnabled(false);
		}
	}

}
