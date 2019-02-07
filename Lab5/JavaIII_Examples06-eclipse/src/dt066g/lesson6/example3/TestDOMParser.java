package dt066g.lesson6.example3;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */

import java.io.IOException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TestDOMParser {
	// Dokumentet
	private Document dom;

	// Konstruktor
	public TestDOMParser() {
		// Anropar egen metod som skapar XML-tolken
		createParser();

		// Anropar egen metod som tolkar dokumentet
		parseDocument();
	}

	private void createParser() {
		// Skapa en ny DocumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		// Anger att den ska validera koden mot en DTD
		factory.setValidating(true);

		// Anger att fabriken ska ignorera element som endast innehåller white spaces
		factory.setIgnoringElementContentWhitespace(true);

		try {
			// Skapar en DocumentBuilder genom att anropa newDocumentBuilder på "fabriken"
			DocumentBuilder parser = factory.newDocumentBuilder();

			// Skapar ett Document-objekt av sommarkurser.xml
			dom = parser.parse("summercourses.xml");

		} catch (SAXException se) {
			// Om ett fel eller varning ges när XML-dokumentet tolkas
			se.printStackTrace();
		} catch (ParserConfigurationException pce) {
			// Om DOM-tolken inte kan skapas med newDocumentBuilder
			pce.printStackTrace();
		} catch (IOException ie) {
			// Om t.ex. xml-filen inte hittas
			ie.printStackTrace();
		}
	}

	private void parseDocument() {
		// Hämta root elementet
		Element root = dom.getDocumentElement();

		// Hämta en lista över alla noder i root
		NodeList nl = root.getChildNodes();

		// Listar elementen i listan
		listNodes(nl);
	}

	private void listNodes(NodeList nl) {
		// Finns det noder i listan?
		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {
				Node currentNode = nl.item(i);

				// Skriv ut nodens namn mellan tecknen < >
				System.out.println("<" + currentNode.getNodeName() + ">");

				if (currentNode.hasChildNodes()) {
					listNodes(currentNode.getChildNodes());
				}

				// Skriv ut nodens namn mellan tecknane </ >
				System.out.println("</" + currentNode.getNodeName() + ">");

				// OBSERVERA att ett elements innehåll (text) hanteras som en
				// egen nod med nodnamnet #text.
			}
		}
	}

	public static void main(String[] args) {
		// Skapa objekt av egna klassen
		TestDOMParser tdp = new TestDOMParser();
	}
}