package dt062g.olpa1600.assignment3;

/*
* <h1>Assignment 3</h1>
* This class is a super class for different geometric shapes
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since   23-11-2017
*/
abstract class Shape implements Drawable {

	protected String color;
	protected Point[] points;
	
	//Constructor
	public Shape(double x, double y, String color){
		this(new Point(x, y), color);
	}
	//Constructor
	public Shape(Point p, String color) {
		this.points = new Point[] {p,null};
		this.color = color;
	}
	
	public void setColor(String color) {this.color = color;}; //Set the color
	public String getColor() {return color;}; //Get the color
	abstract double getCircumference()throws ShapeException; //Get the circumference
	abstract double getArea()throws ShapeException; //Get the area
	public void addPoint(Point point){ //Add a point based on a Point object
		points[1] = point;
	}
	public void addPoint(double x, double y) { //Add a point based on two cords
		Point point = new Point(x, y); //Make the point
		points[1] = point;
	}
}
