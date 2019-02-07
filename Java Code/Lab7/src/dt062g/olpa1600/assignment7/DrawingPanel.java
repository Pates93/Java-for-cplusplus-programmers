package dt062g.olpa1600.assignment7;

import java.awt.Graphics;

import javax.swing.JPanel;

/*
* <h1>Assignment 7</h1>
* 
* This class is used as the drawingpanel. Is is where the rectangles and circles are drawn on
* 
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since  24-12-2017
*/

public class DrawingPanel extends JPanel{

	public Drawing drawing;
	
	//Constructor
	public DrawingPanel() {
		drawing = new Drawing();
	}
	public DrawingPanel(Drawing drawing) {
		this.drawing = drawing;
	}
	//Checking if the drawing is empty
	public boolean isEmpty() {
		return this.drawing.isEmpty();
	}
	//Set the drawing
	public void setDrawing(Drawing drawing) {
		this.drawing = drawing;
	}
	//Get the drawing
	public Drawing getDrawing() {
		return drawing;
	}
	//Add all the shapes in the drawing to the drawing panel
	public void addDrawing(Drawing drawing) {
		for(Shape e: drawing.getShapes()) {
			addShape(e);
		}
		
	}
	//set name
	public void setName(String name) {
		drawing.setName(name);
	}
	//get name
	public String getName() {
		return drawing.getName();
	}
	//Set author
	public void setAuthor(String author) {
		drawing.setAuthor(author);
	}
	//Get author
	public String getAuthor() {
		return drawing.getAuthor();
	}
	//clear the drawingpanel and repaint 
	public void clear() {
		drawing.clear();
		repaint();
	}
	//Add a shape to the drawing panel
	public void addShape(Shape shape) {
		drawing.addShape(shape);
	}
	//Paint the drawing
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(drawing != null) {
			drawing.draw(g);
		}
	}
}
