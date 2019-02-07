package dt062g.olpa1600.assignment7;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/*
* <h1>Assignment 7</h1>
* 
* This class is used to handle a collection of shape objects.
* It will be used to draw a diagram consisting of many different figures
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since   24-12-2017
*/
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Drawing implements Drawable {

	@XmlElement
	private String name;
	@XmlElement
	private String author;
	@XmlElement(name="shape")
	private List<Shape> shapes;
	private boolean empty = true;
		
	//Constructor. Creating a new list
	public Drawing() {
		shapes = new ArrayList<Shape>();
	};
	//Constructor. 
	public Drawing(String name, String author) {
		shapes = new ArrayList<Shape>(); //Creating a new list
		this.name = name;
		this.author = author;
		
	}
	//A boolean function used to check if the drawing is empty
	public boolean isEmpty() {
		return empty;
	}
	//Setting the empty boolean
	public void setEmpty(boolean state) {
		empty = state;
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
	//clearing the drawing.
	public void clear() {
		name = "";
		author = "";
		shapes.clear();
		empty = true;
	}
	
	//Add a shape into the list
	public boolean addShape(Shape shape) {
		if (shape == null) { //If the shape is empty, return false
			return false;
		} else {
			shapes.add(shape);//Else add the shape into the list
			empty = false;
			return true;
		}
	}
	//Adding the shapes into the list
	public void addShapes(List<Shape> shape) {
		for(int i = 0; i < shape.size(); i++) {
			addShape(shape.get(i));
		}
	}
	//Get the size of the list
	public int getSize() {
		return shapes.size();
	}
	//Getting the shape list
	public List<Shape> getShapes(){
		return shapes;
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
		Iterator<Shape> it = shapes.iterator(); //Making a iterator
		while (it.hasNext()) { //While there are more shapes in the list
			Shape temp = it.next(); //Get the next shape
			temp.draw(g); //Draw that shape
		}

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
