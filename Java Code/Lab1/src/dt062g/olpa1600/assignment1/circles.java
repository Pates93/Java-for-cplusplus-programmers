package dt062g.olpa1600.assignment1;
import java.util.Scanner;

/*
 * Assignment 1
 * This class is used to do calculations on a circle and print the results
 * 
 * 
 * @author Pætur Ólavsson Joensen (olpa1600)
 * @version 1.0
 * @since 11-11-2017
*/
public class circles {
	public static void printCircle(){
		
		//Declaring variables
		double radius;
		final double pi = 3.14;
		double circumference;
		double area;
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter radius: "); //Asking the user for input
		radius = input.nextDouble(); //reading the input
		circumference = 2 * pi * radius; //Calculating circumference
		area = pi * radius * radius; //Calculating the area
		
		//Printing the results
		System.out.print("Circumference = "); 
		System.out.println(circumference); 
		System.out.print("Area = ");
		System.out.println(area);
		input.close();
	}
}

