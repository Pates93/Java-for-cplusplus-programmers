package dt062g.olpa1600.assignment3;

import java.awt.Graphics;


/*
 *<h1>Assignment 3</h1>
 * This class is used to do calculations on a circle 
 * 
 * 
 * @author Pætur Ólavsson Joensen (olpa1600)
 * @version 1.0
 * @since 23-11-2017
*/
class Circle extends Shape  {
	
	final double PI = 3.14;

	public Circle(double x, double y, String color) {
		super(x,y,color);
	}
	public Circle(Point point, String color) {
		super(point, color);
	}
	
	//calculating radius
	public double getRadius() throws ShapeException{
		
		if(points[1] == null) {
			throw new ShapeException("The circle has no end point, its radius cannot be calculated!");
		}
		else{
			double cx = points[0].getxCord();
			double cy = points[0].getyCord();
			double px = points[1].getxCord();
			double py = points[1].getyCord();
			double dx = px - cx;
			double dy = py - cy;
			double radius = Math.sqrt(dx*dx + dy*dy);
			return radius;
			//if points[1] == null throw exception else do calculations
		}
		
	}
	
	public void draw() {
		System.out.println(toString());
		
	}

	public void draw(Graphics g) {
		
	}

	//Calculating circumference.
	double getCircumference() throws ShapeException{
		
		if(points[1] == null) {//if there is no end point
			throw new ShapeException("The circle has no end point, its circumference cannot be calculated!");
		}
		else {
		return (getRadius()*2) * PI; //Else calculate the radius and return it
		}
	}

	double getArea() throws ShapeException{
		
		if(points[1] == null) { //If there is no end point
			throw new ShapeException("The circle has no end point, its area cannot be calculated!");
		}
		else {
		return PI * getRadius() * getRadius(); //Else calculate the area and return it
	}
	}
	
	//Overriding the method toString and returning data about the circle
	public String toString() {		

			try {
			return ("Drawing a Circle[start = "+points[0].getxCord()+", "+points[0].getyCord()+"; end="+points[1].getxCord()+
					", "+points[1].getyCord()+ "; radius="+getRadius()+ "; color="+ getColor()+"]");
			}
			catch(Exception e)
			{			
			return ("Drawing a Circle[start = "+points[0].getxCord()+", "+points[0].getyCord()+"; end= N/A; radius=N/A; color="
			+ getColor()+"]");
		}
	
	}
}

