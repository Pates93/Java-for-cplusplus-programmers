/*
 * This applet's code is the same in both 1.0 and 1.1.
 */

import java.awt.*;
import java.applet.Applet;

/* 
 * This applet displays a single image twice,
 * once at its normal size and once much wider.
 */

public class ImageDisplayer extends Applet {
    Image image;

    public void init() {
        image = getImage(getCodeBase(), "rocketship.gif");
    }

    public void paint(Graphics g) {
        //Draw image at its natural size first.
        g.drawImage(image, 0, 0, this); //85x62 image

        //Now draw the image scaled.
        g.drawImage(image, 90, 0, 300, 62, this);
    }
}

