package your.package;

/**
* <h1>Assignment 5</h1>
* This application creates a <code>Drawing</code> with a name,
* author and different shapes in it. It then saves the drawing
* to XML, clear the drawing and then loads a drawing from XML. 
*
* @author  Your Name (studentid)
* @version 1.0
* @since   date last edited
*/
public class Assignment5 {

	public static void main(String[] args) {
		testDrawing();
	}

	private static void testDrawing() {
		// Create a drawing with a name and author.
		System.out.println("Create a drawing...\n");
		Drawing d1 = null;
			
		// Create at least 5 shapes with end points
		
		// Add shapes to the drawing
		
		// Print the drawing
		d1.draw();
		
		// Save the drawing to XML
		final String fileName = "MyDrawing.xml";
		System.out.println("\nSave the drawing to " + fileName + "...");
		FileHandler.saveToXML(d1, fileName);
		
		// Clear and print
		System.out.println("\nClearing the drawing and then draw it....");
		d1.clear();
		d1.draw();
		
		// Load drawing from XML
		System.out.println("\nLoad drawing from " + fileName + "...\n");
		d1 = FileHandler.loadFromXML(fileName);
		
		// Print the drawing
		d1.draw();
	}
}