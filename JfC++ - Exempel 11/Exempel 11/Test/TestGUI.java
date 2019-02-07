import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestGUI extends JFrame {
	private JButton myJButton1;
	private JButton myJButton2;
	
	
	public TestGUI() {
		myJButton1 = new JButton("Click me 1!");
		myJButton2 = new JButton("Click me 2!");
		
		ActionListener l = e -> System.out.println("click");
		myJButton1.addActionListener(l);
		myJButton2.addActionListener(l);
		
		add(myJButton1, BorderLayout.WEST);
		add(myJButton2, BorderLayout.EAST);
		
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		// Skapa en ny instans av vårt fönster på rätt sätt
		// genom att använda SwingUtilities och invokeLater.
		// Nu ekexveras konstruktorn av händelsetråden.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TestGUI();
			}
		});	
	}
}