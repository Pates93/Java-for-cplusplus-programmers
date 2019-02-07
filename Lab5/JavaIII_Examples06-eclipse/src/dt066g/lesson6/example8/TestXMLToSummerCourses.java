 package dt066g.lesson6.example8;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */
public class TestXMLToSummerCourses {
	public static void main(String[] args) {
		// Skapa ett SummerCourses-objekt		
		SummerCourses courses = null;
		
		try {
			// Skapa en JAXB unmarshaller (läsare) för vår klass SummerCourses
			JAXBContext context = JAXBContext.newInstance(SummerCourses.class);			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			// Läser objektet från xml och gör en cast till rätt typ
			courses = (SummerCourses) unmarshaller.unmarshal(new File("summercourses2015.xml"));
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(courses);
	}
}