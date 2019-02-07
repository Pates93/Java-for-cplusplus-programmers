import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class MousePaint extends JPanel // implements MouseInputListener
{
   private static final int WIDTH=300, HEIGHT=300;
   private static final int LEFT=10;
   private static final int TOP=10;
   private static final int BORDER=30;

   private static final Color backColor=Color.gray;
   private static final Color lineColor=Color.red;

   private Point mouse=new Point();
   public void paintComponent(Graphics g){}
   public static void main(String args[])
   {	JFrame f=new JFrame("Drawing Window");
     	MousePaint mp=new MousePaint();
     	f.getContentPane().add(mp);
     	f.setSize(mp.WIDTH, mp.HEIGHT);
     	f.setVisible(true);
   }

}