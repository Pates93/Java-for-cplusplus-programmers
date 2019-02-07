/*
 * 1.1 version.
 */

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.applet.Applet;

/* 
 * This applet displays an image. When the user enters 
 * an angle, the image is rotated to the specified angle.
 */

public class ImageRotator extends Applet
                          implements ActionListener {
    TextField degreeField;
    RotatorCanvas rotator;
    double radiansPerDegree = Math.PI / 180;

    public void init() {
        // Load the image.
        Image image = getImage(getCodeBase(), 
			       "rocketship.gif");

        //Set up the UI.
        GridBagLayout gridBag = new GridBagLayout();
        GridBagConstraints c = new GridBagConstraints();
        setLayout(gridBag);

        Label l = new Label("Number of degrees to "
			    + "rotate the image:");
        gridBag.setConstraints(l, c);
        add(l);

        degreeField = new TextField(5);
	degreeField.addActionListener(this);
        gridBag.setConstraints(degreeField, c);
        add(degreeField);

        Button b = new Button("Redraw image");
	b.addActionListener(this);
        c.gridwidth = GridBagConstraints.REMAINDER;
        gridBag.setConstraints(b, c);
        add(b);

        rotator = new RotatorCanvas(image);
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 1.0;
        c.weighty = 1.0;
        gridBag.setConstraints(rotator, c);
        add(rotator);

        validate();
    }

    public void actionPerformed(ActionEvent e) {
        int degrees;

        try {
            degrees = Integer.parseInt(degreeField.getText());
        } catch (NumberFormatException exc) {
            degrees = 0;
        }

        //Convert to radians.
        rotator.rotateImage((double)degrees * radiansPerDegree);
    }
}

class RotatorCanvas extends Canvas {
    Image sourceImage;
    Image resultImage;

    public RotatorCanvas(Image image) {
        sourceImage = image;
        resultImage = sourceImage;
    }

    public void rotateImage(double angle) {
        ImageFilter filter = new RotateFilter(angle);
        ImageProducer producer = new FilteredImageSource(
                                        sourceImage.getSource(),
                                        filter);
        resultImage = createImage(producer);
        repaint();
    }

    public void paint(Graphics g) {
        Dimension d = getSize();
        int x = (d.width - resultImage.getWidth(this)) / 2;
        int y = (d.height - resultImage.getHeight(this)) / 2;

        g.drawImage(resultImage, x, y, this); 
    }
}

