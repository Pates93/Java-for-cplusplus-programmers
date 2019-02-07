import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameDemoSimple
{	FrameDemoSimple()
    {	JFrame frame = new JFrame("FrameDemoSimple");	// Local variable is the frame
    	/*
        frame.addWindowListener(new WindowAdapter() {	// anonym klass
            public void windowClosing(WindowEvent e) {
				System.out.println("häpp!");
                System.exit(0);
            }
        });
        */
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void main(String[] args){new FrameDemoSimple();}
}
