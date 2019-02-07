package dt062g.olpa1600.assignment6;

import java.awt.Graphics;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;


/*
 *<h1>Assignment 6</h1>
 * This class is used to do calculations on a circle 
 * 
 * 
 * @author Pætur Ólavsson Joensen (olpa1600)
 * @version 1.0
 * @since 14-12-2017
*/
@XmlRootElement
class Circle extends Shape {

	@XmlTransient
	final double PI = 3.14;
	
	public Circle() {
		
	}
	
	public Circle(double x, double y, String color) {
		super(x, y, color);

	}

	public Circle(Point point, String color) {
		super(point, color);
	}

	// calculating radius
	public double getRadius() throws ShapeException {

		if (points.size() == 1) {//if there is only one point in the array, then there is no endpoint
			throw new ShapeException("The circle has no end point, its radius cannot be calculated!");
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
			throw new ShapeException("The circle has no end point, its circumference cannot be calculated!");
		} else {
			return (getRadius() * 2) * PI; //Calculate the circumference and return it
		}
	}

	//calculating the area of the circle
	double getArea() throws ShapeException {

		if (points.size() == 1) {//if there is only one point in the array, then there is no endpoint
			throw new ShapeException("The circle has no end point, its area cannot be calculated!");
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
