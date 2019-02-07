import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DrawableGUI extends JFrame {
	private DrawingPanel drawingPanel;	
	
	public DrawableGUI() {
		drawingPanel = new DrawingPanel();
		drawingPanel.setPreferredSize(new Dimension(300, 300));
		add(drawingPanel, BorderLayout.CENTER);
		
		pack();
		setVisible(true);
	}
	
	

	public static void main(String[] args) {
		// Skapa en ny instans av v�rt f�nster p� r�tt s�tt
		// genom att anv�nda SwingUtilities och invokeLater.
		// Nu ekexveras konstruktorn av h�ndelsetr�den.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DrawableGUI();
			}
		});	
	}
}