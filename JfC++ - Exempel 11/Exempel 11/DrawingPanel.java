import java.awt.*;
import javax.swing.*;

public class DrawingPanel extends JPanel {
	
	@Override
	public void paintComponent(Graphics g) {
		getDrawableLine(0, 0, 300, 300).draw(g);
		getDrawableLine(300, 0, 0, 300).draw(g);
	}
	
	public Drawable getDrawableLine(int x1, int y1, int x2, int y2) {
		return g -> { g.drawLine(x1, y1, x2, y2); };
	}
}