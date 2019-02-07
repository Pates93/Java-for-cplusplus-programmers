import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import java.awt.geom.Ellipse2D;

public class Two extends MyFrame
{
	Shape shp=new Ellipse2D.Double(100,100,100,100);

	Two()
	{	setVisible(true);
	}

	public static void main(String[] args)
	{	new Two();
	}

	//	Draw shape and fill circle
	public void paint(Graphics g)
	{	Graphics2D g2=(Graphics2D)g;
		g2.draw(shp);
		g2.fill(shp);
	}
}