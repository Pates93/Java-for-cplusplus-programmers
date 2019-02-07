import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
* <h1>Project</h1>
* This class is responsible for showing the bingoballs
* which are generated. Based on the number the ball has,
* a image will be shown with the balls number.
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since  19-01-2018
*/

public class BingoCaller extends JPanel{

	JPanel panel;

	//Constructor
	public BingoCaller() {
		panel = new JPanel();
		panel.setVisible(true);
		panel.setPreferredSize(new Dimension(1000, 550));
	}

	
	//Adding a bingoball
	public void addBingoBall(BingoBall ball) {

		//If the number is between 1 and 15
		if (ball.getNumber() >= 1 && ball.getNumber() <= 15) {
			ImageIcon image = new ImageIcon("red.png"); //Get the red ball
			JLabel label = new JLabel(image); //Put the image into a label
			label.setLayout(new FlowLayout(FlowLayout.CENTER)); //set the layout to be center
			JLabel text = new JLabel(ball.getStringNumber()); //Getting the string number ex. "B1"
			text.setFont(new Font("Verdana", Font.BOLD, 30));//Setting the type and size of the text
			text.setForeground(Color.white); //Making the text while
			text.setHorizontalAlignment(10); //Setting horizontal alignment to be 10
			label.add(text); //Add the text to the label
			add(label); //Add the label to JPanel


		}
		if (ball.getNumber() >= 16 && ball.getNumber() <= 30) {
			ImageIcon image = new ImageIcon("blue.png");
			JLabel label = new JLabel(image);
			label.setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel text = new JLabel(ball.getStringNumber());
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.CENTER);
			text.setFont(new Font("Verdana", Font.BOLD, 30));
			text.setForeground(Color.white);
			text.setHorizontalAlignment(10);
			label.add(text);
			add(label);

		}
		if (ball.getNumber() >= 31 && ball.getNumber() <= 45) {
			ImageIcon image = new ImageIcon("pink_light.png");
			JLabel label = new JLabel(image);
			label.setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel text = new JLabel(ball.getStringNumber());
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.CENTER);
			text.setFont(new Font("Verdana", Font.BOLD, 30));
			text.setForeground(Color.white);
			text.setHorizontalAlignment(10);
			label.add(text);
			add(label);


		}
		if (ball.getNumber() >= 46 && ball.getNumber() <= 60) {
			ImageIcon image = new ImageIcon("grey_dark.png");
			JLabel label = new JLabel(image);
			label.setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel text = new JLabel(ball.getStringNumber());
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.CENTER);
			text.setFont(new Font("Verdana", Font.BOLD, 30));
			text.setForeground(Color.white);
			text.setHorizontalAlignment(10);
			label.add(text);
			add(label);


		}
		if (ball.getNumber() >= 61 && ball.getNumber() <= 75) {
			ImageIcon image = new ImageIcon("brown_light.png");
			JLabel label = new JLabel(image);
			label.setLayout(new FlowLayout(FlowLayout.CENTER));
			JLabel text = new JLabel(ball.getStringNumber());
			label.setHorizontalTextPosition(JLabel.CENTER);
			label.setVerticalTextPosition(JLabel.CENTER);
			text.setFont(new Font("Verdana", Font.BOLD, 30));
			text.setForeground(Color.white);
			text.setHorizontalAlignment(10);
			label.add(text);
			add(label);


		}
	}
}
