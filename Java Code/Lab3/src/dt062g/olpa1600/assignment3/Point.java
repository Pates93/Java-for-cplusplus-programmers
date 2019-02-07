/**
 * 
 */
package dt062g.olpa1600.assignment3;

/*
* <h1>Assignment 3</h1>
*This class is used to represent a point in a coordinate system.
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since   23-11-2017
*/
public class Point {

	private double xcord;
	private double ycord;
	
	//default constructor
	public Point()
	{
		ycord = 0.0;
		xcord = 0.0;
	}
	//Constructor
	public Point(double xcord, double ycord) {
		this.xcord = xcord;
		this.ycord = ycord;
		
	}
	//Set x cord
	public void setxCord(double xcord){
		this.xcord = xcord;
	}
	//Set y cord
	public void setyCord(double ycord) {
		this.ycord = ycord;
	}
	//Get y cord
	public double getyCord(){
		return ycord;
	}
	//Get x cord
	public double getxCord() {
		return xcord;
	}
	
	//Overriding the toString method and return data about the point
	public String toString()
	{
		return ("(" + xcord + ", " + ycord + ")");
	}
}
