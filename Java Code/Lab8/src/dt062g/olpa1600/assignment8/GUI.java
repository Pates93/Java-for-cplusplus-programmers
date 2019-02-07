package dt062g.olpa1600.assignment8;


import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.FlowLayout;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


import javax.swing.ImageIcon;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javax.swing.JTextArea;

import javax.swing.border.BevelBorder;

import dt062g.olpa1600.assignment8.client.Client;

/*
* <h1>Assignment 7</h1>
* 
* This class is used to create the graphical user interface. Using JFrame, we create some
* options for the user, using the menubar. The user can use the drawing panel, so see coordinates, and can pick
* a color.
* 
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since   24-12-2017
*/
public class GUI extends JFrame implements ActionListener, MouseListener, MouseMotionListener {

	/**
	 * 
	 */
//	private Drawing drawing = new Drawing();
	private DrawingPanel drawingPanel = new DrawingPanel();
	private JFrame myFrame = new JFrame();
	private JPanel jpanel = new JPanel(new GridLayout());
	JLabel banner = new JLabel();
	protected JTextArea textArea;
	private JMenuItem nameOption;
	private JMenuItem authorOption;
	private JMenuItem exitOption;
	private JMenuItem newOption;
	private JMenuItem saveAsOption;
	private JMenuItem loadOption;
	private JMenuItem infoOption;
	private JPanel colorClickedPanel;
	private JLabel coordsLabel;
	private JPanel coordsPanel;
	private JPanel selectedColorPanel;
	private JPanel colorPanel;
	private JPanel greenPanel;
	private JPanel bluePanel;
	private JPanel blackPanel;
	private JPanel redPanel;
	private JPanel yellowPanel;
	
	
	//Default constructor
	public GUI(Client c) {
		
		//Doing some commands on how the window should look like
		setSize(1000,750);
		setResizable(true);
		setVisible(true);
		setLocation(300,80);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		ImageIcon image = new ImageIcon("C:\\Users\\patur\\Desktop\\Setur\\Java\\Java Code\\Lab6\\Pig.gif");
		setIconImage(image.getImage());

		setTitle();
		createMenuBar();
		createToolbar();
		statusBar();
		createDrawingPanel();
	}

	private void createMenuBar() {
		
		//Making a menu bar
		JMenuBar menubar = new JMenuBar();
		
		//Making a fileMenu
		JMenu fileMenu = new JMenu("File");
        newOption = new JMenuItem("New...");
        saveAsOption = new JMenuItem("Save as...");
        loadOption = new JMenuItem("Load...");
        infoOption = new JMenuItem("Info");
        exitOption = new JMenuItem("Exit");
        exitOption.setToolTipText("Exit application");
        
        //Adding the options into the file menu
        fileMenu.add(newOption);
        fileMenu.add(saveAsOption);
        fileMenu.add(loadOption);
        fileMenu.add(infoOption);
        fileMenu.addSeparator();
        fileMenu.add(exitOption);
        
        //Making a editMenu
        JMenu editMenu = new JMenu("Edit");
        nameOption = new JMenuItem("Name...");
        authorOption = new JMenuItem("Author...");
        
        //Adding the options into editMenu
        editMenu.add(nameOption);
        editMenu.add(authorOption);
        
        //Adding the fileMenu and Edit menu into the menuBar
        menubar.add(fileMenu);
        menubar.add(editMenu);

        //Adding actions listeners on the options
        exitOption.addActionListener(this);
        nameOption.addActionListener(this);
        authorOption.addActionListener(this);
        newOption.addActionListener(this);
        saveAsOption.addActionListener(this);
        loadOption.addActionListener(this);
        infoOption.addActionListener(this);
        
        //Setting the menubar
        setJMenuBar(menubar);

	}
	
	public void setTitle() {
		
		//Setting the title, based on author and name
		if(drawingPanel.getAuthor() == null && drawingPanel.getName() != null) {
			setTitle("JPaint - " + drawingPanel.getName());
        }
		else if(drawingPanel.getAuthor() != null && drawingPanel.getName() == null) {
        	setTitle("JPaint - " + drawingPanel.getAuthor());
        }
		else if(drawingPanel.getAuthor() != null && drawingPanel.getName() != null) {
        	setTitle("JPaint - " + drawingPanel.getName() + " by " + drawingPanel.getAuthor());
        }
        else {
        	setTitle("JPaint - ");
        }
	}
	public void createToolbar() {
		
		
		//Making a few panels, used for the color panels.
		colorPanel = new JPanel(new GridLayout());
		greenPanel = new JPanel();
		bluePanel = new JPanel();
		blackPanel = new JPanel();
		redPanel = new JPanel();
		yellowPanel = new JPanel();
		
		//Giving the panels different colors
		greenPanel.setBackground(Color.green);
		bluePanel.setBackground(Color.blue);
		blackPanel.setBackground(Color.black);
		redPanel.setBackground(Color.red);
		yellowPanel.setBackground(Color.yellow);
		
		//Adding mouse listeners to the panels
		greenPanel.addMouseListener(this);
		bluePanel.addMouseListener(this);
		blackPanel.addMouseListener(this);
		redPanel.addMouseListener(this);
		yellowPanel.addMouseListener(this);
		
		//Adding the colors into the color panels
		colorPanel.add(greenPanel);
		colorPanel.add(bluePanel);
		colorPanel.add(blackPanel);
		colorPanel.add(redPanel);
		colorPanel.add(yellowPanel);
		
		
		//Making a combobox
		String options[] = {"Rectangle","Circle"};
		JComboBox<?> comboBox = new JComboBox<Object>(options);
		colorPanel.add(comboBox);//Adding the combobox into the colorPanel
		add(colorPanel, BorderLayout.PAGE_START);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		//Getting info of what the user choose in the edit- or filemenu
		JMenuItem source = (JMenuItem) e.getSource();
		
		//Doing some actions based on the users action
		if(source == exitOption) {
			System.exit(0);//Quitting the program
		}
		else if(source == nameOption) {
			drawingPanel.setName(JOptionPane.showInputDialog("Enter name of the drawing:")); //Asking the user for the name, using a dialog box
        	setTitle();//Setting the title
		}
		else if(source == authorOption) {
			drawingPanel.setAuthor(JOptionPane.showInputDialog("Enter author of the drawing:"));//Asking the user for the author, using a dialog box
        	setTitle();//Setting the title
		}
		else if(source == newOption) {
			drawingPanel.clear();//Clearing the current drawing panel
			drawingPanel.setName(JOptionPane.showInputDialog("Enter name of the drawing:"));//Asking the user for the name, using a dialog box
        	drawingPanel.setAuthor(JOptionPane.showInputDialog("Enter author of the drawing:"));//Asking the user for the author, using a dialog box
        	setTitle();//Setting the title
        	
		}
		else if(source == saveAsOption) {
			String fileName = JOptionPane.showInputDialog("Save drawing to: ");//Asking the user where to save the file
	        FileHandler.saveToXML(drawingPanel.getDrawing(), fileName);//Calling the saveToXML function
		}
		else if(source == loadOption) {
			 String fileName = JOptionPane.showInputDialog("Load drawing from: ");//Asking the user what file to load
			 Drawing drawing =  FileHandler.loadFromXML(fileName);//Calling the LoadFromXML function
			 if(drawingPanel.isEmpty()) {//Checking if the drawing panel is empty
				 drawingPanel.setDrawing(drawing); //If it is, then set the current drawing
				 setTitle();//Setting the title
			 }
			 else {
				 drawingPanel.addDrawing(drawing); //If the drawing panel isn't empty, then add the current drawing
			 }
		    
		     drawingPanel.repaint(); //repaint the drawing panel
		}
		else if(source == infoOption) {
			try {
				//Showing a message dialog box with information about the drawing
				JOptionPane.showMessageDialog(myFrame, drawingPanel.getName() + " by " + drawingPanel.getAuthor() + "\n"
					+ "Number of shapes: " + drawingPanel.getDrawing().getSize() + "\n" 
					+ "Total area: " + drawingPanel.getDrawing().getTotalArea()+ "\n"
					+ "Total circumference: " + drawingPanel.getDrawing().getTotalCircumference(), "Info", getDefaultCloseOperation());
			} catch (ShapeException e1) {
				// TODO Auto-generated catch block
				e1.getMessage();
			}

		}
	}


	public void statusBar() {
		
		//Making a status bar
		JPanel statusPanel = new JPanel(new GridLayout());
		statusPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));//Giving the status Panel a border
		
		//Making a cordsPanel and cordsLabel
		coordsPanel = new JPanel();
		coordsLabel = new JLabel("", JLabel.LEFT);//Making the label empty and on the left side
		
		
		selectedColorPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));//Making the color panel to be on the right side
		colorClickedPanel = new JPanel();
		JLabel selectedColorLabel = new JLabel("Selected color:",JLabel.RIGHT); //Making a label, with a string and making it to be on the right side
		selectedColorPanel.add(selectedColorLabel);//adding the color label into the color panel
		selectedColorPanel.add(colorClickedPanel);//Adding the color clicked panel into the selected color panel
		
		statusPanel.add(coordsLabel, BorderLayout.LINE_START);//Adding the cords label into the status panel, and putting it on the start of the line
		statusPanel.add(selectedColorPanel, BorderLayout.LINE_END);//Adding the colorpanel into the status panel, and making it be on the end of the line
		
		
		add(statusPanel, BorderLayout.PAGE_END);//Adding into JFrame
	}
	public void createDrawingPanel() {
		//Creating a drawing panel
		drawingPanel = new DrawingPanel();
		drawingPanel.setBackground(Color.white);//Making the background to be white
		drawingPanel.addMouseMotionListener(this);//Adding mouseMotionListener to the drawingPanel
		
		add(drawingPanel, BorderLayout.CENTER);//Adding into JFrame
	}


	@Override
	//Changing the color on the statusbar, based on what the user has clicked on.
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JPanel source = (JPanel) e.getSource();
		
		if(source == greenPanel) {
			colorClickedPanel.setBackground(Color.GREEN);
		}
		else if(source == bluePanel) {
			colorClickedPanel.setBackground(Color.BLUE);
		}
		else if(source == blackPanel) {
			colorClickedPanel.setBackground(Color.BLACK);
		}
		else if(source == redPanel) {
			colorClickedPanel.setBackground(Color.RED);
		}
		else if(source == yellowPanel) {
			colorClickedPanel.setBackground(Color.YELLOW);
		}
	}





	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}





	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
			
	}

	@Override
	//Updating the coordinates based on where the mouse is on the drawing panel
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		coordsLabel.setText("Coordinates: "
				+ 	Integer.toString(e.getX()) +
				","+ Integer.toString(e.getY()));	
	}
}