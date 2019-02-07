/**
 * @author Robert Jonsson (robert.jonsson@miun.se), ITM Östersund
 * @version 1.0
 * @file Ex05_08 - CountDownClientHandler.java
 */

import java.net.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class CountDownClientHandler extends Thread
{
	// Den socket kommunikation sker på
	private Socket socket;

	// Klientens adress
	private String address;

	// Konstruktor
	public CountDownClientHandler(Socket s)
	{
		socket = s;
		address = socket.getInetAddress().getHostAddress();
	}


	public void run()
	{
		// Deklarerar inström och utström
		BufferedReader in = null;
		BufferedWriter out = null;  // 1) se fotnot längs ner

		try
		{
			// Skapar in- och utströmmar för kommunikation
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		}
		catch (IOException ioe)
		{
			System.out.println(address + ": Kunde inte skapa strömmar");
			return; // Bör stänga strömmar och sockets först
		}

		// Vi har nu en uppkopplad förbindelse med klienten
		// Dags att ta emot tiden som vi ska räkna ner till
		Date targetDate = null;
		try
		{
			// Ta emot tiden från klienten
			String target = in.readLine();

			try
			{
				// Skapar det datum vi ska räkna ner till
				targetDate = DateFormat.getInstance().parse(target);
			}
			catch (ParseException pe)
			{
				System.out.println(address + ": Felaktigt datum " + target);
				System.out.println(address + ": Avbryter förbindelsen");
				out.write("Felaktigt datum");
				out.newLine();
				out.flush();
				return; // Bör stänga strömmar och sockets först
			}

			// Datum skapades ok. Skickar klartecken till klienten
			out.write("Datum OK");
			out.newLine();
			out.flush();
		}
		catch (IOException ioe)
		{
			System.out.println(address + ": Kunde inte läsa datum från klienten");
			System.out.println(address + ": Avbryter förbindelsen");
			return; // Bör stänga strömmar och sockets först
		}

		System.out.println(address + ": Räknar ner till " + targetDate);
		// Håll på så länge som slutdatum inte nåtts
		boolean targetDateReached = false;
		while(!targetDateReached)
		{
			// Tar reda på hur många millisekunder det är kvar till targetDate
			long dif = targetDate.getTime() - System.currentTimeMillis();

			String message;

			// Om skillnaden är positiv har vi ännu inte nått slutdatumet
			if (dif > 0)
			{
				// Delar upp tiden i timmar, minuter och sekunder
				long hours = dif / 3600000;
				dif %= 3600000;
				long minutes = dif / 60000;
				dif %= 60000;
				long seconds = dif / 1000;

				// Formaterar tiden
				DecimalFormat df = new java.text.DecimalFormat("00");
				message = df.format(hours) + ":" + df.format(minutes) + ":" + df.format(seconds);
			}
			else
			{
				// Slutdatum är nådd
				message = "00:00:00";
				targetDateReached = true;
				System.out.println(address + ": Slutdatum nått");
			}


			try
			{
				// Skickar tiden till klient
				out.write(message);
				out.newLine();
				out.flush();
			}
			catch (IOException ioe)
			{
				System.out.println(address + ": Kunde inte sända tid");
				break;
			}

			// Sover en stund
			try
			{
				sleep(1000);
			}
			catch (InterruptedException ie)
			{
				break;
			}
		}

		// Stänger strömmar och socket
		try
		{
			in.close();
			out.close();
			socket.close();
			System.out.println(address + ": Nedkopplad");
		}
		catch(IOException ioe)
		{
			System.out.println(address + " Kunde inte stänga strömmar och/eller sockets");
		}
	}
}