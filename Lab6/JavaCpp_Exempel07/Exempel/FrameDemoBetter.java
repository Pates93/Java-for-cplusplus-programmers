import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameDemoBetter extends JFrame
{	FrameDemoBetter()
    {	super("FrameDemoBetter");
    	setLocation(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JLabel emptyLabel = new JLabel("qwert");
        emptyLabel.setPreferredSize(new Dimension(200, 100));
        getContentPane().add(emptyLabel, BorderLayout.CENTER);
        pack();
        setVisible(true);
    }

    public static void main(String[] args){new FrameDemoBetter();}
}
