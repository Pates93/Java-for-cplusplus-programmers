import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FrameDemoBest extends JFrame
{	FrameDemoBest()
    {	super("FrameDemoBest");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)((double)d.width*0.95),(int)((double)d.height*0.80));
		setLocation(new Point((int)((double)d.width*(0.02)),(int)((double)d.height*(0.02))));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args){new FrameDemoBest();}
}
