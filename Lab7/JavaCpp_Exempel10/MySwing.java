import java.awt.*;
import javax.swing.*;

public class MySwing extends MyFrame
{	MySwing()
	{	super();
		getContentPane().add(new MyComponent());
		setVisible(true);
	}

	public void paintComponent(Graphics g)
	{	System.out.println("paintComponent(.)");
	}

	public void paint(Graphics g)
	{	System.out.println("paint(.)");
		super.paint(g);
	}

	public static void main(String[] args){new MySwing();}

	class MyComponent extends JButton
	{
	}
}