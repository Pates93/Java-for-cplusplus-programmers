package dt062g.olpa1600.assignment1;

import java.util.Scanner;

/*
 * Assignment 1
 * This application allows the user to enter data for a circle or rectangle, and get the circumference and area
 * based on the input. The results are printed on the screen.
 * 
 * @author Pætur Ólavsson Joensen (olpa1600)
 * @version 1.0
 * @since 11-11-2017
*/

public class Main {

	public static void main(String[] args) {
		
		boolean run = true;//Making a bool to be used in the while loop
		while(run) { //While run is true, run this part
			Scanner input = new Scanner(System.in); //Making a scanner
			System.out.print("What geometric shape do you want to use? "); //Asking the user for input
			String shape = input.nextLine(); //Reading the input
		switch(shape)
		{
		case "circle":
			circles circleObject = new circles();
			circleObject.printCircle(); //Call the print circle function
			break;
		case "rectangle":
			rectangle rectangleObject = new rectangle();
			rectangleObject.printRectangle(); //Call the print rectangle function
			break;
		case "exit":
			run = false; //If the user types in exit, the bool is set to be false and the program terminates
			break;
		default:
			System.out.println("Unknown shape"); //If the input is any other than circle, rectangle or exit, print unknown shape
			break;
		}
		input.close();
	}
		
	}
}
