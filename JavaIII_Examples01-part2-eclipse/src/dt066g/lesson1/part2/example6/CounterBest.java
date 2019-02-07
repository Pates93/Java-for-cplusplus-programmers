package dt066g.lesson1.part2.example6;
/**
 * Ex01_2_06 - CounterBest.java
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV �stersund
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
		// S�tt titel p� f�nstret
		super("Counter - Best");

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
			stop = false;
			
			// Skapa och starta v�rt bakgrundsjobb. Skicka med nuvarande v�rde
			// p� v�r r�knare till konstruktorn.
			CounterSwingWorker worker = new CounterSwingWorker(counter);
			worker.execute();
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
				new CounterBest();
			}
		});		
	}
	
	// En SwingWorker f�r att utf�ra v�r l�nga "uppgift" att r�kna upp v�rdet
	public class CounterSwingWorker extends SwingWorker<Integer, String> {
		private int startValue;
		
		public CounterSwingWorker(int startValue) {
			this.startValue = startValue;
		}
		
		@Override
		protected Integer doInBackground() {
			// R�kna upp v�rdet med 2000000, eller till dess att vi trycker p� stopp
			int endValue = startValue + 2000000;
			for (int i = startValue; i < endValue; i++) {
				// Avbryt loopen om vi har tryckt p� stoppknappen
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
			// Anv�nd det sista resultatet fr�n listan
			String latestResult = chunks.get(chunks.size() - 1);
			counterLabel.setText(latestResult);
		}
		
		@Override
		protected void done() {
			// Denna metod k�rs p� h�ndelsetr�den, dvs det �r ok att uppdatera GUI h�r
			try {
				// Anropa get f�r att f� resultatet fr�n doInBackground
				Integer finalResult = get();
				
				// Visa resultatet i v�r label
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