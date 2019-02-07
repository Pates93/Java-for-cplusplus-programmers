/* 
 * 1.1 version.
 */

import java.awt.*;
import java.applet.Applet;

/* 
 * This displays a framed area containing one of 
 * each shape you can draw.
 */

public class ShapesDemo extends Applet {
    final static int maxCharHeight = 15;
    final static Color bg = Color.lightGray;
    final static Color fg = Color.black;

    public void init() {
        //Initialize drawing colors
        setBackground(bg);
        setForeground(fg);
    }

    public void paint(Graphics g) {
        Dimension d = getSize();
        int x = 5;
        int y = 7;
        int gridWidth = d.width / 7;
        int gridHeight = d.height / 2;
        int stringY = gridHeight - 7;
        int rectWidth = gridWidth - 2*x;
        int rectHeight = stringY - maxCharHeight - y;

        Color fg3D = Color.lightGray;

	// Draw the border.
        g.setColor(fg3D);
        g.draw3DRect(0, 0, d.width - 1, d.height - 1, true);
        g.draw3DRect(3, 3, d.width - 7, d.height - 7, false);
        g.setColor(fg);

        // drawLine(x1, y1, x2, y2) 
        g.drawLine(x, y+rectHeight-1, x + rectWidth, y);
        g.drawString("drawLine()", x, stringY);
        x += gridWidth;

        // drawRect(x, y, w, h) 
        g.drawRect(x, y, rectWidth, rectHeight);
        g.drawString("drawRect()", x, stringY);
        x += gridWidth;

        // draw3DRect(x, y, w, h, raised) 
        g.setColor(fg3D);
        g.draw3DRect(x, y, rectWidth, rectHeight, true);
        g.setColor(fg);
        g.drawString("draw3DRect()", x, stringY);
        x += gridWidth;

        // drawRoundRect(x, y, w, h, arcw, arch) 
        g.drawRoundRect(x, y, rectWidth, rectHeight, 10, 10);
        g.drawString("drawRoundRect()", x, stringY);
        x += gridWidth;

        // drawOval(x, y, w, h) 
        g.drawOval(x, y, rectWidth, rectHeight);
        g.drawString("drawOval()", x, stringY);
        x += gridWidth;

        // drawArc(x, y, w, h,int startAngle, int arcAngle) 
        g.drawArc(x, y, rectWidth, rectHeight, 90, 135);
        g.drawString("drawArc()", x, stringY);
        x += gridWidth;

        // drawPolygon(xPoints, yPoints, numPoints) 
        int x1Points[] = {x, x+rectWidth, x, x+rectWidth};
        int y1Points[] = {y, y+rectHeight, y+rectHeight, y};
        g.drawPolygon(x1Points, y1Points, x1Points.length); 
        g.drawString("drawPolygon()", x, stringY);

        // NEW ROW
        x = 5;
        y += gridHeight;
        stringY += gridHeight;

        // drawPolyline(xPoints, yPoints, numPoints) 
        // Note: drawPolygon would close the polygon.
        int x2Points[] = {x, x+rectWidth, x, x+rectWidth};
        int y2Points[] = {y, y+rectHeight, y+rectHeight, y};
        g.drawPolyline(x2Points, y2Points, x2Points.length); 
        g.drawString("drawPolyline()", x, stringY);
        x += gridWidth;

        // fillRect(x, y, w, h)
        g.fillRect(x, y, rectWidth, rectHeight);
        g.drawString("fillRect()", x, stringY);
        x += gridWidth;

        // fill3DRect(x, y, w, h, raised) 
        g.setColor(fg3D);
        g.fill3DRect(x, y, rectWidth, rectHeight, true);
        g.setColor(fg);
        g.drawString("fill3DRect()", x, stringY);
        x += gridWidth;

        // fillRoundRect(x, y, w, h, arcw, arch)
        g.fillRoundRect(x, y, rectWidth, rectHeight, 10, 10);
        g.drawString("fillRoundRect()", x, stringY);
        x += gridWidth;

        // fillOval(x, y, w, h)
        g.fillOval(x, y, rectWidth, rectHeight);
        g.drawString("fillOval()", x, stringY);
        x += gridWidth;

        // fillArc(x, y, w, h)
        g.fillArc(x, y, rectWidth, rectHeight, 90, 135);
        g.drawString("fillArc()", x, stringY);
        x += gridWidth;

        // fillPolygon(xPoints, yPoints, numPoints) 
        int x3Points[] = {x, x+rectWidth, x, x+rectWidth};
        int y3Points[] = {y, y+rectHeight, y+rectHeight, y};
        g.fillPolygon(x3Points, y3Points, x3Points.length); 
        g.drawString("fillPolygon()", x, stringY);
    }
}
