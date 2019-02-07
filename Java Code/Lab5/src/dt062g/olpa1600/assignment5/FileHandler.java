package dt062g.olpa1600.assignment5;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/*
* <h1>Assignment 5</h1>
* 
* This class is used to save to file and read from file using marshaller and JAXBContext
* 
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since   5-12-2017
*/

public class FileHandler {
	
	//Saving a drawing into a xml file
	public static void saveToXML(Drawing drawing, String fileName){
		
			//If the filename doesn't end with xml, then add xml to the ending
			if(!fileName.endsWith(".xml")) {
				fileName = fileName + ".xml";
			}
			try {
				
				JAXBContext context = JAXBContext.newInstance(Drawing.class);			
				Marshaller marshaller = context.createMarshaller();
				
				
				marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				
				
				marshaller.marshal(drawing,new File(fileName));
				marshaller.marshal(drawing, System.out);
			} catch (JAXBException e) {
				
				System.err.println("Error occurred when trying to save to XML file");

				
			}
	}
	
	//Saving a drawing to a xml file
	public static void saveToXML(Drawing drawing) {
		
		if(drawing.getAuthor() == "" || drawing.getName() == "") {
			System.err.println("The drawing needs an author or a name, when saving to file");
			return;
		}
		
		String fileName = drawing.getName() + " by " + drawing.getAuthor() + ".xml";
		saveToXML(drawing, fileName);
	}
	//Loading from xml file
	public static Drawing loadFromXML(String filename) {
		
		Drawing drawing = null;
		try {			
			
			JAXBContext context = JAXBContext.newInstance(Drawing.class);			
			Unmarshaller unmarshaller = context.createUnmarshaller();
			
			drawing = (Drawing) unmarshaller.unmarshal(new File(filename));
		} catch (JAXBException e) {
			System.err.println("Error occurred when trying to load from file");
		}
		return drawing;
	}
	
}
