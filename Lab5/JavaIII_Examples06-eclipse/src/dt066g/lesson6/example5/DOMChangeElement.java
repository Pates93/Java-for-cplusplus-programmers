package dt066g.lesson6.example5;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), ITM �stersund
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

		// Anger att fabriken ska ignorera element som endast inneh�ller white spaces
		factory.setIgnoringElementContentWhitespace(true);

		try {
			// Skapar en DocumentBuilder genom att anropa newDocumentBuilder p� "fabriken"
			DocumentBuilder parser = factory.newDocumentBuilder();

			// Skapar ett Document-objekt av summercourses.xml
			dom = parser.parse("summercourses.xml");

		} catch (SAXException se) {
			// Om ett fel eller varning ges n�r XML-dokumentet tolkas
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
		// H�mta root elementet
		Element root = dom.getDocumentElement();

		// H�mta en lista �ver alla element i root med namnet kursnamn
		NodeList allNames = root.getElementsByTagName("name");

		// Finns det n�gra noder i listan
		if (allNames != null && allNames.getLength() > 0) {
			Node java1 = null;

			// Loopa igenom alla kursnamn (noder) och leta efter Java I
			for (int i = 0; i < allNames.getLength(); i++) {
				Node currentName = allNames.item(i);

				// H�mta Text (inneh�ll) f�r elementet
				// Ett elements inneh�ll representeras i tr�det av en egen nod
				// av typen text
				// D�rf�r h�mtar vi f�rsta barn-noden till aktuell nod (kursnamnet)
				// F�rsta barn-noden �r text-noden och s�ledes namnet p� kursen
				Text text = (Text) currentName.getFirstChild();

				// Kontrollerar om texten �r Java I genom att anropa getNodeValue
				if (text.getNodeValue().equalsIgnoreCase("Java I")) {
					// Detta �r kursen Java I s� vi h�mtar f�r�ldrarnoden till aktuellt Kursnamn
					// F�r�ldrarnoden �r med andra ord hela kurs-elementet (noden) f�r Java I
					java1 = currentName.getParentNode();
					break;
				}
			}

			// Har vi hittat kursen Java I?
			if (java1 != null) {
				// H�mta beskrivningen (eftersom vi med DTDn best�mt ordningen kan vi g�ra s� h�r)
				Node description = java1.getChildNodes().item(3);
				Text oldDescription = (Text) description.getFirstChild();

				// Skapar den nya beskrivningen
				Text newDescription = dom
						.createTextNode("Ny beskrivning f�r Java I");

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