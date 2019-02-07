import java.awt.*;

import javax.swing.JFrame;

public class MyFrame extends JFrame
{	MyFrame()
	{	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		setSize(screenWidth/2,screenHeight/2);
		setLocation(screenWidth/4, screenHeight/4);
		// setVisible(true);  // why not here?
	}

	public void paint(Graphics g)
	{	System.out.println("--> MyFrame.paint(.)");
	}
}