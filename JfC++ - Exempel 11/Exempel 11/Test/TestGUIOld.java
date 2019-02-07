import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestGUIOld extends JFrame {
	private JButton myJButton;
	
	public TestGUIOld() {
		myJButton = new JButton("Click me!");
		myJButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("click");
			}
		});
		
		add(myJButton);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		// Skapa en ny instans av vårt fönster på rätt sätt
		// genom att använda SwingUtilities och invokeLater.
		// Nu ekexveras konstruktorn av händelsetråden.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TestGUIOld();
			}
		});	
	}
}