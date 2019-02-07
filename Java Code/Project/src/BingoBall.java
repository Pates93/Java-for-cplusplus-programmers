/*
* <h1>Project</h1>
* This class is responsible for the structure of the bingoBall
* It has a number, and a String number. If the ball gets the number 10
* then the string number will be B10
*
* @author  Pætur Ólavsson Joensen (olpa1600)
* @version 1.0
* @since  19-01-2018
*/


public class BingoBall {

	private String stringNumber;
	private int number;

	//Constructor
	public BingoBall(int number) {
		this.number = number;
		this.stringNumber = getCharBall(number);
	}
	//Getting the char based on what interval the number is in
	public String getCharBall(int ballNumber) {
		if(ballNumber >= 1 && ballNumber <= 15) {
			return ("B"+ballNumber);
		}
		if(ballNumber >= 16 && ballNumber <= 30) {
			return ("I"+ballNumber);
		}
		if(ballNumber >= 31 && ballNumber <= 45) {
			return ("N"+ballNumber);
		}
		if(ballNumber >= 46 && ballNumber <= 60) {
			return ("G"+ballNumber);
		}
		if(ballNumber >= 61 && ballNumber <= 75) {
			return ("O"+ballNumber);
		}
		return null;
	}
	//Get string number
	public String getStringNumber() {
		return stringNumber;
	}
	//Get number
	public int getNumber() {
		return number;
	}
}
