package dt062g.olpa1600.assignment2;

import java.awt.Graphics;


/*
 *<h1>Assignment 2</h1>
 * This class is used to do calculations on a circle 
 * 
 * 
 * @author Pætur Ólavsson Joensen (olpa1600)
 * @version 1.0
 * @since 11-16-2017
*/
class Circle extends Shape implements Drawable {
	
	final double PI = 3.14;

	public Circle(double x, double y, String color) {
		super(x,y,color);
	}
	public Circle(Point point, String color) {
		super(point, color);
	}
	
	//calculating radius
	public double getRadius() {
		double cx = points[0].getxCord();
		double cy = points[0].getyCord();
		double px = points[1].getxCord();
		double py = points[1].getyCord();
		double dx = px - cx;
		double dy = py - cy;
		double radius = Math.sqrt(dx*dx + dy*dy);
		
		if(points[1] != null) { //If there is a endpoint, return radius
			return radius;
		}
		else
			return -1;
	}
	
	public void draw() {
		System.out.println(toString());
		
	}

	public void draw(Graphics g) {
		
	}

	//Calculating circumference.
	double getCircumference() {
		if(getRadius() == -1) {//If radius is -1, then there is no endpoint.
			return -1;
		}
		else {
		return (getRadius()*2) * PI;
		}
	}

	double getArea() {
		if(getRadius() == -1) {//If radius is -1, then there is no endpoint.
			return -1;
		}
		else {
		return PI * getRadius() * getRadius();
	}
	}
	//Overriding the method toString and returning data about the circle
	public String toString() {		
		if(points[1] != null) {
			
			return ("Circle[start = "+points[0].getxCord()+", "+points[0].getyCord()+"; end="+points[1].getxCord()+", "+points[1].getyCord()+ "; radius="+getRadius()+
					"; color="+ getColor()+"]");
		}
		else {
			
			return ("Circle[start = "+points[0].getxCord()+", "+points[0].getyCord()+"; end= N/A; width=N/A; color="+ getColor()+"]");
		}
	
	}
}

