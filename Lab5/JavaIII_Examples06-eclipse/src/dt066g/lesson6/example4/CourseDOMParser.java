package dt066g.lesson6.example4;
/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */

import java.io.*;

import javax.xml.parsers.*;

import org.xml.sax.*;
import org.w3c.dom.*;

import dt066g.lesson6.example2.Course;

import java.util.*;

public class CourseDOMParser {
	// Lagrar alla courses
	private List<Course> courses;

	// Lagrar vilket year kurserna gäller
	private String year;

	// Dokumentet
	private Document dom;

	// Konstruktor
	public CourseDOMParser() {
		// Skapar ArrayList
		courses = new ArrayList<Course>();

		// Anropar metod som skapar XML-tolken
		createParser();

		// Anropar metod som tolkar dokumentet
		parseDocument();

		// Anropar metod för att lista alla kurser
		listCourses();
	}

	private void listCourses() {
		// Skriv ut hur många kurser som lästes in
		System.out.println("Antal kurser sommaren " + year +  ": " + courses.size());

		// Loopa igenom alla courses med en Iterator
		Iterator it = courses.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next().toString());
			System.out.println();
		}
	}

	// Metod som utifrån en nod innehållandes kursdata skapar ett kursobjekt och returnerar detta
	private Course createCourse(Node courseNode) {
		// Skapa nytt tomt Course-objekt
		Course course = new Course();

		// Börja med att hämta attributen anmalningskod, start och slut
		// Typomvandlar Node-objektet courseNode till ett Element-objekt
		// så att vi enkelt och smidigt kan använda getAttribute(namn på attribut)
		Element e = (Element)courseNode;
		course.setApplicationCode(e.getAttribute("code"));
		course.setStart(Integer.parseInt(e.getAttribute("start")));
		course.setEnd(Integer.parseInt(e.getAttribute("end")));

		// Dags att hämta kurskod, kursnamn, poang och beskrivning
		// Eftersom ordningen av dessa element är bestämd i DTDn hämtar vi
		// dessa i tur och ordning. Kom ihåg att elementens innehåll (text)
		// är egna noder (barn-noder) i trädstrukturen så därför använder vi getFirstChild
		NodeList courseData = courseNode.getChildNodes();
		course.setCourseCode(courseData.item(0).getFirstChild().getNodeValue());
		course.setName(courseData.item(1).getFirstChild().getNodeValue());
		course.setPoints(Double.parseDouble(courseData.item(2).getFirstChild().getNodeValue()));
		course.setDescription(courseData.item(3).getFirstChild().getNodeValue());

		return course;
	}

	private void createParser() {
		// Skapa en ny DocumentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		// Anger att den ska validera koden mot en DTD
		dbf.setValidating(true);

		// Anger att fabriken ska ignorera element som endast innehåller white spaces
		dbf.setIgnoringElementContentWhitespace(true);

		try {
			// Skapar en DocumentBuilder genom att anropa newDocumentBuilder på "fabriken"
			DocumentBuilder db = dbf.newDocumentBuilder();

			// Skapar ett Document-objekt av sommarkurser.xml
			dom = db.parse("summercourses.xml");

		}
		catch(SAXException se) {
			// Om ett fel eller varning ges när XML-dokumentet tolkas
			se.printStackTrace();
		}
		catch(ParserConfigurationException pce) {
			// Om DOM-tolken inte kan skapas med newDocumentBuilder
			pce.printStackTrace();
		}
		catch (IOException ie) {
			// Om t.ex. xml-filen inte hittas
			ie.printStackTrace();
		}
	}

	private void parseDocument() {
		// Hämta root elementet
		Element root = dom.getDocumentElement();

		// Börjar med att ta reda på vilket år sommarkurserna gäller
		year = root.getAttribute("year");

		// Hämta alla kurs-element
		NodeList allCourses = root.getElementsByTagName("course");

		// Loopa igenom alla kurs-element
		for (int i = 0; i < allCourses.getLength(); i++) {
			Node courseNode = allCourses.item(i);
			Course c = createCourse(courseNode);
			courses.add(c);
		}
	}

	public static void main(String[] args) {
		// Skapa objekt av egna klassen
		new CourseDOMParser();
	}
}