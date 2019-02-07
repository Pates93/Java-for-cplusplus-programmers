package dt066g.lesson6.example7;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class Course {
	// Instansvariabler
	@XmlElement(name="coursecode")
	private String courseCode = "";
	
	@XmlElement
	private String name = "";
	@XmlElement
	private double points = 0;
	
	@XmlAttribute(name="code")
	private String applicationCode = "";
	
	@XmlElement
	private String description = "";
	
	@XmlAttribute
	private int start = 0;
	
	@XmlAttribute
	private int end = 0;

	// Konstruktor - gör inget
	public Course() {
	}

	// Set-emtoder
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPoints(double points) {
		this.points = points;
	}

	public void setApplicationCode(String applicationCode) {
		this.applicationCode = applicationCode;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	// Get-metoder
	public String getCourseCode() {
		return courseCode;
	}

	public String getName() {
		return name;
	}

	public double getPoints() {
		return points;
	}

	public String getApplicationCode() {
		return applicationCode;
	}

	public String getDescription() {
		return description;
	}

	public int getStarts() {
		return start;
	}

	public int getEnds() {
		return end;
	}
	
	@Override
	public String toString() {
		String tmp = courseCode + ", " + name + ", " + points + " points\n";
		tmp += "Anmälningskod: " + applicationCode + "  Pågår: " + start
				+ " - " + end;
		tmp += "\nBeskrivning: " + description;

		return tmp;
	}
}