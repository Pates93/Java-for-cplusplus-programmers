import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;

import java.util.Vector;
import java.util.Iterator;

import javax.swing.JPanel;

interface IMyShape extends Shape
{	public void paint(Graphics g);
	public boolean add(IMyShape component);
	public void move(Point2D origo);
}

public class MyShapeX extends javax.swing.JFrame
{	private MyShapeX()
	{	System.out.println("--> MyShape()");
		setTitle("MyShape");

		{	// --- Create objects
			//
			{	// --- rectangle
				IMyShape r=new Rectangle(new Point2D.Double(50,50),new Point2D.Double(300,300));
				for(int i=0;i<3;i++)
				{	r.add(new Circle(new Point2D.Double(i*5+100,i*5+100),100));
				}
				components.add(r);
			}

			/*
			{	// --- triangle
				IMyShape r=new Triangle(new Point2D.Double(50,350),new Point2D.Double(600,500),new Point2D.Double(150,650));
				for(int i=0;i<3;i++)
				{	r.add(new Rectangle(new Point2D.Double(i*10+10,i*10+10),new Point2D.Double(i*10+20,i*10+120)));
				}
				components.add(r);
			}
			*/

			{	// --- circle
				IMyShape r=new Circle(new Point2D.Double(350,350),300);
				for(int i=0;i<3;i++)
				{	r.add(new Rectangle(new Point2D.Double(i*10+10,i*10+10),new Point2D.Double(i*10+30,i*10+30)));
				}
				components.add(r);
			}
		}

		JPanel pane=new JPanel();
		pane.setSize(800,700);
		pane.setLayout(new BorderLayout());
		setContentPane(pane);
		setSize(800,700);
		setVisible(true);
		repaint();
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {System.exit(0);}
        });

	}

	public void paint(Graphics g)
	{	super.paint(g);
		System.out.println("--> MyShape.paint(.)");
		for(IMyShape s:components) s.paint(g);
	}

	private Vector<IMyShape> components=new Vector<IMyShape>();

	private class Triangle extends java.awt.geom.Rectangle2D.Double
		implements IMyShape
	{	public Triangle(Point2D a, Point2D b, Point2D c)
		{	// super(a.getX(),a.getY(),b.getX(),b.getY());
			this.a=a;
			this.b=b;
			this.c=c;
		}

		public void paint(Graphics g)
		{	System.out.println("--> Triangle.paint(.)");
			Graphics2D g2=(Graphics2D)g;
			java.lang.Double x_a=new java.lang.Double(a.getX());
			java.lang.Double y_a=new java.lang.Double(a.getY());
			java.lang.Double x_b=new java.lang.Double(b.getX());
			java.lang.Double y_b=new java.lang.Double(b.getY());
			java.lang.Double x_c=new java.lang.Double(c.getX());
			java.lang.Double y_c=new java.lang.Double(c.getY());
			g2.setColor(Color.green);
			g2.drawLine(x_a.intValue(),y_a.intValue(),x_b.intValue(),y_b.intValue());
			g2.drawLine(x_b.intValue(),y_b.intValue(),x_c.intValue(),y_c.intValue());
			g2.drawLine(x_c.intValue(),y_c.intValue(),x_a.intValue(),y_a.intValue());
			g2.fill(this);
			for(Iterator i=components.iterator();i.hasNext();)
			{	IMyShape s=(IMyShape)i.next();
				s.paint(g);
			}
		}

		public boolean add(IMyShape myShape)
		{	myShape.move(a);
			return components.add(myShape);
		}

		public void move(Point2D origo)
		{	System.out.println("--> Triangle.move("+origo+")");
			a=new Point2D.Double(a.getX()+origo.getX(),a.getY()+origo.getY());
			b=new Point2D.Double(b.getX()+origo.getX(),b.getY()+origo.getY());
			c=new Point2D.Double(c.getX()+origo.getX(),c.getY()+origo.getY());
			setLocation((new java.lang.Double(origo.getX())).intValue(),(new java.lang.Double(origo.getY())).intValue());
		}

		private Point2D a,b,c;
		private Vector<IMyShape> components=new Vector<IMyShape>();
	}

	private class Rectangle extends java.awt.geom.Rectangle2D.Double
		implements IMyShape
	{	public Rectangle(Point2D upperLeft, Point2D lowerRight)
		{	super(upperLeft.getX(),upperLeft.getY(),lowerRight.getX(),lowerRight.getY());
			this.upperLeft=upperLeft;
			this.lowerRight=lowerRight;
		}

		public void paint(Graphics g)
		{	System.out.println("--> Rectangle.paint("+upperLeft+","+lowerRight+")");
			Graphics2D g2=(Graphics2D)g;
			g2.setColor(Color.blue);
			g2.draw(this);

			for(IMyShape s:components)s.paint(g);
		}

		public boolean add(IMyShape myShape)
		{	myShape.move(upperLeft);
			return this.components.add(myShape);
		}

		public void move(Point2D origo)
		{	System.out.println("--> Rectangle.move("+origo+")");
			// upperLeft=new Point2D.Double(upperLeft.getX()+origo.getX(),upperLeft.getY()+origo.getY());
			// lowerRight=new Point2D.Double(lowerRight.getX()+origo.getX(),lowerRight.getY()+origo.getY());
			double x=upperLeft.getX()+origo.getX();
			double y=upperLeft.getY()+origo.getY();
			double w=lowerRight.getX()-upperLeft.getX();
			double h=lowerRight.getY()-upperLeft.getY();
			System.out.println("x="+x+"  y="+y);
			// setLocation((new java.lang.Double(x)).intValue(),(new java.lang.Double(y)).intValue());
			// setLocation(400,400);
			// setRect(400D,400D,100D,100D);
			setRect(x,y,w,h);
		}

		private Point2D upperLeft,lowerRight;
		private Vector<IMyShape> components=new Vector<IMyShape>();
	}

	private class Circle extends java.awt.geom.Ellipse2D.Double
		implements IMyShape
	{	public Circle(Point2D origo, double radius)
		{	super(origo.getX(),origo.getY(),radius,radius);
			this.origo=origo;
			this.radius=radius;
		}

		public void paint(Graphics g)
		{	System.out.println("--> Circle.paint(.)");
			Graphics2D g2=(Graphics2D)g;
			java.lang.Double x=new java.lang.Double(origo.getX());
			java.lang.Double y=new java.lang.Double(origo.getY());
			java.lang.Double r=new java.lang.Double(radius);
			g2.setColor(Color.red);
			// g2.drawOval(x.intValue(),y.intValue(),r.intValue(),r.intValue());
			g2.draw(this);

			for(IMyShape s:components) s.paint(g);
		}

		public boolean add(IMyShape myShape)
		{	myShape.move(origo);
			return this.components.add(myShape);
		}

		public void move(Point2D origo)
		{	System.out.println("--> Circle.move("+origo+")");
			double x=this.origo.getX()+origo.getX();
			double y=this.origo.getY()+origo.getY();

			this.origo=new Point2D.Double(x,y);
			setLocation((new java.lang.Double(x)).intValue(),(new java.lang.Double(y)).intValue());
		}

		private Point2D origo;
		private double radius;
		private Vector<IMyShape> components=new Vector<IMyShape>();
	}

	public static void main(String[] args)
	{	new MyShapeX();
	}
}