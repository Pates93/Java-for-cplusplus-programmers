/*
 * 1.1 version.
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/* 
 * This applet moves an image in front of a background image.
 * It eliminates flashing by double buffering.
 */

public class MovingImage extends Applet 
                         implements Runnable {
    int frameNumber = -1;
    int delay;
    Thread animatorThread;
    boolean frozen = false;

    Image stars;
    Image rocket;

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

        //Get the images.
        stars = getImage(getCodeBase(),
                         "starfield.gif");
        rocket = getImage(getCodeBase(),
                          "rocketship.gif");

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
        paintFrame(offGraphics);

        //Paint the image onto the screen.
        g.drawImage(offImage, 0, 0, this);
    }

    void paintFrame(Graphics g) {
        Dimension d = getSize();
        int w;
        int h;

        //If we have a valid width and height for the 
        //background image, draw it.
        w = stars.getWidth(this);
        h = stars.getHeight(this);
        if ((w > 0) && (h > 0)) {
            g.drawImage(stars, 
                        (d.width - w)/2,
                        (d.height - h)/2, this);
        }

        //If we have a valid width and height for the 
        //foreground image, draw it.
        w = rocket.getWidth(this);
        h = rocket.getHeight(this);
        if ((w > 0) && (h > 0)) {
            g.drawImage(rocket, 
                        ((frameNumber*5) % (w + d.width)) - w,
                        (d.height - h)/2, this);
        }
    }
}
