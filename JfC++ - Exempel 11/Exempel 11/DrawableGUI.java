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
		// Skapa en ny instans av vårt fönster på rätt sätt
		// genom att använda SwingUtilities och invokeLater.
		// Nu ekexveras konstruktorn av händelsetråden.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new DrawableGUI();
			}
		});	
	}
}