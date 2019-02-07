package dt066g.lesson6.example7;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV �stersund
 * @version 1.0
 */
public class TestXMLToCourse {
	public static void main(String[] args) {
		// Skapa Course-objekt		
		Course java3 = null;
		
		try {
			// Skapa en JAXB unmarshaller (l�sare) f�r v�r klass Course
			JAXBContext context = JAXBContext.newInstance(Course.class);			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			// L�ser objektet fr�n xml och g�r en cast till r�tt typ
			java3 = (Course) unmarshaller.unmarshal(new File("JavaIII_course.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(java3);
	}
}