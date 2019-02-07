package dt062g.olpa1600.assignment7;

import javax.swing.SwingUtilities;

/**
* <h1>Assignment 7</h1>
* This class is the starting point for the drawing application.
* It creates our JFrame and makes it visible.
* 
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since   24-12-2017
*/
public class Main {

	public static void main(String[] args) {
		// Make sure GUI is created on the event dispatching thread
		// This will be explained in the lesson about threads
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new GUI().setVisible(true);
			}
		});		
	}
}