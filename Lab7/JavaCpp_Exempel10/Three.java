import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Three extends MyFrame
{
	Shape shp=new Ellipse2D.Double(100,100,100,100);

	Three()
	{	setLayout(new BorderLayout());
		setVisible(true);
	}

	public static void main(String[] args)
	{	new Three();
	}

	//	Draw green circle, change color, draw red shape
	public void paint(Graphics g)
	{	Graphics2D g2=(Graphics2D)g;
		g2.setPaint(Color.green);
		g2.fill(shp);
		Stroke strk=new BasicStroke(2.0f);
		g2.setStroke(strk);
		g2.setPaint(Color.red);
		g2.draw(shp);
	}
}