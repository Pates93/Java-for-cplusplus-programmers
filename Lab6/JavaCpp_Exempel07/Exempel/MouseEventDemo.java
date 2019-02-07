/*
 * Swing version
 */

import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.event.*;


public class MouseEventDemo extends JFrame
                            implements MouseListener {
    BlankArea blankArea;
    JTextArea textArea;
    final static String newline = "\n";
 	static final long serialVersionUID = -673724713844689830L;

    public MouseEventDemo() {
        GridBagLayout gridbag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        JPanel contentPane = new JPanel();
        contentPane.setLayout(gridbag);

        c.fill = GridBagConstraints.BOTH;
        c.gridwidth = GridBagConstraints.REMAINDER;
        c.weightx = 1.0;
        c.weighty = 1.0;

        c.insets = new Insets(1, 1, 1, 1);
        blankArea = new BlankArea(new Color(0.98f, 0.97f, 0.85f));
        gridbag.setConstraints(blankArea, c);
        contentPane.add(blankArea);

        c.insets = new Insets(0, 0, 0, 0);
        textArea = new JTextArea();
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(200, 75));
        gridbag.setConstraints(scrollPane, c);
        contentPane.add(scrollPane);

        //Register for mouse events on blankArea and applet.
        blankArea.addMouseListener(this);
        addMouseListener(this);

        setContentPane(contentPane);

	  addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                  System.exit(0);
            }
        });

    }

    public void mousePressed(MouseEvent e) {
       saySomething("Mouse pressed (# of clicks: "
                    + e.getClickCount() + ")", e);
    }

    public void mouseReleased(MouseEvent e) {
       saySomething("Mouse released (# of clicks: "
                    + e.getClickCount() + ")", e);
    }

    public void mouseEntered(MouseEvent e) {
       saySomething("Mouse entered", e);
    }

    public void mouseExited(MouseEvent e) {
       saySomething("Mouse exited", e);
    }

    public void mouseClicked(MouseEvent e) {
       saySomething("Mouse clicked (# of clicks: "
                    + e.getClickCount() + ")", e);
    }

    void saySomething(String eventDescription, MouseEvent e) {
        textArea.append(eventDescription + " detected on "
                        + e.getComponent().getClass().getName()
                        + "." + newline);
    }

    public static void main(String arg[]){
		MouseEventDemo frame=new MouseEventDemo();
		frame.pack();
		frame.setVisible(true);
   }

}
