package dt062g.olpa1600.assignment7;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;



/*
* <h1>Assignment 7</h1>
* This class is a super class for different geometric shapes
*
* @author  P�tur �lavsson Joensen (olpa1600)
* @version 1.0
* @since   24-12-2017
*/
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlSeeAlso({Circle.class, Rectangle.class})
abstract class Shape implements Drawable {

	@XmlElement
	protected String color;
	@XmlElement(name="point")
	protected ArrayList<Point> points;

	public Shape() {
	}
	
	// Constructor
	public Shape(double x, double y, String color) {
		this(new Point(x, y), color);
	}

	// Constructor
	public Shape(Point point, String color) {
		points = new ArrayList<Point>(2);
		points.add(0, point);
		this.color = color;
	}

	public void setColor(String color) {
		this.color = color;
	}; // Set the color

	public String getColor() {
		return color;
	}; // Get the color

	abstract double getCircumference() throws ShapeException; // Get the circumference

	abstract double getArea() throws ShapeException; // Get the area

	public void addPoint(Point point) { // Add a point based on a Point object
		points.add(1, point);
		// points[1] = point;
	}

	public void addPoint(double x, double y) { // Add a point based on two cords
		Point point = new Point(x, y); // Make the point
		points.add(1, point);
		// points[1] = point;
	}
	//Function used to check wether the color formate is corrent
	public Color decodeColor(String colorString) {
		Color c = null;
		try {
			c = Color.decode(colorString);
		}
		catch(Exception e) {
			try {
				c = Color.getColor(colorString);
			}
			catch(Exception d) {
				System.err.println("Wrong color format");
			}
		}
		return c;
	}
	//Function used to set the AntiAliasing
	protected void setAntiAliasing(Graphics g, boolean state) {
		Graphics2D g2d = (Graphics2D) g;
		//Based on the boolean argument set the AntiAliasing
		if(state) {
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		}
		else {
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
		}
	}
}
