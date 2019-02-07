import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Buttons extends JFrame
{	Buttons()
    {	super("Buttons");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize((int)((double)d.width*0.95),(int)((double)d.height*0.80));
		setLocation(new Point((int)((double)d.width*(0.02)),(int)((double)d.height*(0.02))));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container p=getContentPane();
        p.setLayout(new FlowLayout());
        for(int i=0;i<5;i++) p.add(new MyButton(i));
        for(int i=0;i<5;i++) p.add(new MyButton2(i));
        setVisible(true);
    }

    public static void main(String[] args){new Buttons();}

    class MyButton extends JButton
    {	MyButton(int i)
    	{	super(new Integer(i).toString(),new ImageIcon("images/sound.gif"));
		}
	}
    class MyButton2 extends JButton
    {	MyButton2(int i)
    	{	super(new Integer(i).toString(),new ImageIcon("images/gifIcon.gif"));
		}
	}
}
