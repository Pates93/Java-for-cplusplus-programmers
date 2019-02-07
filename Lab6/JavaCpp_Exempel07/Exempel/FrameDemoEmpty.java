import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameDemoEmpty extends JFrame	// N.B. inherits JFrame
{	FrameDemoEmpty()
    {	super("FrameDemoEmpty");
    	setLocation(300,300);
    	setSize(new Dimension(300,200));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){new FrameDemoEmpty();}
}
