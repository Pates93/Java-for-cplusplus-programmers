package dt066g.lesson6.example5;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV �stersund
 * @version 1.0
 */

// Standard IO-klasser
import java.io.OutputStream;
import java.io.File;

// Agerar som en k�lla f�r ett XML-dokument (finns motsvarande f�r SAX)
import javax.xml.transform.dom.DOMSource;

// Resultatet av transformeringen
import javax.xml.transform.stream.StreamResult;

// Str�ng-konstanter som anv�nds f�r inst�llningar av ett Transformer-objekt
import javax.xml.transform.OutputKeys;

// F�r att transformera ett XML-tr�d
import javax.xml.transform.Transformer;

// F�r att skapa en Transformer
import javax.xml.transform.TransformerFactory;

// Undantag som kan kastas vid anv�ndning Transformer och TransformerFactory
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;

// XML-dokumentet
import org.w3c.dom.Document;

public class DOMWriter {
	public static void writeDocument(Document document, OutputStream out) {
		try {
			// Skapar en DOMSource f�r XML-dokumentet
			DOMSource xmlSource = new DOMSource(document);

			// Skapar en StreamResult f�r k�llan
			StreamResult result = new StreamResult(out);

			// Skapar en TransformerFactory och d�refter en Transformer
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();

			// Tar reda p� vilken DOCTYPE som anv�nds i XML-dokumentet
			// Hoppa �ver detta om ingen DOCTYPE �r satt
			if (document.getDoctype() != null) {
				String systemValue = (new File(document.getDoctype()
						.getSystemId())).getName();
				transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,
						systemValue);
			}

			// S�tter vilken version, encoding och standalone som XML-dokumentet har
			transformer.setOutputProperty(OutputKeys.VERSION,
					document.getXmlVersion());

			if (document.getXmlEncoding() != null)
				transformer.setOutputProperty(OutputKeys.ENCODING,
						document.getXmlEncoding());
			transformer.setOutputProperty(OutputKeys.STANDALONE,
					document.getXmlStandalone() ? "yes" : "no");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");

			// Transformera
			transformer.transform(xmlSource, result);
		} catch (TransformerConfigurationException tfce) {
			tfce.printStackTrace();
		} catch (TransformerException te) {
			te.printStackTrace();
		}
	}
}