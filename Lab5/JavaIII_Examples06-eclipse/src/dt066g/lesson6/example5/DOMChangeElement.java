package dt066g.lesson6.example5;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), ITM Östersund
 * @version 1.0
 */

import java.io.IOException;
import javax.xml.parsers.*;
import org.xml.sax.SAXException;
import org.w3c.dom.*;

public class DOMChangeElement {
	// Dokumentet
	private Document dom;

	// Konstruktor
	public DOMChangeElement() {
		// Anropar metod som skapar XML-tolken
		createParser();

		// Anropar metod som tolkar dokumentet
		parseDocument();

		// Anropar metod som skriver dokumentet till en OutputStream
		DOMWriter.writeDocument(dom, System.out);
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

			// Skapar ett Document-objekt av summercourses.xml
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

		// Hämta en lista över alla element i root med namnet kursnamn
		NodeList allNames = root.getElementsByTagName("name");

		// Finns det några noder i listan
		if (allNames != null && allNames.getLength() > 0) {
			Node java1 = null;

			// Loopa igenom alla kursnamn (noder) och leta efter Java I
			for (int i = 0; i < allNames.getLength(); i++) {
				Node currentName = allNames.item(i);

				// Hämta Text (innehåll) för elementet
				// Ett elements innehåll representeras i trädet av en egen nod
				// av typen text
				// Därför hämtar vi första barn-noden till aktuell nod (kursnamnet)
				// Första barn-noden är text-noden och således namnet på kursen
				Text text = (Text) currentName.getFirstChild();

				// Kontrollerar om texten är Java I genom att anropa getNodeValue
				if (text.getNodeValue().equalsIgnoreCase("Java I")) {
					// Detta är kursen Java I så vi hämtar föräldrarnoden till aktuellt Kursnamn
					// Föräldrarnoden är med andra ord hela kurs-elementet (noden) för Java I
					java1 = currentName.getParentNode();
					break;
				}
			}

			// Har vi hittat kursen Java I?
			if (java1 != null) {
				// Hämta beskrivningen (eftersom vi med DTDn bestämt ordningen kan vi göra så här)
				Node description = java1.getChildNodes().item(3);
				Text oldDescription = (Text) description.getFirstChild();

				// Skapar den nya beskrivningen
				Text newDescription = dom
						.createTextNode("Ny beskrivning för Java I");

				// Byter ut den gamla beskrivningen mot den nya
				description.replaceChild(newDescription, oldDescription);
			}
		}
	}

	public static void main(String[] args) {
		// Skapa objekt av egna klassen
		DOMChangeElement dce = new DOMChangeElement();
	}
}