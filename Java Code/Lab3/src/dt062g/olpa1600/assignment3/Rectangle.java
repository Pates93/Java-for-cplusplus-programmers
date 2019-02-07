package dt062g.olpa1600.assignment3;


import java.awt.Graphics;

/*
* <h1>Assignment 3</h1>
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
	//Getting the width
	public double getWidth() throws ShapeException {
		
		if(points[1] == null) {//If there is no endpoint
			throw new ShapeException("The rectangle has no end point, its width cannot be calculated!");
		}
		else return points[1].getxCord() - points[0].getxCord();//Returning the width
		
	}
	//Getting the height
	public double getHeight() throws ShapeException {
		
		if(points[1] == null) {//If there is no endpoint
			throw new ShapeException("The rectangle has no end point, its height cannot be calculated!");
		}
		else
			return points[1].getyCord() - points[0].getyCord();//Returning the height
	}
	public void draw() {
		System.out.println(toString());	
	}

	public void draw(Graphics g) {
	}

	//Calculating the circumference
	double getCircumference() throws ShapeException{
		
		if(points[1] == null) { //If there is no endpoint
			throw new ShapeException("The rectangle has no end point, its circumference cannot be calculated!");
		}
		else
			return 2 * (getHeight() + getWidth());//Calculate the circumference and return the result
	}
	//Calculating the area
	double getArea() throws ShapeException{
		
		if(points[1] == null) {//If there is no endpoint
			throw new ShapeException("The rectangle has no end point, its area cannot be calculated!");
		}
		else
			return getWidth() * getHeight();//Calculate the area and return the result
	}
	//Overriding the toString method, and returning with data about the rectangle
	public String toString() {
		
		try {
			return ("Drawing a Rectangle[start = "+points[0].getxCord()+", "+points[0].getyCord()+"; end="+points[1].getxCord()+", "+points[1].getyCord()+ "; width="+getWidth()+
					"; height="+getHeight()+"; color="+ getColor()+"]");
		}
		catch(Exception e) {
			
			return ("Drawing a Rectangle[start = "+points[0].getxCord()+", "+points[0].getyCord()+"; end= N/A; width=N/A; height=N/A; color="+ getColor()+"]");
		}
	}
}
