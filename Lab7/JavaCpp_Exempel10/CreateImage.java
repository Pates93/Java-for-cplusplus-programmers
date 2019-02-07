import java.awt.*;
import java.awt.image.*;
import java.applet.Applet;

public class CreateImage extends Applet{
Image img;
public void init(){

int w = 100;
int h = 100;
int[] pix = new int[w * h];
int index = 0;
for (int y = 0; y < h; y++) {
    int red = (y * 255) / (h - 1);
    for (int x = 0; x < w; x++) {
          int blue = (x * 255) / (w - 1);
          pix[index++] = (255 << 24) | (red << 16) | blue;
    }
}
img = createImage(new MemoryImageSource(w, h, pix, 0, w));

}
public void paint(Graphics g){
g.drawImage(img,0,0,this);

}}