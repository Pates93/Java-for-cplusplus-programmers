import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.*;

public class MyEvent extends JFrame
{	MyEvent()
		throws Exception
	{	super("MyEvent");
		getContentPane().add(panel);
        panel.addMouseListener(new MyMouseListener());
		pack();
		setLocation(100,100);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				System.exit(0);
			}
			public void windowActivated(WindowEvent e) {
				System.out.println("windowActivated");
			}
		});
		frame=this;
		System.out.println("frame="+frame.getClass().getName());
		setVisible(true);
	}

	public static void main(String[] args) throws Exception{new MyEvent();}

	private MyJPanel panel=new MyJPanel();
	private PrintStream out=System.out;
	private JFrame frame;

	class MyJPanel extends JTextArea
	{	MyJPanel()
		{	setPreferredSize(new Dimension(300,300));
		}
	}

	class MyMouseListener extends MouseInputAdapter
	{	public void mousePressed(MouseEvent e)
		{	if (SwingUtilities.isLeftMouseButton(e))
			{	panel.setText(panel.getText()+"left mouse pressed\n");
			}
			else if (SwingUtilities.isRightMouseButton(e))
			{	panel.setText(panel.getText()+"right mouse pressed\n");
				WindowEvent event=new WindowEvent(frame,1);
				fireWindowEvent(event);

				/*
				ActionListener[] wls = (ActionListener[])(frame.getListeners(ActionListener.class));
				for(int i=0;i< (wls.length);i++)
				{	ActionListener wl=wls[i];
					System.out.println("wls["+i+"]="+wls[i].getClass().getName());
					// if (wl==frame)
					{	System.out.println("dispatching");
						// wl.dispatchEvent(actionEvent);
						// ((WindowListener)wls[i]).dispatchEvent(windowEvent);
					}

				}
				*/

				/*
				{	EventQueue eventQueue=new EventQueue();
					eventQueue.postEvent(windowEvent);
					eventQueue.push(eventQueue);
				}
				*/
			}
		}

		private void fireWindowEvent(WindowEvent event)
		{	System.out.println("--> fireWindowEvent");
			// Vector currentListeners=new Vector();
			WindowListener[] wls=null;
			synchronized(this){
				wls = (WindowListener[])(frame.getListeners(WindowListener.class));
			}
			System.out.println("fireWindowEvent wls="+wls.length);
			for (int i=0;i<wls.length;i++)
			{	WindowListener listener
					= (WindowListener)wls[i];
				System.out.println("listener="+listener.getClass().getName());
				// if (listener==frame)
				{	System.out.println("listener==frame");
					frame.dispatchEvent(event);
				}
			}
		}


	}

}