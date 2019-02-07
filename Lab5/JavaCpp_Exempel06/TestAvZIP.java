/**
 * @author Robert Jonsson, ITM Östersund
 * @version 2.0
 * @file Ex03_12 - TestAvZIP.java
 */

public class TestAvZIP
{
	public static void main(String[] args)
	{
		String[] files = {"RomanNumeral.java", "blablabla.java", "temp", "Concatenate.java"};
		ZIP.compress(files, "myZIP.zip");

		System.out.println();

		ReadZIP.read("myZIP.zip");

		System.out.println();

		ZIP.decompress("myZIP.zip", "temp" + java.io.File.separator + "temp2");

	}
}