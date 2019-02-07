/* 
 * 1.1 version.
 */

import java.awt.*;
import java.applet.Applet;

/* 
 * Very simple applet that illustrates parameters to text-drawing methods.
 */

public class TextXY extends Applet {

    public void paint(Graphics g) {
        Dimension d = getSize();
        FontMetrics font=g.getFontMetrics();
        g.drawString("drawString() at (2, 5)", 2, font.getHeight());
        g.drawString("drawString() at (2, 30)", 2, 30);
        g.drawString("drawString() at (2, height)", 2, d.height-font.getDescent());
    }
}
