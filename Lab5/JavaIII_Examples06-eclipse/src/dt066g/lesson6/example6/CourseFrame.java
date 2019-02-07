package dt066g.lesson6.example6;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

import dt066g.lesson6.example2.Course;

import java.util.*;

public class CourseFrame extends JFrame implements ActionListener {
	// Deklarerar de komponenter som används
	private JButton addButton;
	private JButton saveButton;
	private JButton clearButton;
	private JLabel nameLabel;
	private JLabel applicationCodeLabel;
	private JLabel courseCodeLabel;
	private JLabel pointsLabel;
	private JLabel startsLabel;
	private JLabel endsLabel;
	private JPanel descriptionPanel;
	private JPanel buttonsPanel;
	private JPanel CourseDataPanel;
	private JScrollPane scrollPane;
	private JTextField applicationCodeText;
	private JTextArea descriptionText;
	private JTextField courseCodeText;
	private JTextField nameText;
	private JTextField pointsText;
	private JTextField startsText;
	private JTextField endsText;

	// För att skapa XML-dokument med kurser
	private CourseXML xml = new CourseXML();

	// Konstruktor
	public CourseFrame() {
		setTitle("CourseFrame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Skapar och lägger till komponenter
		CourseDataPanel = new JPanel(new GridLayout(2, 6, 5, 5));
		CourseDataPanel.setBorder(new TitledBorder("Kursdata"));
		nameLabel = new JLabel("Kursnamn:");
		CourseDataPanel.add(nameLabel);
		nameText = new JTextField();
		CourseDataPanel.add(nameText);

		courseCodeLabel = new JLabel("Kurskod:");
		courseCodeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		CourseDataPanel.add(courseCodeLabel);
		courseCodeText = new JTextField();
		CourseDataPanel.add(courseCodeText);

		pointsLabel = new JLabel("Poäng:");
		pointsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		CourseDataPanel.add(pointsLabel);
		pointsText = new JTextField();
		CourseDataPanel.add(pointsText);

		applicationCodeLabel = new JLabel("Anmkod:");
		CourseDataPanel.add(applicationCodeLabel);
		applicationCodeText = new JTextField();
		CourseDataPanel.add(applicationCodeText);

		endsLabel = new JLabel("Startar:");
		endsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		CourseDataPanel.add(endsLabel);
		endsText = new JTextField();
		CourseDataPanel.add(endsText);

		startsLabel = new JLabel("Slutar:");
		startsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		CourseDataPanel.add(startsLabel);
		startsText = new JTextField();
		CourseDataPanel.add(startsText);

		descriptionPanel = new JPanel(new BorderLayout());
		descriptionPanel.setBorder(new TitledBorder("Kursbeskrivning"));

		descriptionText = new JTextArea();
		descriptionText.setLineWrap(true);
		descriptionText.setWrapStyleWord(true);
		descriptionText.setPreferredSize(new Dimension(200, 50));
		scrollPane = new JScrollPane(descriptionText);
		descriptionPanel.add(scrollPane, BorderLayout.CENTER);

		buttonsPanel = new JPanel();
		addButton = new JButton("Lägg till kurs");
		addButton.addActionListener(this);
		buttonsPanel.add(addButton);
		clearButton = new JButton("Rensa textfält");
		clearButton.addActionListener(this);
		buttonsPanel.add(clearButton);
		saveButton = new JButton("Spara till XML-fil");
		saveButton.addActionListener(this);
		buttonsPanel.add(saveButton);

		add(CourseDataPanel, BorderLayout.NORTH);
		add(descriptionPanel, BorderLayout.CENTER);
		add(buttonsPanel, java.awt.BorderLayout.SOUTH);

		pack();
		setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// Kontrollerar vilken knapp användaren tryckte på
		if (e.getSource() == addButton) {
			// Skapar ett tomt Course-objekt
			Course c = new Course();
			c.setCourseCode(courseCodeText.getText());
			c.setName(nameText.getText());
			c.setPoints(Double.parseDouble(pointsText.getText()));
			c.setApplicationCode(applicationCodeText.getText());
			c.setStart(Integer.parseInt(endsText.getText()));
			c.setEnd(Integer.parseInt(startsText.getText()));
			c.setDescription(descriptionText.getText());

			xml.addCourse(c);
		} else if (e.getSource() == saveButton) {
			xml.saveToFile("newsummercourses.xml");
		} else {
			// Rensa textfälten
			nameText.setText("");
			applicationCodeText.setText("");
			courseCodeText.setText("");
			pointsText.setText("");
			startsText.setText("");
			endsText.setText("");
			descriptionText.setText("");
		}
	}

	public static void main(String args[]) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new CourseFrame();
			}
		});	
	}
}
