package dt066g.lesson6.example7;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV �stersund
 * @version 1.0
 */
public class TestCourseToXML {
	public static void main(String[] args) {
		// Skapa Course-objekt		
		Course java3 = new Course();
		java3.setName("Java III");
		java3.setCourseCode("DT066G");
		java3.setPoints(7.5);
		java3.setDescription("Sista kursen i v�r Java-stege.");
		java3.setApplicationCode("MIU-C4036");
		java3.setStart(24);
		java3.setEnd(36);
		
		try {
			// Skapa en JAXB marshaller (skrivare) f�r v�r klass Course
			JAXBContext jaxbContext = JAXBContext.newInstance(Course.class);			
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			
			// Ange att utskriften ska formateras (indenteras)
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			// Skriver objektet till xml (m�l �r b�de till fil och standard utstr�m)
			jaxbMarshaller.marshal(java3, new File("JavaIII_course.xml"));
			jaxbMarshaller.marshal(java3, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}