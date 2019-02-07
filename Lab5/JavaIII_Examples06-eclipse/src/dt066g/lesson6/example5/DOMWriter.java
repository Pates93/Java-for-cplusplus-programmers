package dt066g.lesson6.example5;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */

// Standard IO-klasser
import java.io.OutputStream;
import java.io.File;

// Agerar som en källa för ett XML-dokument (finns motsvarande för SAX)
import javax.xml.transform.dom.DOMSource;

// Resultatet av transformeringen
import javax.xml.transform.stream.StreamResult;

// Sträng-konstanter som används för inställningar av ett Transformer-objekt
import javax.xml.transform.OutputKeys;

// För att transformera ett XML-träd
import javax.xml.transform.Transformer;

// För att skapa en Transformer
import javax.xml.transform.TransformerFactory;

// Undantag som kan kastas vid användning Transformer och TransformerFactory
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerConfigurationException;

// XML-dokumentet
import org.w3c.dom.Document;

public class DOMWriter {
	public static void writeDocument(Document document, OutputStream out) {
		try {
			// Skapar en DOMSource för XML-dokumentet
			DOMSource xmlSource = new DOMSource(document);

			// Skapar en StreamResult för källan
			StreamResult result = new StreamResult(out);

			// Skapar en TransformerFactory och därefter en Transformer
			TransformerFactory tf = TransformerFactory.newInstance();
			Transformer transformer = tf.newTransformer();

			// Tar reda på vilken DOCTYPE som används i XML-dokumentet
			// Hoppa över detta om ingen DOCTYPE är satt
			if (document.getDoctype() != null) {
				String systemValue = (new File(document.getDoctype()
						.getSystemId())).getName();
				transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM,
						systemValue);
			}

			// Sätter vilken version, encoding och standalone som XML-dokumentet har
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