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
		// Skapa en ny instans av v�rt f�nster p� r�tt s�tt
		// genom att anv�nda SwingUtilities och invokeLater.
		// Nu ekexveras konstruktorn av h�ndelsetr�den.
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TestGUIOld();
			}
		});	
	}
}