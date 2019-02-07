/*
 * Swing version.
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BoxWindow extends JFrame implements ActionListener{
    boolean inAnApplet = true;

    public BoxWindow() {
        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane,
                                            BoxLayout.Y_AXIS));

        addAButton("Button 1", contentPane);
        addAButton("2", contentPane);
        addAButton("Button 3", contentPane);
        addAButton("Long-Named Button 4", contentPane);
        addAButton("Button 5", contentPane);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                if (inAnApplet) {
                    dispose();
                } else {
                    System.exit(0);
                }
            }
        });
    }

    private void addAButton(String text, Container container) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        container.add(button);
	  button.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
   	 // System.out.println(e.getSource().getLabel());
	}

    public static void main(String args[]) {
        BoxWindow window = new BoxWindow();
        window.inAnApplet = false;

        window.setTitle("BoxLayout");
        window.pack();
        window.setVisible(true);
    }
}
