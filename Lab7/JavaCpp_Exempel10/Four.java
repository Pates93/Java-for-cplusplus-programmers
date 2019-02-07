import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.BasicStroke;
import java.awt.Stroke;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

import java.util.Enumeration;
import java.util.Vector;

public class Four extends MyFrame
{	Vector<Shape> shps=new Vector<Shape>();

	Four()
	{	shps.add(new Ellipse2D.Double(100,100,100,100));
		shps.add(new Rectangle2D.Double(300,300,100,100));
		shps.add(new Ellipse2D.Double(100,300,100,100));
		setVisible(true);
	}

	public static void main(String[] args)
	{	new Four();
	}

	//	Draw several shapes with green filler and red shape using standard classes
	public void paint(Graphics g)
	{	System.out.println("-> paint(.)");
		Graphics2D g2=(Graphics2D)g;
		for(Shape shp:shps)
		{	g2.setPaint(Color.green);
			g2.fill(shp);
			Stroke strk=new BasicStroke(2.0f);
			g2.setStroke(strk);
			g2.setPaint(Color.red);
			g2.draw(shp);
		}
	}
}