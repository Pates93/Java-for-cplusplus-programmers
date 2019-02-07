import java.io.*;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

import javax.swing.*;
import javax.swing.tree.*;
import javax.swing.event.*;

public class LookAndFeel extends JFrame
{	private LookAndFeel(String[] args)
	{	try
		{	UIManager.setLookAndFeel(children[index]);
			SwingUtilities.updateComponentTreeUI(this);
			JPanel contentPane=new JPanel(new BorderLayout());
			tree=new JTree(new JTree.DynamicUtilTreeNode(parent,children));
			tree.addTreeSelectionListener(new MyTreeSelectionListener() );
			text=new JTextArea(children[index]);
			contentPane.add(new JScrollPane(tree),BorderLayout.WEST);
			contentPane.add(new JScrollPane(text),BorderLayout.EAST);
			setContentPane(contentPane);
			pack();
			setLocation(100,100);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			// text.addMouseListener(new MyMouseListener());
			frame=this;
			setTitle(children[index]);
			setVisible(true);
		}
		catch (Exception e300){out.println("e300="+e300);}
	}

	public static void main(String[] args)
	{	try
		{	if(0<args.length) index=Integer.parseInt(args[0]);
		}
		catch (Exception e200){out.println("e200="+e200);}

		new LookAndFeel(args);
	}

	private static int index=0;
	private JFrame frame;
	private JTree tree;
	private JTextArea text;
	private String gui;

	private static String parent="LookAndFeel";
	private static String[] children=
		{	"com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
			"com.sun.java.swing.plaf.gtk.GTKLookAndFeel",
			"javax.swing.plaf.metal.MetalLookAndFeel",
			"com.sun.java.swing.plaf.motif.MotifLookAndFeel"
		};

	private static PrintStream out;
	static {out=System.out;}

	class MyTreeSelectionListener
		implements TreeSelectionListener
	{
		public void valueChanged(javax.swing.event.TreeSelectionEvent e)
		{	TreePath[] treePaths=e.getPaths();
			for(int i=0;i<treePaths.length;i++)
			{	TreePath treePath=treePaths[i];
				Object[] os=treePath.getPath();
				for(int j=0;j<os.length;j++)
				{	Object o=os[j];
					out.print(o);
					if (j<(os.length-1)) out.print(",");
				}
				out.println();
			}
			out.println();
		}
	}

	/*
	class MyMouseListener extends MouseInputAdapter
	{	public void mousePressed(MouseEvent e)
		{	try
			{	out.println("mouse pressed");
				out.flush();
				index++;
				index=index%children.length;
				UIManager.setLookAndFeel(children[index]);
				setTitle(children[index]);
				text.setText(children[index]);
				SwingUtilities.updateComponentTreeUI(frame);
				frame.repaint();
			}
			catch(Exception e100){out.println("e100="+e100);}
			// frame.pack();
		}
	}
	*/
}