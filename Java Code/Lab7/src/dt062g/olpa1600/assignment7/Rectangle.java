package dt062g.olpa1600.assignment7;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.xml.bind.annotation.XmlRootElement;


/*
* <h1>Assignment 7</h1>
* This class represents a rectangle. A rectangle has a starting point and and endpoint
* From these points the rectangle's width, height, circumstance and area can be calculated.
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since   24-12-2017
*/
@XmlRootElement
class Rectangle extends Shape {
	
	public Rectangle() {
		
	}
	
	public Rectangle(double x, double y, String color) {
		super(x, y, color);
	}

	public Rectangle(Point point, String color) {
		super(point, color);
	}

	// Getting the width
	public double getWidth() throws ShapeException {

		if (points.size() == 1) {//if there is only one point in the array, then there is no endpoint
			throw new ShapeException("The rectangle has no end point, its width cannot be calculated!");
		} else
			return points.get(1).getxCord() - points.get(0).getxCord(); //Calculating the width and return it
	}

	// Getting the height
	public double getHeight() throws ShapeException {

		if (points.size() == 1) {//if there is only one point in the array, then there is no endpoint
			throw new ShapeException("The rectangle has no end point, its height cannot be calculated!");
		} else
			return points.get(1).getyCord() - points.get(0).getyCord();// Returning the height
	}

	public void draw() {
		System.out.println(toString());
	}

	public void draw(Graphics g) {
		
		g.setColor(decodeColor(getColor()));//Setting the color of the rectangle
		try {
			g.fillRect((int)points.get(0).getxCord(), (int)points.get(0).getyCord(),
					(int)getWidth(), (int)getHeight());//Filling and drawing the rectangle
		} catch (ShapeException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}
	// Calculating the circumference
	double getCircumference() throws ShapeException {

		if (points.size() == 1) {//if there is only one point in the array, then there is no endpoint
			throw new ShapeException("The rectangle has no end point, its circumference cannot be calculated!");
		} else
			return 2 * (getHeight() + getWidth());// Calculate the circumference and return the result
	}

	// Calculating the area
	double getArea() throws ShapeException {

		if (points.size() == 1) {//if there is only one point in the array, then there is no endpoint
			throw new ShapeException("The rectangle has no end point, its area cannot be calculated!");
		} else
			return getWidth() * getHeight();// Calculate the area and return the result
	}

	// Overriding the toString method, and returning with data about the rectangle
	public String toString() {

		try {
			return ("Drawing a Rectangle[start = " + points.get(0).getxCord() + ", " + points.get(0).getyCord()
					+ "; end=" + points.get(1).getxCord() + ", " + points.get(1).getyCord() + "; width=" + getWidth()
					+ "; height=" + getHeight() + "; color=" + getColor() + "]");
		} catch (Exception e) {

			return ("Drawing a Rectangle[start = " + points.get(0).getxCord() + ", " + points.get(0).getyCord()
					+ "; end= N/A; width=N/A; height=N/A; color=" + getColor() + "]");
		}
	}

}
