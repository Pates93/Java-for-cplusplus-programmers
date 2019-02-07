package dt066g.lesson1.part2.example2;
/**
 * Ex01_2_02 - SwingExampleRightWay.java
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV �stersund
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
		// S�tt titel p� f�nstret
		super("Swing exempel the right way");

		//  Vad ska ske n�r vi st�nger f�nstret?
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Centrera f�nstret p� sk�rmen
		setLocationRelativeTo(null);

		// Ange vilken layout som ska anv�ndas i f�nstret
		setLayout(new FlowLayout());

		// Initiera alla komponenter
		initComponents();

		// S�tt storleken p� f�nstret
		pack();

		// G�r f�nstret synligt
		setVisible(true);
	}

	private void initComponents() {
		// Ta reda p� namnet p� den tr�d som exekverar koden
		String name = Thread.currentThread().getName();
		
		// Skapa v�r JLabel
		label = new JLabel(name);
		
		// L�gg till i f�nstret
		add(label);
	}

	public static void main(String args[]) {
		// Skapa en ny instans av v�rt f�nster p� r�tt s�tt
		// genom att anv�nda SwingUtilities och invokeLater.
		// Nu ekexveras konstruktorn av h�ndelsetr�den.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SwingExampleRightWay();
			}
		});		
	}
}