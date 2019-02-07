package dt066g.lesson6.example8;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import dt066g.lesson6.example7.Course;

/**
 * @author Robert Jonsson (robert.jonsson@miun.se), DSV Östersund
 * @version 1.0
 */
public class TestSummerCoursesToXML {
	public static void main(String[] args) {
		// Skapa ett SummerCourses-objekt för år 2015 och lägg in tre Course-objekt		
		SummerCourses courses = new SummerCourses(2015);
		Course java3 = new Course();
		java3.setName("Java III");
		java3.setCourseCode("DT066G");
		java3.setPoints(7.5);
		java3.setDescription("Sista kursen i vår Java-stege.");
		java3.setApplicationCode("MIU-C4036");
		java3.setStart(24);
		java3.setEnd(36);
		
		Course java2 = new Course();
		java2.setName("Java II");
		java2.setCourseCode("DT007G");
		java2.setPoints(7.5);
		java2.setDescription("Andra kursen i vår Java-stege.");
		java2.setApplicationCode("MIU-C4035");
		java2.setStart(24);
		java2.setEnd(36);
				
		Course java1 = new Course();
		java1.setName("Java I");
		java1.setCourseCode("DT006G");
		java1.setPoints(7.5);
		java1.setDescription("Första kursen i vår Java-stege.");
		java1.setApplicationCode("MIU-C4034");
		java1.setStart(24);
		java1.setEnd(36);
		
		courses.add(java1);
		courses.add(java2);
		courses.add(java3);
		
		try {
			// Skapa en JAXB marshaller (skrivare) för våra klasser SummerCourses och Course
			JAXBContext context = JAXBContext.newInstance(SummerCourses.class, Course.class);			
			Marshaller marshaller = context.createMarshaller();
			
			// Ange att utskriften ska formateras (indenteras)
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			
			// Skriver objektet till xml (mål är både till fil och standard utström)
			marshaller.marshal(courses, new File("summercourses" + courses.getYear() + ".xml"));
			marshaller.marshal(courses, System.out);
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}