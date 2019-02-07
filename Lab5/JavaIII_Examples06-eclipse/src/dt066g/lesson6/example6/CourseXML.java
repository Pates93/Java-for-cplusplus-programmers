package dt066g.lesson6.example6;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */

import java.io.*;

import javax.xml.parsers.*;

import org.xml.sax.*;
import org.w3c.dom.*;

import dt066g.lesson6.example2.Course;
import dt066g.lesson6.example5.DOMWriter;

import java.util.*;

public class CourseXML {
	private Document document;

	public CourseXML() {
		createDocument();
	}

	private void createDocument() {
		// Skapa en ny DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Anger att den ska validera koden mot en DTD
		factory.setValidating(true);

		try {
			// Skapar en DocumentBuilder genom att anropa newDocumentBuilder på "fabriken"
			DocumentBuilder parser = factory.newDocumentBuilder();

			// Skapar ett nytt tomt Document-objekt
			// För att sätta DOCTYPE kan vi inte använda 'document =
			// db.newDocument()'
			// Vi måste använda en DOMImplementation
			DOMImplementation impl = parser.getDOMImplementation();

			// Genom att anropa createDocumentType kan vi skapa en ny DocumentType (DOCTYPE)
			// där vi anger för vilket root-element den gäller och vilken dtd som ska användas
			DocumentType doctype = impl.createDocumentType("summercourses",
					null, "summercourses.dtd");

			// Vi kan nu skapa ett nytt dokument genom att anropa createDocument
			// null innebär att vi inte använder namespace
			// summercourses är namnet på root-elementet
			// doctype är DocumentType-objektet vi skapade
			document = impl.createDocument(null, "summercourses", doctype);

			// Hämta root-elementet för att sätta attributet ar
			Element root = document.getDocumentElement();
			root.setAttribute("year", "2015");
		} catch (ParserConfigurationException pce) {
			// Om DOM-tolken inte kan skapas med newDocumentBuilder
			pce.printStackTrace();
		}
	}

	// Lägg till en ny kurs i trädstrukturen
	public void addCourse(Course c) {
		// Skapa elementet course och lägg till attribut
		Element course = document.createElement("course");
		course.setAttribute("code", c.getApplicationCode());
		course.setAttribute("start", Integer.toString(c.getStart()));
		course.setAttribute("end", Integer.toString(c.getEnd()));

		// Skapa elementet coursecode och lägg till i course
		Element courseCode = document.createElement("coursecode");
		courseCode.setTextContent(c.getCourseCode());
		course.appendChild(courseCode);

		// Skapa elementet name och lägg till i course
		Element name = document.createElement("name");
		name.setTextContent(c.getName());
		course.appendChild(name);

		// Skapa elementet points och lägg till i course
		Element points = document.createElement("point");
		points.setTextContent(Double.toString(c.getPoints()));
		course.appendChild(points);

		// Skapa elementet description och lägg till i course
		Element description = document.createElement("description");
		description.setTextContent(c.getDescription());
		course.appendChild(description);

		Element root = document.getDocumentElement();
		root.appendChild(course);
	}

	public void saveToFile(String fileName) {
		try {
			FileOutputStream out = new FileOutputStream(fileName);
			DOMWriter.writeDocument(document, out);
		} catch (FileNotFoundException e) {
			System.out.println("Hittar inte filen " + fileName);
			System.out.println(e.getMessage());
		}
	}
}