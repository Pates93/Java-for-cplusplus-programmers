package dt062g.olpa1600.assignment2;


import java.awt.Graphics;

/*
* <h1>Assignment 2</h1>
* This class represents a rectangle. A rectangle has a starting point and and endpoint
* From these points the rectangle's width, height, circumstance and area can be calculated.
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since   11-16-2017
*/

class Rectangle extends Shape implements Drawable{

	
	public Rectangle(double x, double y, String color) {
		super(x, y, color);
	}
	public Rectangle(Point point, String color) {
		super(point, color);
	}
	//Getting the width
	public double getWidth() {
		
		if(points[1] != null) {//Making sure there is a endpoint
		return points[1].getxCord() - points[0].getxCord();//Returning the width
		}
		else
			return -1;
	}
	//Getting the height
	public double getHeight() {
		
		if(points[1] != null) {//Making sure there is a endpoint
			return points[1].getyCord() - points[0].getyCord();//Returning the height
		}
		else
			return -1;
	}
	public void draw() {
		System.out.println(toString());	
	}

	public void draw(Graphics g) {
	}

	//Calculating the circumference
	double getCircumference() {
		
		if(points[1] != null) {//Making sure there is a endpoint
			return 2 * (getHeight() + getWidth());//Calculate the circumference and return the result
		}
		else 
			return -1;
	}
	//Calculating the area
	double getArea() {
		if(points[1] != null) {//Making sure there is a endpoint
			return getWidth() * getHeight();//Calculate the area and return the result
		}
		else
			return -1;
	}
	//Overriding the toString method, and returning with data about the rectangle
	public String toString() {
		
		if(points[1] != null) {//Making sure there is a endpoint
			
			return ("Rectangle[start = "+points[0].getxCord()+", "+points[0].getyCord()+"; end="+points[1].getxCord()+", "+points[1].getyCord()+ "; width="+getWidth()+
					"; height="+getHeight()+"; color="+ getColor()+"]");
		}
		else {
			
			return ("Rectangle[start = "+points[0].getxCord()+", "+points[0].getyCord()+"; end= N/A; width=N/A; height=N/A; color="+ getColor()+"]");
		}
	}
}
