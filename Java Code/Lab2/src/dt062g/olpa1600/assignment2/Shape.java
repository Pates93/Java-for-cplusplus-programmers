package dt062g.olpa1600.assignment2;

/*
* <h1>Assignment 2</h1>
* This class is a super class for different geometric shapes
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since   11-16-2017
*/
abstract class Shape implements Drawable {

	protected String color;
	protected Point[] points;
	
	//Constructor
	public Shape(double x, double y, String color) {
		points = new Point[2];
		Point point = new Point(x, y);
		points[0] = point;
		this.color = color;
	}
	//Constructor
	public Shape(Point p, String color) {
		points = new Point[2];
		points[0] = p;
		this.color = color;
	}
	
	public void setColor(String color) {this.color = color;}; //Set the color
	public String getColor() {return color;}; //Get the color
	abstract double getCircumference(); //Get the circumference
	abstract double getArea(); //Get the area
	public void addPoint(Point point){ //Add a point based on a Point object
		points[1] = point;
	}
	public void addPoint(double x, double y) { //Add a point based on two cords
		Point point = new Point(x, y); //Make the point
		points[1] = point;
	}
}
