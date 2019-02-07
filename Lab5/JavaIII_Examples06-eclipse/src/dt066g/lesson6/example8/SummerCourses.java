package dt066g.lesson6.example8;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import dt066g.lesson6.example7.Course;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="summercourse")
public class SummerCourses {
	@XmlAttribute
	private int year;
	
	@XmlElement(name="course")
	private ArrayList<Course> courses = new ArrayList<Course>();
	
	public SummerCourses(int year, ArrayList<Course> courses) {
		this.year = year;
		this.courses = courses;
	}

	public SummerCourses(int year) {
		this.year = year;
	}

	public SummerCourses() {
	}
	
	public void add(Course c) {
		courses.add(c);
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ArrayList<Course> getCourses() {
		return courses;
	}

	public void setCourses(ArrayList<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Sommarkurser år ");
		sb.append(year);
		
		for(Course c : courses) {
			sb.append("\n");
			sb.append(c.getName());
		}
		
		return sb.toString();
	}
}
