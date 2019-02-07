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

public class Six extends MyFrame implements Runnable
{	int t=0;						// Tidsvariabel för animeringen
	static boolean running=false; 	// Semafor för att kunna stoppa animeringen

	Six()
	{	running=true;
		setVisible(true);
		new Thread(this).start();
	}

	public static void main(String[] args)
	{	new Six();
	}

	public void run()
	{	while(running)
		{	t+=1; t=t%100; 			// Gå från ruta 99 tillbaka till ruta 0
			repaint();				// Be att fönstret ritas om vid tillfälle
			try
			{	Thread.sleep(40);	// Tiden för en ruta i millisekunder
			}
			catch(InterruptedException e){}
		}
	}

	//	Draw circles shifted delta-x and delta-y for every instance
	public void paint(Graphics g)
	{	Graphics2D g2=(Graphics2D)g;
		Shape shp=new Ellipse2D.Double(100,100,2*t,2*t);
		g2.setPaint(Color.black);
		g2.fill(shp);
		// g2.draw(shp);
	}
}

