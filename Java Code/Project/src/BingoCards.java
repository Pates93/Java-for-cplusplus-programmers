import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
* <h1>Project</h1>
* This class responsible for creating a bingo card, and saving it to txt file.
* 
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since  19-01-2018
*/

public class BingoCards {
	
	//Making 5 ArrayList for each number interval
	private ArrayList<Integer> numbers15;
	private ArrayList<Integer> numbers30;
	private ArrayList<Integer> numbers45;
	private ArrayList<Integer> numbers60;
	private ArrayList<Integer> numbers75;
	private static ArrayList<String>cards;


	//Constructor
	public BingoCards() {
		cards = new ArrayList<String>();
		generateNumbers();
	}
	
	@SuppressWarnings("deprecation")
	public void generateNumbers() {
	numbers15 = new ArrayList<Integer>();
	numbers30 = new ArrayList<Integer>();
	numbers45 = new ArrayList<Integer>();
	numbers60 = new ArrayList<Integer>();
	numbers75 = new ArrayList<Integer>();
	
	//Getting numbers into each ArrayList
	for(int i = 1; i<=15; i++) {
		numbers15.add(new Integer(i));
	}
	for(int i = 15; i<=30; i++) {
		numbers30.add(new Integer(i));
	}
	for(int i = 30; i<=45; i++) {
		numbers45.add(new Integer(i));
	}
	for(int i = 45; i<=60; i++) {
		numbers60.add(new Integer(i));
	}
	for(int i = 60; i<=75; i++) {
		numbers75.add(new Integer(i));
	}
	
	//Shuffling the ArrayLists, so the numbers are random
	Collections.shuffle(numbers15);
	Collections.shuffle(numbers30);
	Collections.shuffle(numbers45);
	Collections.shuffle(numbers60);
	Collections.shuffle(numbers75);
	}
	
	public List<String> createCard(){
	
		//Making the bingo card. Getting 5 numbers from the shuffled arrayList
		//and insert them into 9 strings.
		String line1 = "-------------------------";
		String line2 = "| B  | I  | N  | G  | O  |";
		String line3 = "| "+numbers15.get(0)+"  | "+numbers30.get(0)+"  | "+ numbers45.get(0)+ "  | "+numbers60.get(0)+  " | "+ numbers75.get(0)+  " | ";
		String line4 = "| "+numbers15.get(1)+"  | "+numbers30.get(1)+"  | "+ numbers45.get(1)+ "  | "+numbers60.get(1)+  " | "+ numbers75.get(1)+  " | ";
		String line5 = "| "+numbers15.get(2)+"  | "+numbers30.get(2)+"  | "+ numbers45.get(2)+ "  | "+numbers60.get(2)+  " | "+ numbers75.get(2)+  " | ";
		String line6 = "| "+numbers15.get(3)+"  | "+numbers30.get(3)+"  | "+ numbers45.get(3)+ "  | "+numbers60.get(3)+  " | "+ numbers75.get(3)+  " | ";
		String line7 = "| "+numbers15.get(4)+"  | "+numbers30.get(4)+"  | "+ numbers45.get(4)+ "  | "+numbers60.get(4)+  " | "+ numbers75.get(4)+  " | ";
		String line8 = "| "+numbers15.get(5)+"  | "+numbers30.get(5)+"  | "+ numbers45.get(5)+ "  | "+numbers60.get(5)+  " | "+ numbers75.get(5)+  " | ";
		String line9 = "-------------------------";
		
		//Add each string to the ArrayList
		cards.add(line1);
		cards.add(line2);
		cards.add(line3);
		cards.add(line4);
		cards.add(line5);
		cards.add(line6);
		cards.add(line7);
		cards.add(line8);
		cards.add(line9);
		
		return cards;
		
	}
	public static void saveCard() {
		//Making a new file
		File card = new File("Card.txt");
			try {
				if(card.exists() == false) { //If the file doesn't exists, make a new file
					card.createNewFile();
				}
				PrintWriter out = new PrintWriter(new FileWriter(card, true));
				for(String str : cards) { //for every string inside Array List
					out.println(str); //Write them out to file
				}
				out.close(); //close the writer
				System.out.println("Card has been saved to file");
		}catch(IOException e) {
			System.err.println("Error when trying to load to file");
		}
	}
}

