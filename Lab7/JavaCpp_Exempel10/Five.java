import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.BasicStroke;
import java.awt.Stroke;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D.Double;

import java.util.Enumeration;
import java.util.Vector;

public class Five extends MyFrame
{	Vector<IMyShape> shps=new Vector<IMyShape>();

	Five()
	{	shps.add(new Ellipse(100,100,100,100));
		shps.add(new Rectangle(300,300,100,100));
		shps.add(new Ellipse(100,300,100,100));
		setVisible(true);
	}

	public static void main(String[] args)
	{	new Five();
	}

	//	Draw several shapes with green filler and red shape using my classes
	public void paint(Graphics g)
	{	super.paint(g);
		System.out.println("--> Five.paint(.)");
		Graphics2D g2=(Graphics2D)g;
		/*
		for(IMyShape shp:shps)
		{	shp.paint(g2);	// make the object paint itself
		}
		*/
	}

}

interface IMyShape extends Shape
{	public void paint(Graphics g);
}

class Ellipse extends java.awt.geom.Ellipse2D.Double implements IMyShape
{	Ellipse(double x, double y, double h, double w)
	{	super(x,y,h,w);
	}

	public void paint(Graphics g)
	{	System.out.println("--> Ellipse.paint(.)");
		Graphics2D g2=(Graphics2D)g;
		g2.setPaint(Color.red);
		g2.draw(this);
	}
}

class Rectangle extends java.awt.geom.Rectangle2D.Double implements IMyShape
{	Rectangle(double x, double y, double h, double w)
	{	super(x,y,h,w);
	}

	public void paint(Graphics g)
	{	System.out.println("--> Rectangle.paint(.)");
		Graphics2D g2=(Graphics2D)g;
		g2.setPaint(Color.blue);
		g2.draw(this);
	}
}