package dt066g.lesson1.part2.example4;
/**
 * Ex01_2_04 - CounterBetter.java
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CounterBetter extends JFrame implements ActionListener {
	// Inastansvariabler
	private boolean stop = false;
	private int counter = 0;
	
	// Komponenter
	private JLabel counterLabel;
	private JButton startButton;
	private JButton stopButton;
	
	public CounterBetter() {
		// Sätt titel på fönstret
		super("Counter - Better");

		//  Vad ska ske när vi stänger fönstret?
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		// Centrera fönstret på skärmen
		setLocationRelativeTo(null);

		// Ange vilken layout som ska användas i fönstret
		setLayout(new GridLayout(2, 1));

		// Initiera alla komponenter
		initComponents();

		// Sätt storleken på fönstret
		pack();

		// Gör fönstret synligt
		setVisible(true);
	}

	private void initComponents() {
		// Skapa vår JLabel
		counterLabel = new JLabel(Integer.toString(counter), SwingConstants.CENTER);
		
		// Skapa knapparna
		startButton = new JButton("Börja räkna");
		stopButton = new JButton("Sluta räkna");
		
		// Registrera lyssnare
		startButton.addActionListener(this);
		stopButton.addActionListener(this);
		
		// Lägg knapparna i en panel med FlowLayout
		JPanel panel = new JPanel(new FlowLayout());
		panel.add(startButton);
		panel.add(stopButton);
		
		// Lägg till komponenterna i fönstret
		add(counterLabel);
		add(panel);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == startButton) {
			stop = false;
			
			// Skapa en ny tråd som får utföra uppräkningen
			Thread t = new Thread() {
				@Override
				public void run() {
					// Räkna upp värdet med 2000000, eller till dess att vi trycker på stopp
					for (int i = 0; i < 2000000; i++) {
						// Avbryt loopen om vi har tryckt på stoppknappen
						if (stop) {
							break;
						}
						counter++;
						// Eftersom denna tråd inte är händelsetråden måste vi använda
						// SwingUtilities och invokeLater för att uppdatera GUI
						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								counterLabel.setText(Integer.toString(counter));
							}
						});
					}
				}
			};
			// Starta tråden
			t.start();
		}
		else if (e.getSource() == stopButton) {
			stop = true;
		}
	}

	public static void main(String args[]) {
		// Skapa en ny instans av vårt fönster på rätt sätt
		// genom att använda SwingUtilities och invokeLater.
		// Nu ekexveras konstruktorn av händelsetråden.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CounterBetter();
			}
		});		
	}
}