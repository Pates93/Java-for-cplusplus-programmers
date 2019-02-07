/*
 * 1.1 version.
 */

import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

/* 
 * This displays a framed area.  When the user clicks within
 * the area, this program displays a dot and a string indicating
 * the coordinates where the click occurred.
 */

public class RectangleDemo extends Applet {
    RFramedArea framedArea;
    Label label;

    public void init() {
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();

        setLayout(gridBag);

        framedArea = new RFramedArea(this);
        c.fill = GridBagConstraints.BOTH;
        c.weighty = 1.0;
        c.gridwidth = GridBagConstraints.REMAINDER; //end row
        gridBag.setConstraints(framedArea, c);
        add(framedArea);

        label = new Label("Drag within the framed area.");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 1.0;
        c.weighty = 0.0;
        gridBag.setConstraints(label, c);
        add(label);
    }

    public void updateLabel(Rectangle rect) {
        label.setText("Rectangle goes from ("
                      + rect.x + ", " + rect.y + ") to ("
                      + (rect.x + rect.width - 1) + ", "
		      + (rect.y + rect.height - 1) + ").");
    }
}

/* This class exists solely to put a frame around the coordinate area. */
class RFramedArea extends Panel {
    public RFramedArea(RectangleDemo controller) {
        super();

        //Set layout to one that makes its contents as big as possible.
        setLayout(new GridLayout(1,0));

        add(new SelectionArea(controller));
    }

    public Insets getInsets() {
        return new Insets(4,4,5,5);
    }

    public void paint(Graphics g) {
        Dimension d = getSize();
        Color bg = getBackground();
 
        g.setColor(bg);
        g.draw3DRect(0, 0, d.width - 1, d.height - 1, true);
        g.draw3DRect(3, 3, d.width - 7, d.height - 7, false);
    }
}

class SelectionArea extends Canvas {
    Rectangle currentRect = null;
    RectangleDemo controller;

    public SelectionArea(RectangleDemo controller) {
        super();
        this.controller = controller;

	MyListener myListener = new MyListener();
	addMouseListener(myListener);
	addMouseMotionListener(myListener);
    }

    class MyListener extends MouseAdapter 
		     implements MouseMotionListener {
        public void mousePressed(MouseEvent e) {
	    int x = e.getX();
	    int y = e.getY();
	    currentRect = new Rectangle(x, y, 0, 0);
            repaint();
	}

	public void mouseDragged(MouseEvent e) {
	    updateSize(e);
	}

	public void mouseMoved(MouseEvent e) {
	}

        public void mouseReleased(MouseEvent e) {
	    updateSize(e);
	}

	void updateSize(MouseEvent e) {
	    int x = e.getX();
	    int y = e.getY();
	    currentRect.setSize(x - currentRect.x,
				y - currentRect.y);
	    repaint();
	}
    }

    public void paint(Graphics g) {
	//update has already cleared the previous rectangle,
	//so we dn't need to here.

        //If currentRect exists, paint a rectangle on top.
        if (currentRect != null) {
	    Dimension d = getSize();
	    Rectangle box = getDrawableRect(currentRect, d);
	    controller.updateLabel(box);

	    //Draw the box outline.
            g.drawRect(box.x, box.y, 
		       box.width - 1, box.height - 1);
        }
    }

    Rectangle getDrawableRect(Rectangle originalRect, 
			      Dimension drawingArea) {
        int x = originalRect.x;
        int y = originalRect.y;
        int width = originalRect.width;
        int height = originalRect.height;

        //Make sure rectangle width and height are positive.
        if (width < 0) {
            width = 0 - width;
            x = x - width + 1;
            if (x < 0) {
                width += x;
                x = 0;
            }
        }
        if (height < 0) {
            height = 0 - height;
            y = y - height + 1;
            if (y < 0) {
                height += y;
                y = 0;
            }
        }

        //The rectangle shouldn't extend past the drawing area.
        if ((x + width) > drawingArea.width) {
            width = drawingArea.width - x;
        }
        if ((y + height) > drawingArea.height) {
            height = drawingArea.height - y;
        }

	//If the width or height is 0, make it 1
	//so that the box is visible.
	if (width == 0) {
	    width = 1;
	}
	if (height == 0) {
	    height = 1;
	}

        return new Rectangle(x, y, width, height);
    }
}
