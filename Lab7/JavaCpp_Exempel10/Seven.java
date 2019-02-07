import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.BasicStroke;
import java.awt.Stroke;
import java.awt.Image;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D.Double;

import java.util.Enumeration;
import java.util.Vector;

public class Seven extends MyFrame implements Runnable
{	int t=0;						// Tidsvariabel f�r animeringen
	static boolean running=false; 	// Semafor f�r att kunna stoppa animeringen
	private Image buf;				// Dubbelbuffert;

	Seven()
	{	running=true;
		setVisible(true);
		new Thread(this).start();
	}

	public static void main(String[] args)
	{	new Seven();
	}

	public void run()
	{	while(running)
		{	t+=1; t=t%100; 			// G� fr�n ruta 99 tillbaka till ruta 0
			render();				// Rita om f�nstret
			// Tiden f�r en ruta blir tiden f�r render() plus nedanst�ende tid.
			try
			{	Thread.sleep(20);	// Tiden f�r en ruta i millisekunder
			}
			catch(InterruptedException e){}
		}
	}

	private boolean validImage(Dimension d)
	{	// Kolla s� att bilden �r OK, �tg�rda om m�jligt
		if (d.width ==0 || d.height == 0) return false;
		if (buf == null || buf.getWidth(null) != d.width
			|| buf.getHeight(null) != d.height)
		{	buf=createImage(d.width, d.height);
		}
		return true;
	}

	void render()					// Dubbelbuffrad uppdatering av f�nstret
	{	Graphics g = getGraphics();
		if (g != null)
		{	Dimension d=getSize();
			if (validImage(d))
			{	Graphics bufGraphics=buf.getGraphics();
				// Sudda bakgrunden, g�rs annars automatiskt f�re paint()
				bufGraphics.setColor(getBackground());
				bufGraphics.fillRect(0,0,d.width,d.height);
				bufGraphics.setColor(getForeground());
				// Rita med paint() i bufferbilden i st�llet f�r i f�nstret
				paint(bufGraphics);
				// Kopiera buffertbilden till f�nstret
				g.drawImage(buf,0,0,null);	// puts a paint request on the queue
				// Rensa upp tempor�ra Graphics-object
				bufGraphics.dispose();
			}
			g.dispose();
		}
	}

	//	Draw circles using dubble buffering
	public void paint(Graphics g)
	{	Graphics2D g2=(Graphics2D)g;
		Shape shp=new Ellipse2D.Double(100,100,2*t,2*t);
		g2.setPaint(Color.black);
		g2.fill(shp);
		// g2.draw(shp);
	}
}

