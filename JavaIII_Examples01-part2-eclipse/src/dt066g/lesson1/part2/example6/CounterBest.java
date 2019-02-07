package dt066g.lesson1.part2.example6;
/**
 * Ex01_2_06 - CounterBest.java
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.*;

public class CounterBest extends JFrame implements ActionListener {
	// Inastansvariabler
	private boolean stop = false;
	private int counter = 0;
	
	// Komponenter
	private JLabel counterLabel;
	private JButton startButton;
	private JButton stopButton;
	
	public CounterBest() {
		// Sätt titel på fönstret
		super("Counter - Best");

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
			
			// Skapa och starta vårt bakgrundsjobb. Skicka med nuvarande värde
			// på vår räknare till konstruktorn.
			CounterSwingWorker worker = new CounterSwingWorker(counter);
			worker.execute();
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
				new CounterBest();
			}
		});		
	}
	
	// En SwingWorker för att utföra vår långa "uppgift" att räkna upp värdet
	public class CounterSwingWorker extends SwingWorker<Integer, String> {
		private int startValue;
		
		public CounterSwingWorker(int startValue) {
			this.startValue = startValue;
		}
		
		@Override
		protected Integer doInBackground() {
			// Räkna upp värdet med 2000000, eller till dess att vi trycker på stopp
			int endValue = startValue + 2000000;
			for (int i = startValue; i < endValue; i++) {
				// Avbryt loopen om vi har tryckt på stoppknappen
				if (stop) {
					break;
				}
				startValue++;
				
				// Publisera resultatet
				publish(Integer.toString(startValue));				
			}
			
			return startValue;
		}
		
		@Override
		protected void process(java.util.List<String> chunks) {
			// Använd det sista resultatet från listan
			String latestResult = chunks.get(chunks.size() - 1);
			counterLabel.setText(latestResult);
		}
		
		@Override
		protected void done() {
			// Denna metod körs på händelsetråden, dvs det är ok att uppdatera GUI här
			try {
				// Anropa get för att få resultatet från doInBackground
				Integer finalResult = get();
				
				// Visa resultatet i vår label
				counterLabel.setText(finalResult.toString());
				counter = finalResult;
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	};
}