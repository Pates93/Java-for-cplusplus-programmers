/*
 * 1.1 version.
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/* 
 * This applet displays several images in a row.  It prevents
 * flashing by double buffering.  It preloads the images using
 * MediaTracker, which uses multiple background threads to 
 * download the images.  The program displays a "Please wait"
 * message until all the images are fully loaded.  
 */

public class MTImageSequence extends Applet 
                             implements Runnable {
    int frameNumber = -1;
    int delay;
    Thread animatorThread;
    boolean frozen = false;

    Image images[];
    MediaTracker tracker;

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

        //Load the images.
	images = new Image[10];
	tracker = new MediaTracker(this);
	for (int i = 1; i <= 10; i++) {
	    images[i-1] = getImage(getCodeBase(),
				   "T"+i+".gif");
	    tracker.addImage(images[i-1], 0);
	}

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
	//Start downloading the images. Wait until they're
	//loaded before requesting repaints.
	try {
	    tracker.waitForAll();
	} catch (InterruptedException e) {}

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

	//If not all the images are loaded,
	//just clear the background
	//and display a status string.
	if (!tracker.checkAll()) {
	    g.clearRect(0, 0, d.width, d.height);
	    g.drawString("Please wait...", 0, d.height/2);
	    return;
	}

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

        //Paint the frame into the image.
        offGraphics.drawImage(images[frameNumber%10],
		              0, 0, this);

        //Paint the image onto the screen.
        g.drawImage(offImage, 0, 0, this);
    }
}
