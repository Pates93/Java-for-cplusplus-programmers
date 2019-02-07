package dt066g.lesson6.example4;
/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV �stersund
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

	// Lagrar vilket year kurserna g�ller
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

		// Anropar metod f�r att lista alla kurser
		listCourses();
	}

	private void listCourses() {
		// Skriv ut hur m�nga kurser som l�stes in
		System.out.println("Antal kurser sommaren " + year +  ": " + courses.size());

		// Loopa igenom alla courses med en Iterator
		Iterator it = courses.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next().toString());
			System.out.println();
		}
	}

	// Metod som utifr�n en nod inneh�llandes kursdata skapar ett kursobjekt och returnerar detta
	private Course createCourse(Node courseNode) {
		// Skapa nytt tomt Course-objekt
		Course course = new Course();

		// B�rja med att h�mta attributen anmalningskod, start och slut
		// Typomvandlar Node-objektet courseNode till ett Element-objekt
		// s� att vi enkelt och smidigt kan anv�nda getAttribute(namn p� attribut)
		Element e = (Element)courseNode;
		course.setApplicationCode(e.getAttribute("code"));
		course.setStart(Integer.parseInt(e.getAttribute("start")));
		course.setEnd(Integer.parseInt(e.getAttribute("end")));

		// Dags att h�mta kurskod, kursnamn, poang och beskrivning
		// Eftersom ordningen av dessa element �r best�md i DTDn h�mtar vi
		// dessa i tur och ordning. Kom ih�g att elementens inneh�ll (text)
		// �r egna noder (barn-noder) i tr�dstrukturen s� d�rf�r anv�nder vi getFirstChild
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

		// Anger att fabriken ska ignorera element som endast inneh�ller white spaces
		dbf.setIgnoringElementContentWhitespace(true);

		try {
			// Skapar en DocumentBuilder genom att anropa newDocumentBuilder p� "fabriken"
			DocumentBuilder db = dbf.newDocumentBuilder();

			// Skapar ett Document-objekt av sommarkurser.xml
			dom = db.parse("summercourses.xml");

		}
		catch(SAXException se) {
			// Om ett fel eller varning ges n�r XML-dokumentet tolkas
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
		// H�mta root elementet
		Element root = dom.getDocumentElement();

		// B�rjar med att ta reda p� vilket �r sommarkurserna g�ller
		year = root.getAttribute("year");

		// H�mta alla kurs-element
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