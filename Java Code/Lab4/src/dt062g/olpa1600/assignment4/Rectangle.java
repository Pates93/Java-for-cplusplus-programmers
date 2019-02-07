package dt062g.olpa1600.assignment4;

import java.awt.Graphics;

/*
* <h1>Assignment 4</h1>
* This class represents a rectangle. A rectangle has a starting point and and endpoint
* From these points the rectangle's width, height, circumstance and area can be calculated.
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since   23-11-2017
*/

class Rectangle extends Shape {

	public Rectangle(double x, double y, String color) {
		super(x, y, color);
	}

	public Rectangle(Point point, String color) {
		super(point, color);
	}

	// Getting the width
	public double getWidth() throws ShapeException {

		if (points.size() == 1) {//if there is only one point in the array, then there is no endpoint
			throw new ShapeException();//Throw an exception
		} else
			return points.get(1).getxCord() - points.get(0).getxCord(); //Calculating the width and return it
	}

	// Getting the height
	public double getHeight() throws ShapeException {

		if (points.size() == 1) {//if there is only one point in the array, then there is no endpoint
			throw new ShapeException();//Throw an exception
		} else
			return points.get(1).getyCord() - points.get(0).getyCord();// Returning the height
	}

	public void draw() {
		System.out.println(toString());
	}

	public void draw(Graphics g) {
	}

	// Calculating the circumference
	double getCircumference() throws ShapeException {

		if (points.size() == 1) {//if there is only one point in the array, then there is no endpoint
			throw new ShapeException();//Throw an exception
		} else
			return 2 * (getHeight() + getWidth());// Calculate the circumference and return the result
	}

	// Calculating the area
	double getArea() throws ShapeException {

		if (points.size() == 1) {//if there is only one point in the array, then there is no endpoint
			throw new ShapeException();//Throw an exception
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
