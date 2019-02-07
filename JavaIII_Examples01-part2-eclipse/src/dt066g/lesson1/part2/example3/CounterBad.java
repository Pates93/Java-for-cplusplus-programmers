package dt066g.lesson1.part2.example3;
/**
 * Ex01_2_03 - CounterBad.java
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV �stersund
 * @version 1.0
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CounterBad extends JFrame implements ActionListener {
	// Inastansvariabler
	private boolean stop = false;
	private int counter = 0;
	
	// Komponenter
	private JLabel counterLabel;
	private JButton startButton;
	private JButton stopButton;
	
	public CounterBad() {
		// S�tt titel p� f�nstret
		super("Counter - Bad");

		//  Vad ska ske n�r vi st�nger f�nstret?
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Centrera f�nstret p� sk�rmen
		setLocationRelativeTo(null);

		// Ange vilken layout som ska anv�ndas i f�nstret
		setLayout(new GridLayout(2, 1));

		// Initiera alla komponenter
		initComponents();

		// S�tt storleken p� f�nstret
		pack();

		// G�r f�nstret synligt
		setVisible(true);
	}

	private void initComponents() {
		// Skapa v�r JLabel
		counterLabel = new JLabel(Integer.toString(counter), SwingConstants.CENTER);
		
		// Skapa knapparna
		startButton = new JButton("B�rja r�kna");
		stopButton = new JButton("Sluta r�kna");
		
		// Registrera lyssnare
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		
		// L�gg knapparna i en panel med FlowLayout
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(startButton);
		panel.add(stopButton);
		
		// L�gg till komponenterna i f�nstret
		add(counterLabel);
		add(panel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			// Utf�r uppr�kningen i h�ndelsetr�den
			// L�ng "uppgift" i h�ndelsetr�den f�r GUI att frysa
			stop = false;
			// R�kna upp v�rdet med 2000000, eller till dess att vi trycker p� stopp
			for (int i = 0; i < 2000000; i++) {
				// Avbryt loopen om vi har tryckt p� stoppknappen
				if (stop) {
					break;
				}
				counter++;
				// Uppdatera GUI (sker i h�ndelsetr�den s� helt ok)
				counterLabel.setText(Integer.toString(counter));
			}
		}
		else if (e.getSource() == stopButton) {
			stop = true;
		}
	}

	public static void main(String args[]) {
		// Skapa en ny instans av v�rt f�nster p� r�tt s�tt
		// genom att anv�nda SwingUtilities och invokeLater.
		// Nu ekexveras konstruktorn av h�ndelsetr�den.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CounterBad();
			}
		});		
	}
}