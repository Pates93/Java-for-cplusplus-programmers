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
{	int t=0;						// Tidsvariabel för animeringen
	static boolean running=false; 	// Semafor för att kunna stoppa animeringen
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
		{	t+=1; t=t%100; 			// Gå från ruta 99 tillbaka till ruta 0
			render();				// Rita om fönstret
			// Tiden för en ruta blir tiden för render() plus nedanstående tid.
			try
			{	Thread.sleep(20);	// Tiden för en ruta i millisekunder
			}
			catch(InterruptedException e){}
		}
	}

	private boolean validImage(Dimension d)
	{	// Kolla så att bilden är OK, åtgärda om möjligt
		if (d.width ==0 || d.height == 0) return false;
		if (buf == null || buf.getWidth(null) != d.width
			|| buf.getHeight(null) != d.height)
		{	buf=createImage(d.width, d.height);
		}
		return true;
	}

	void render()					// Dubbelbuffrad uppdatering av fönstret
	{	Graphics g = getGraphics();
		if (g != null)
		{	Dimension d=getSize();
			if (validImage(d))
			{	Graphics bufGraphics=buf.getGraphics();
				// Sudda bakgrunden, görs annars automatiskt före paint()
				bufGraphics.setColor(getBackground());
				bufGraphics.fillRect(0,0,d.width,d.height);
				bufGraphics.setColor(getForeground());
				// Rita med paint() i bufferbilden i stället för i fönstret
				paint(bufGraphics);
				// Kopiera buffertbilden till fönstret
				g.drawImage(buf,0,0,null);	// puts a paint request on the queue
				// Rensa upp temporära Graphics-object
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

