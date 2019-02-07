package dt062g.olpa1600.assignment1;

import java.util.Scanner;

/*
 * Assignment 1
 * This class is used to do calculations on a rectangle and print the results
 * 
 * 
 * @author Pætur Ólavsson Joensen (olpa1600)
 * @version 1.0
 * @since 11-11-2017
*/
public class rectangle {

	public static void printRectangle() {
		//Declaring variables
		double width, height, circumference, area;
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter width: ");//Asking the user for width
		width = input.nextDouble(); //Reading input
		System.out.print("Enter height: "); //Asking the user for height
		height = input.nextDouble(); //Reading input
		circumference = 2 * (height + width); //Calculating circumference
		area = width * height; //Calculate area
		
		//printing the results
		System.out.print("circumference = ");
		System.out.println(circumference);
		System.out.print("area = ");
		System.out.println(area);
		input.close();
	}

}
