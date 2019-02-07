import java.awt.*;
import javax.swing.*;

import java.awt.geom.Rectangle2D;

// public class One2 extends org.jfree.ui.ApplicationFrame
public class One2 extends JFrame
{	Shape shp=new Rectangle2D.Double(100,100,100,100);

	One2()
	{	super("One2");
		System.out.println("shp="+shp);
		add(new JButton("North"),BorderLayout.NORTH);
		add(new Canvas(),BorderLayout.CENTER);
		add(new JButton("South"),BorderLayout.SOUTH);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension d = tk.getScreenSize();
		int screenHeight = d.height;
		int screenWidth = d.width;
		setSize(screenWidth/2,screenHeight/2);
		setLocation(screenWidth/4, screenHeight/4);

		setVisible(true);	// why here?
	}

	public void paint(Graphics G)
	{	System.out.println("--> One2.paint(.)");
	}

	public static void main(String[] args)
	{	new One2();
	}


	class Canvas extends java.awt.Canvas
	{	Canvas()
		{	super();
		}

		//	Draw shape only
		public void paint(Graphics g)
		{	System.out.println("--> paint(.)");
			super.paint(g);
			Graphics2D g2=(Graphics2D)g;
			g2.draw(shp);
		}

		public void paintComponent(Graphics g)
		{	System.out.println("--> paintComponent(.)");
		}
	}

	class JButton extends java.awt.Button //javax.swing.JButton
	{	JButton(String label){super(label);}

		public void paint(Graphics g)
		{	System.out.println("--> JButton.paint(.)");
			super.paint(g);
		}
	}
}