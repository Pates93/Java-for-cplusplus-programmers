package dt066g.lesson1.part2.example5;
/**
 * Ex01_2_05 - SwingWorkerExampel.java
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV �stersund
 * @version 1.0
 */
 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.*;

public class SwingWorkerExampel extends JFrame {
	public SwingWorkerExampel() {
		// Skapa och starta v�rt bakgrundsjobb
		TestSwingWorker worker = new TestSwingWorker();
		worker.execute();	
	}
	
	public static void main(String args[]) {
		// Skapa en ny instans av v�r klass
		new SwingWorkerExampel();
	}
	
	// En SwingWorker f�r att utf�ra v�r l�nga "uppgift"
	public class TestSwingWorker extends SwingWorker<Integer, String> {
		@Override
		protected Integer doInBackground() {
			publish("Start");
			publish("Halvv�gs");
			publish("Slutf�rt");
			
			return 1;
		}
		
		@Override
		protected void done() {
			try {
				// Anropa get f�r att f� resultatet fr�n doInBackground
				Integer finalResult = get();
				
				// Skriv ut resultatet p� sk�rmen
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
			// Loopa igenom resultatet fr�n listan och publisera det
			for (String result : chunks) {
				System.out.println("Status: " + result);
			}
		}
	};
}