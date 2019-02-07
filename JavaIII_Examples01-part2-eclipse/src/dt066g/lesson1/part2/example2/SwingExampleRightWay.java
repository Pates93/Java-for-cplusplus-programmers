package dt066g.lesson1.part2.example2;
/**
 * Ex01_2_02 - SwingExampleRightWay.java
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SwingExampleRightWay extends JFrame {
	// Inastansvariabler (normalt alla komponenter)
	private JLabel label;
	
	public SwingExampleRightWay() {
		// Sätt titel på fönstret
		super("Swing exempel the right way");

		//  Vad ska ske när vi stänger fönstret?
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Centrera fönstret på skärmen
		setLocationRelativeTo(null);

		// Ange vilken layout som ska användas i fönstret
		setLayout(new FlowLayout());

		// Initiera alla komponenter
		initComponents();

		// Sätt storleken på fönstret
		pack();

		// Gör fönstret synligt
		setVisible(true);
	}

	private void initComponents() {
		// Ta reda på namnet på den tråd som exekverar koden
		String name = Thread.currentThread().getName();
		
		// Skapa vår JLabel
		label = new JLabel(name);
		
		// Lägg till i fönstret
		add(label);
	}

	public static void main(String args[]) {
		// Skapa en ny instans av vårt fönster på rätt sätt
		// genom att använda SwingUtilities och invokeLater.
		// Nu ekexveras konstruktorn av händelsetråden.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SwingExampleRightWay();
			}
		});		
	}
}