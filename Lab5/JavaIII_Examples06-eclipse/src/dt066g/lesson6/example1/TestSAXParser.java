package dt066g.lesson6.example1;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV �stersund
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
			// Skapar en SAXParser genom att anropa newSAXParser p� "fabriken"
			SAXParser parser = factory.newSAXParser();

			// Tolkar sommarkurser.xml och registrerar oss sj�lva (denna klass)
			// som hanterare av h�ndelser fr�n tolken
			parser.parse("summercourses.xml", this);

		} catch (SAXException se) {
			// Om ett fel eller varning ges n�r XML-dokumentet tolkas
			se.printStackTrace();
		} catch (ParserConfigurationException pce) {
			// Om SAX-tolken inte kan skapas med newSAXParser
			pce.printStackTrace();
		} catch (IOException ie) {
			// Om t.ex. xml-filen inte hittas
			ie.printStackTrace();
		}
	}

	// Annropas n�r b�rjan av XML-dokumentet p�tr�ffas
	public void startDocument() throws SAXException {
		System.out.println("XML-dokument start");
	}

	// Annropas n�r slutet av XML-dokumentet p�tr�ffas
	public void endDocument() throws SAXException {
		System.out.println("XML-dokument slut");
	}

	// Annropas n�r b�rjan av ett element p�tr�ffas (start-tag)
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

	// Annropas n�r slutet av ett element p�tr�ffas (slut-tag)
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("</" + qName + ">");
	}

	// Annropas n�r inneh�llet i ett element p�tr�ffas
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