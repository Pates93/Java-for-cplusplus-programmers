package dt066g.lesson6.example1;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class TestSAXParser extends DefaultHandler {
	// Konstruktor
	public TestSAXParser() {
		// Anropar egen metod som skapar XML-tolken
		parseDocument();
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

	// Annropas när början av XML-dokumentet påträffas
	public void startDocument() throws SAXException {
		System.out.println("XML-dokument start");
	}

	// Annropas när slutet av XML-dokumentet påträffas
	public void endDocument() throws SAXException {
		System.out.println("XML-dokument slut");
	}

	// Annropas när början av ett element påträffas (start-tag)
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.print("<" + qName);

		// Hantera eventuella attribut
		for (int i = 0; i < attributes.getLength(); i++) {
			System.out.print(" " + attributes.getQName(i) + "=\""
					+ attributes.getValue(i) + "\"");
		}

		System.out.println(">");

	}

	// Annropas när slutet av ett element påträffas (slut-tag)
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("</" + qName + ">");
	}

	// Annropas när innehållet i ett element påträffas
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println(new String(ch, start, length));
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
		TestSAXParser spe = new TestSAXParser();
	}
}