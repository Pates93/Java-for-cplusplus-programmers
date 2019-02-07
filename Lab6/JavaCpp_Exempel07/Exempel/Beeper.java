/*
 * Swing version.
 */

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Toolkit;
import java.awt.BorderLayout;
import java.awt.event.*;

public class Beeper extends JFrame{
    JButton button;

    public Beeper() {
        button = new JButton("Click Me");
        getContentPane().add(button, BorderLayout.CENTER);

        button.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Toolkit.getDefaultToolkit().beep();
				System.out.println("beep!!");
			}
		});

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				  System.exit(0);
			}
		});

    }

    public static void main(String arg[]){
        Beeper bp=new Beeper();
        bp.pack();
        bp.setVisible(true);
   }

   static final long serialVersionUID = 7526472295622776147L;
}
