package dt062g.olpa1600.assignment5;

/**
* <h1>Assignment 5</h1>
* This application creates a <code>Drawing</code> with a name,
* author and different shapes in it. It then saves the drawing
* to XML, clear the drawing and then loads a drawing from XML. 
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since   5-12-2017
*/
public class Main {

	public static void main(String[] args) {
		testDrawing();
	}

	private static void testDrawing() {
		// Create a drawing with a name and author.
		System.out.println("Create a drawing...\n");
		Drawing d1 = null;
		
		// Create at least 5 shapes with end points
		d1 = new Drawing("Pætur", "MasterPiece");
		
		Circle c1 = new Circle(0, 3, "Black");
		c1.addPoint(5, 3);
		
		Circle c2 = new Circle(1,4,"Red");
		c2.addPoint(7, 11);
		
		Circle c3 = new Circle(0,7,"Orange");
		c3.addPoint(7,4);
		
		Rectangle r1 = new Rectangle(100,34, "Blue");
		r1.addPoint(10, 5);
		
		Rectangle r2 = new Rectangle(12,33,"Pink");
		r2.addPoint(1, 2);
		
		// Add shapes to the drawing
		d1.addShape(c1);
		d1.addShape(c2);
		d1.addShape(c3);
		d1.addShape(r1);
		d1.addShape(r2);
		
		
		
		
		
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