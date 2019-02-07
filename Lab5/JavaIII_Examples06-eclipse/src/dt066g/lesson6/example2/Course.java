package dt066g.lesson6.example2;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV �stersund
 * @version 1.0
 */

public class Course {
	// Instansvariabler
	private String courseCode = "";
	private String name = "";
	private double points = 0;
	private String applicationCode = "";
	private String description = "";
	private int start = 0;
	private int end = 0;

	// Konstruktor - g�r inget
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

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}
	
	@Override
	public String toString() {
		String tmp = courseCode + ", " + name + ", " + points + " points\n";
		tmp += "Anm�lningskod: " + applicationCode + "  P�g�r vecka: " + start
				+ " - " + end;
		tmp += "\nBeskrivning: " + description;

		return tmp;
	}
}