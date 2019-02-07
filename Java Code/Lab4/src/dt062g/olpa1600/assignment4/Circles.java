package dt062g.olpa1600.assignment4;

import java.awt.Graphics;

/*
 *<h1>Assignment 4</h1>
 * This class is used to do calculations on a circle 
 * 
 * 
 * @author Pætur Ólavsson Joensen (olpa1600)
 * @version 1.0
 * @since 23-11-2017
*/
class Circle extends Shape {

	final double PI = 3.14;

	public Circle(double x, double y, String color) {
		super(x, y, color);

	}

	public Circle(Point point, String color) {
		super(point, color);
	}

	// calculating radius
	public double getRadius() throws ShapeException {

		if (points.size() == 1) {//if there is only one point in the array, then there is no endpoint
			throw new ShapeException();//Throw an exception
		} else {
			double cx = points.get(0).getxCord();
			double cy = points.get(0).getyCord();
			double px = points.get(1).getxCord();
			double py = points.get(1).getyCord();
			double dx = px - cx;
			double dy = py - cy;
			double radius = Math.sqrt(dx * dx + dy * dy); //Calculate the radius
			return radius; //Return the result
			
		}

	}

	public void draw() {
		System.out.println(toString());

	}

	public void draw(Graphics g) {

	}

	// Calculating circumference.
	double getCircumference() throws ShapeException {

		if (points.size() == 1) {//if there is only one point in the array, then there is no endpoint
			throw new ShapeException();//Throw an exception
		} else {
			return (getRadius() * 2) * PI; //Calculate the circumference and return it
		}
	}

	double getArea() throws ShapeException {

		if (points.size() == 1) {//if there is only one point in the array, then there is no endpoint
			throw new ShapeException();//Throw an exception
		} else {
			return PI * getRadius() * getRadius(); //Calculate the area and return it
		}
	}

	// Overriding the method toString and returning data about the circle
	public String toString() {

		try {
			return ("Drawing a Circle[start = " + points.get(0).getxCord() + ", " + points.get(0).getyCord() + "; end="
					+ points.get(1).getxCord() + ", " + points.get(1).getyCord() + "; radius=" + getRadius()
					+ "; color=" + getColor() + "]");
		} catch (Exception e) {
			return ("Drawing a Circle[start = " + points.get(0).getxCord() + ", " + points.get(0).getyCord()
					+ "; end= N/A; radius=N/A; color=" + getColor() + "]");
		}

	}

}
