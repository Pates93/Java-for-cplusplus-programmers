package dt066g.lesson6.example2;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */

import java.io.IOException;
import javax.xml.parsers.*;
import org.xml.sax.Attributes;
import org.xml.sax.*;
import org.xml.sax.helpers.DefaultHandler;
import java.util.*;

public class CourseSAXParser extends DefaultHandler {
	// Objekt som temporärt används när information om en kurs läses in
	private Course tmpCourse;

	// Sträng som temporärt används när data om en kurs läses in
	private String tmpString;

	// Lagrar alla courses
	private List<Course> courses;

	// Lagrar vilket year kurserna gäller
	private String year;

	// Konstruktor
	public CourseSAXParser() {
		// Skapar ArrayList
		courses = new ArrayList<Course>();
		tmpString = "";

		// Anropar egen metod som skapar XML-tolken
		parseDocument();

		// Anropar egen metod för att lista alla courses
		listAllCourses();
	}

	private void parseDocument() {
		// Skapa en ny SAXParserFactory
		SAXParserFactory factory = SAXParserFactory.newInstance();

		// Anger att den ska validera koden mot en DTD
		factory.setValidating(true);

		try {
			// Skapar en SAXParser genom att anropa newSAXParser på "fabriken"
			SAXParser parser = factory.newSAXParser();

			// Tolkar sommarkurser.xml och registrerar oss själva (denna klass)
			// som hanterare av händelser från tolken
			parser.parse("summercourses.xml", this);

		} catch (SAXException se) {
			// Om ett fel eller varning ges när XML-dokumentet tolkas
			se.printStackTrace();
		} catch (ParserConfigurationException pce) {
			// Om SAX-tolken inte kan skapas med newSAXParser
			pce.printStackTrace();
		} catch (IOException ie) {
			// Om t.ex. xml-filen inte hittas
			ie.printStackTrace();
		}
	}

	private void listAllCourses() {
		// Skriv ut hur många kurser som lästes in
		System.out
				.println("Antal kurser sommaren " + year + ": " + courses.size());

		// Loopa igenom alla courses med en Iterator
		Iterator it = courses.iterator();
		while (it.hasNext()) {
			System.out.println(it.next().toString());
			System.out.println();
		}
	}

	// Annropas när början av ett element påträffas (start-tag)
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// Kontrollerar om det är elementet summercourses
		if (qName.equals("summercourses")) {
			year = attributes.getValue("year");
		}
		// Kontrollerar om det är elementet course
		else if (qName.equals("course")) {
			// Skapar ett nytt temporärt Course-objekt
			tmpCourse = new Course();

			// Eftersom vi enligt DTDn vet att elementet kurs har tre attribut
			// som alla är obligatoriska så kan vi direkt använda getValue
			// Skulle det funnits icke obligatoriska attribut vore vi tvugna att
			// loopa igenom alla attribut och kontrollera dess namn
			String code = attributes.getValue("code");
			String start = attributes.getValue("start");
			String end = attributes.getValue("end");

			tmpCourse.setApplicationCode(code);
			tmpCourse.setStart(Integer.parseInt(start));
			tmpCourse.setEnd(Integer.parseInt(end));
		}
	}

	// Annropas när slutet av ett element påträffas (slut-tag)
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// Kontrollerar om det är elementet coursecode
		if (qName.equals("coursecode")) {
			tmpCourse.setCourseCode(tmpString);
		}
		// Kontrollerar om det är elementet name
		else if (qName.equals("name")) {
			tmpCourse.setName(tmpString);
		}
		// Kontrollerar om det är elementet points
		else if (qName.equals("points")) {
			tmpCourse.setPoints(Double.parseDouble(tmpString));
		}
		// Kontrollerar om det är elementet description
		else if (qName.equals("description")) {
			tmpCourse.setDescription(tmpString);
		}
		// Kontrollerar om det är elementet course
		// I så fall finnd det inte mer data om en kurs
		// så vi lägger till den tillfälliga kursen i
		// ArrayList och skapar ett nytt tomt Course-objekt
		else if (qName.equals("course")) {
			courses.add(tmpCourse);
			tmpCourse = new Course();
		}
	}

	// Annropas när innehållet i ett element påträffas
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// Lagrar elementets (vilket det nu kan vara) innehåll i den temporära
		// strängen så att vi kan använda detta i endElement
		tmpString = new String(ch, start, length);
	}

	// Fel vid tolkning
	public void error(SAXParseException se) {
		System.out.println("ERROR: " + se.getMessage());
	}

	// En varning genereras vid tolkning
	public void warning(SAXParseException se) {
		System.out.println("WARNING: " + se.getMessage());
	}

	public static void main(String[] args) {
		// Skapa objekt av egna klassen
		CourseSAXParser parser = new CourseSAXParser();
	}
}