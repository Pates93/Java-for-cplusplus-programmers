import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.*;

public class Beeper2 extends JFrame
{	Beeper2()
		throws Exception
	{	super("Beeper2");
		add(panel);
        panel.addMouseListener(new MyMouseListener());
		pack();
		setLocation(100,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) throws Exception{new Beeper2();}

	private MyJPanel panel=new MyJPanel();
	private PrintStream out=System.out;
	private Audio leftAudio;
	private Audio rightAudio;
	private static final String LEFT="connect.wav";
	private static final String RIGHT="disconnect.wav";


	static final long serialVersionUID = 1481602159720926850L;

	class Audio extends Thread
	{	Audio(String fileName)
			throws UnsupportedAudioFileException,IOException
		{	Bytes buf=new Bytes(fileName);
			this.buf=buf.getBytes();
			ByteArrayInputStream bais=new ByteArrayInputStream(this.buf);
			AudioInputStream ais=AudioSystem.getAudioInputStream(bais);
			audioFormat=ais.getFormat();
			ais.close();
			start();
		}

		public void run()
		{	try
			{
				{	DataLine.Info sourceInfo=new DataLine.Info(
						SourceDataLine.class,
						audioFormat,
						AudioSystem.NOT_SPECIFIED);
					sourceLine=(SourceDataLine)AudioSystem.getLine(sourceInfo); // !!!

					sourceLine.open(audioFormat);
					sourceLine.start();
					int frameSize=audioFormat.getFrameSize();
					int j=sourceLine.write(buf,0,(int)((buf.length/frameSize))*frameSize);
					sourceLine.drain();
					sourceLine.stop();
					sourceLine.close();
					sourceLine=null;
				}

			}
			catch (Exception e521)
			{	System.out.println("e521="+e521);
			}
		}

		private SourceDataLine sourceLine;
 		private byte[] buf;
		private Bytes bytes;
		AudioFormat audioFormat;
	}

	class MyJPanel extends JTextArea
	{	MyJPanel()
		{	setPreferredSize(new Dimension(300,300));
		}

		static final long serialVersionUID = 1481602159720926850L;
	}

	class MyMouseListener extends MouseInputAdapter
	{	public void mousePressed(MouseEvent e)
		{	if (SwingUtilities.isLeftMouseButton(e))
			{	panel.setText(panel.getText()+"left mouse pressed\n");
				try{new Audio(LEFT);}catch (Exception e200){}
			}
			else if (SwingUtilities.isRightMouseButton(e))
			{	panel.setText(panel.getText()+"right mouse pressed\n");
				try{new Audio(RIGHT);}catch(Exception e300){}
			}
		}
	}

	class Bytes extends Vector<Buf>
	{	Bytes(String fileName)
			throws FileNotFoundException,IOException
		{	BufferedInputStream in=new BufferedInputStream(new FileInputStream(fileName));
			while(true)
			{	int available=in.available();
				byte[] buf=new byte[available];
				int size=in.read(buf,0,available);
				if (size<1) break;
				boolean b=add(new Buf(buf));
			}
		}

		byte[] getBytes()
		{	byte[] bytes=new byte[getSize()];
			int j=0;
			for(Iterator b=iterator();b.hasNext();)
			{	byte[] buf=((Buf)b.next()).getBytes();
				for(int i=0;i<buf.length;i++)bytes[j+i]=buf[i];
				j+=buf.length;
			}
			return bytes;
		}

		int getSize()
		{	int size=0;
			for(Iterator b=iterator();b.hasNext();){size+=((Buf)b.next()).size();}
			return size;
		}

		public String toString()
		{	String s="";
			s+="size="+getSize();
			for(int i=0;i<Math.min(10,getSize());i++) s+=getBytes()[i];
			return s;
		}

		static final long serialVersionUID = 1481602159720926850L;
	}

	class Buf
	{	Buf(byte[] buf){this.buf=buf;}
		byte[] getBytes(){return buf;}
		int size(){return buf.length;}
		private byte[] buf;
	}
}