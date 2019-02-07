package dt062g.olpa1600.assignment4;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* <h1>Assignment 4</h1>
* 
* This class is used to handle a collection of shape objects.
* It will be used to draw a diagram consisting of many different figures
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since   23-11-2017
*/

public class Drawing implements Drawable {

	private String name;
	private String author;
	private List<Shape> shapes;
	
	//Constructor. Creating a new list
	public Drawing() {
		shapes = new ArrayList<Shape>();
	};
	//Constructor. 
	public Drawing(String name, String author) {
		this.name = name;
		this.author = author;
		shapes = new ArrayList<Shape>(); //Creating a new list
	}
	//Set the name
	public void setName(String name) {
		this.name = name;
	}
	//Set the author
	public void setAuthor(String author) {
		this.author = author;
	}
	//Get the name
	public String getName() {
		return this.name;
	}
	//Get the author
	public String getAuthor() {
		return this.author;
	}
	
	//Add a shape into the list
	public boolean addShape(Shape shape) {
		if (shape == null) { //If the shape is empty, return false
			return false;
		} else {
			shapes.add(shape);//Else add the shape into the list
			return true;
		}
	}
	//Get the size of the list
	public int getSize() {
		return shapes.size();
	}
	
	//Calculate the total circumference
	public double getTotalCircumference() throws ShapeException {

		Iterator<Shape> it = shapes.iterator(); //Making an iterator
		double sum = 0; 
		//Where there are more shapes in the list
		while (it.hasNext()) {
			try {
				sum += it.next().getCircumference(); //Get circumference of all shapes
			} catch (ShapeException e) {
				continue;// If the getCircumference function returns a exception, catch it and skip that
							// shape.
			}
		}
		return sum; 
	}
	//Calculate the total area
	public double getTotalArea() throws ShapeException {

		double sum = 0;
		Iterator<Shape> it = shapes.iterator(); //Making an iterator
		while (it.hasNext()) { //While there are more shapes in the list
			try {
				sum += it.next().getArea(); //Get the area of all the shapes
			} catch (ShapeException e) {
				continue;// If the getArea function returns a exception, catch it and skip that shape.
			}
		}
		return sum;
	}

	@Override
	public void draw() {

		//Printing out information about the drawing
		System.out.println("A drawing by " + getAuthor() + " called " + getName());
		Iterator<Shape> it = shapes.iterator(); //Making a iterator
		while (it.hasNext()) { //While there are more shapes in the list
			Shape temp = it.next(); //Get the next shape
			temp.draw(); //Draw that shape
		}

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub

	}

	// Overriding the toString method and return data about the drawing
	public String toString() {
		if (getName() == null | getAuthor() == null) { //If there is no name or author print this line
			return ("Drawing[name=; author=; size=" + getSize() + "; circumference=0.0; area=0.0 ]");
		}
		try {
			return ("Drawing[name=" + getName() + "; author=" + getAuthor() + "; size=" + getSize() + "; circumference="
					+ getTotalCircumference() + "; area=" + getTotalArea() + "]");
		} catch (ShapeException e) {
			return ("Drawing[name=" + getName() + "; author=" + getAuthor() + "; size=" + getSize()
					+ "; circumference=0 " + "; area=0" + "]");
		}

	}
}
