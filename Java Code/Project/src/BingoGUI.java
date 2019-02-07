import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
* <h1>Project</h1>
* This class is responsible for the JFrame. 
* It will display the numbers, and the create 
* and save option.
* 
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since  19-01-2018
*/

public class BingoGUI extends JFrame implements ActionListener {

	private JMenuItem saveOption;
	private JMenuItem createOption;
	private JMenuItem exitOption;
	private JFrame bingo;
	private List<String> card;

	//Constructor
	public BingoGUI() {

		bingo = new JFrame("Bingo");
		bingo.setSize(500, 250);
		bingo.setLocation(500, 350);
		bingo.setVisible(true);
		bingo.setResizable(true);
		bingo.setDefaultCloseOperation(EXIT_ON_CLOSE);

		bingo.setPreferredSize(new Dimension(500, 150));

		//Making 5 balls and adding them to the frame
		BingoCaller caller = new BingoCaller();
		caller.addBingoBall(new BingoBall(1));
		caller.addBingoBall(new BingoBall(31));
		caller.addBingoBall(new BingoBall(41));
		caller.addBingoBall(new BingoBall(61));
		caller.addBingoBall(new BingoBall(18));
		bingo.add(caller, BorderLayout.NORTH);
		bingo.pack();

		//Making the menu bar
		JMenuBar menubar = new JMenuBar();
		// Making a fileMenu
		JMenu fileMenu = new JMenu("File");
		createOption = new JMenuItem("Create...");
		saveOption = new JMenuItem("Save...");
		exitOption = new JMenuItem("Exit");
		exitOption.setToolTipText("Exit application");

		//Adding the options into the file menu
		fileMenu.add(createOption);
		fileMenu.add(saveOption);
		fileMenu.addSeparator();
		fileMenu.add(exitOption);

		// Adding the fileMenu into the menuBar
		menubar.add(fileMenu);

		// Adding actions listeners on the options
		exitOption.addActionListener(this);
		createOption.addActionListener(this);
		saveOption.addActionListener(this);

		// Setting the menubar
		bingo.setJMenuBar(menubar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Getting info of what the user choose in the filemenu
		JMenuItem source = (JMenuItem) e.getSource();
		
		BingoCards temp = new BingoCards();
		if (source == exitOption) {
			System.exit(0);// Quitting the program
		} else if (source == createOption) {
			card = temp.createCard();//Calling the createcard function
			for (int i = 0; i < 7; i++) {
				System.out.println(card.get(i)); //Printing out the card which was created
			}
		} else if (source == saveOption) {
			BingoCards.saveCard(); //Saving the card
		}
	}
}
