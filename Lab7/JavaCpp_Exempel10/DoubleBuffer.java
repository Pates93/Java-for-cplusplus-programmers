/*
 * 1.1 version.
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/*
 * This applet animates graphics that it generates.  This
 * example eliminates flashing by double buffering.
 */

public class DoubleBuffer extends Applet
        	          implements Runnable {
    int frameNumber = -1;
    int delay;
    Thread animatorThread;
    boolean frozen = false;

    int squareSize = 20;
    boolean fillColumnTop = true;

    Dimension offDimension;
    Image offImage;
    Graphics offGraphics;

    public void init() {
        String str;
        int fps = 10;

        //How many milliseconds between frames?
        str = getParameter("fps");
        try {
            if (str != null) {
                fps = Integer.parseInt(str);
            }
        } catch (Exception e) {}
        delay = (fps > 0) ? (1000 / fps) : 100;

        //How many pixels wide is each square?
        str = getParameter("squareWidth");
        try {
            if (str != null) {
                squareSize = Integer.parseInt(str);
            }
        } catch (Exception e) {}

        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (frozen) {
                    frozen = false;
                    start();
                } else {
                    frozen = true;

		    //Instead of calling stop(), which destroys the
		    //backbuffer, just stop the animating thread.
		    animatorThread = null;
                }
            }
       });
    }

    public void start() {
        if (frozen) {
            //Do nothing.  The user has requested that we
            //stop changing the image.
        } else {
            //Start animating!
            if (animatorThread == null) {
                animatorThread = new Thread(this);
            }
            animatorThread.start();
        }
    }

    public void stop() {
        //Stop the animating thread.
        animatorThread = null;

	//Get rid of the objects necessary for double buffering.
	offGraphics = null;
	offImage = null;
    }

    public void run() {
        //Just to be nice, lower this thread's priority
        //so it can't interfere with other processing going on.
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);

        //Remember the starting time.
        long startTime = System.currentTimeMillis();

        //Remember which thread we are.
        Thread currentThread = Thread.currentThread();

        //This is the animation loop.
        while (currentThread == animatorThread) {
            //Advance the animation frame.
            frameNumber++;

            //Display it.
            repaint();

            //Delay depending on how far we are behind.
            try {
                startTime += delay;
                Thread.sleep(Math.max(0,
                             startTime-System.currentTimeMillis()));
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    //Draw the current frame of animation.
    public void paint(Graphics g) {
	update(g);
    }

    public void update(Graphics g) {
        Dimension d = getSize();
        boolean fillSquare;
        boolean fillNextFrame;
        int rowWidth = 0;
        int x = 0, y = 0;
        int w, h;
        int tmp;

		//Create the offscreen graphics context,
		//if no good one exists.
		if ( (offGraphics == null)
		  || (d.width != offDimension.width)
		  || (d.height != offDimension.height) ) {
			offDimension = d;
			offImage = createImage(d.width, d.height);
			offGraphics = offImage.getGraphics();
		}

		//Erase the previous image.
		offGraphics.setColor(getBackground());
		offGraphics.fillRect(0, 0, d.width, d.height);
		offGraphics.setColor(Color.black);

        //Set width of first "square". Decide whether to fill it.
        fillSquare = fillColumnTop;
        fillColumnTop = !fillColumnTop;
        tmp = frameNumber % squareSize;
        if (tmp == 0) {
            w = squareSize;
            fillNextFrame = !fillSquare;
        } else {
            w = tmp;
            fillNextFrame = fillSquare;
        }

        //Draw from left to right.
        while (x < d.width) {
            int colHeight = 0;

            //Draw the column.
            while (y < d.height) {
                colHeight += squareSize;

                //If we don't have room for a full square, cut if off.
                if (colHeight > d.height) {
                    h = d.height - y;
                } else {
                    h = squareSize;
                }

                //Draw the rectangle if necessary.
                if (fillSquare) {
                    offGraphics.fillRect(x, y, w, h);
                    fillSquare = false;
                } else {
                    fillSquare = true;
                }

                y += h;
            } //while y

            //Determine x, y, and w for the next go around.
            x += w;
            y = 0;
            w = squareSize;
            rowWidth += w;
            if (rowWidth > d.width) {
                w = d.width - x;
            }
            fillSquare = fillColumnTop;
            fillColumnTop = !fillColumnTop;
        } //while x
        fillColumnTop = fillNextFrame;

		//Paint the image onto the screen.
		g.drawImage(offImage, 0, 0, this);
    }
}
