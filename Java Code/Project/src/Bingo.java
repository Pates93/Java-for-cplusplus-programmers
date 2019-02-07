import javax.swing.SwingUtilities;

/*
* <h1>Project</h1>
* This class is the starting point for the bingo application.
* It creates our JFrame and makes it visible.
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since  19-01-2018
*/
public class Bingo {


	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new BingoGUI().setVisible(true);
			}
		});		
	}

}
