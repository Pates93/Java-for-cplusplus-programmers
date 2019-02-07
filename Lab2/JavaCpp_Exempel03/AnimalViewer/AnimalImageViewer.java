/**
 *
 * @author Örjan Sterner
 * @version 1.1 based on version 1.0 by Åke Malmberg
 */

import java.awt.*;    // ImageIcon
import javax.swing.*;  // JFrame, JLabel, JScrollpane


public class AnimalImageViewer extends JFrame {

	private JLabel iLabel;
	private JScrollPane iPane;

	public AnimalImageViewer(String aImagePath, String aCaption) {
		super(aCaption);
		iLabel = new JLabel(new ImageIcon(aImagePath));
		iPane = new JScrollPane(iLabel);
		this.setVisible(false); // Hide it until later
	}



	public void viewAnimal(int iLength, int iWidth) {
		this.add(iPane);
		this.setSize(iLength,iWidth);
		this.setVisible(true);
	}

//--- main function for testing ---
/*
	public static void main(String args[]) {
		new AnimalImageViewer("golden.jpg").viewAnimal(400,400);
	}
*/

}