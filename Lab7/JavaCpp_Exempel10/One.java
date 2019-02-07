import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import java.awt.geom.Rectangle2D;

public class One extends MyFrame
{	Shape shp=new Rectangle2D.Double(100,100,100,100);

	One()
	{	System.out.println("shp="+shp);
		setVisible(true);	// why here?
	}

	public static void main(String[] args)
	{	new One();
	}


	//	Draw shape only
	public void paint(Graphics g)
	{	super.paint(g);
		System.out.println("--> paint(.)");
		Graphics2D g2=(Graphics2D)g;
		g2.draw(shp);
	}

}