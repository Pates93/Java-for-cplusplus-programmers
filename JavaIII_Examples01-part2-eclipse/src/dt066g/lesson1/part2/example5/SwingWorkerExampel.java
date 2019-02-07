package dt066g.lesson1.part2.example5;
/**
 * Ex01_2_05 - SwingWorkerExampel.java
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.*;

public class SwingWorkerExampel extends JFrame {
	public SwingWorkerExampel() {
		// Skapa och starta vårt bakgrundsjobb
		TestSwingWorker worker = new TestSwingWorker();
		worker.execute();	
	}
	
	public static void main(String args[]) {
		// Skapa en ny instans av vår klass
		new SwingWorkerExampel();
	}
	
	// En SwingWorker för att utföra vår långa "uppgift"
	public class TestSwingWorker extends SwingWorker<Integer, String> {
		@Override
		protected Integer doInBackground() {
			publish("Start");
			publish("Halvvägs");
			publish("Slutfört");
			
			return 1;
		}
		
		@Override
		protected void done() {
			try {
				// Anropa get för att få resultatet från doInBackground
				Integer finalResult = get();
				
				// Skriv ut resultatet på skärmen
				System.out.println("Slutresultat: " + finalResult);
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
			catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		protected void process(java.util.List<String> chunks) {
			// Loopa igenom resultatet från listan och publisera det
			for (String result : chunks) {
				System.out.println("Status: " + result);
			}
		}
	};
}