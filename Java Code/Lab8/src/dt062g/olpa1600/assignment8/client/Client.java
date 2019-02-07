package dt062g.olpa1600.assignment8.client;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Path;

public class Client {

	public final static String DEFAULT_ADDRESS = "localhost";
	public final static int DEFAULT_PORT = 10500;
	public static String DEFAULT_FOLDER = "src/dt062g/olpa1600/assignment8/server/xml/";
	private String address;
	private int port;
	private Socket socket;
	private DataInputStream input;
	private DataOutputStream output;

	public Client(String address, int port) {
		this.address = address;
		this.port = port;
	}

	public Client() {
		this(DEFAULT_ADDRESS, DEFAULT_PORT);
	}

	public boolean connect() {

		if (socket == null || !socket.isConnected()) {
			try {
				socket = new Socket(this.address, this.port);
				input = new DataInputStream(socket.getInputStream());
				output = new DataOutputStream(socket.getOutputStream());
				return true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

	public void disconnect() {
		try {
			System.out.println("Client from " + socket.getInetAddress().getHostAddress() + " has disconnected");
			socket.close();
			socket = null;
			input = null;
			output = null;

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String[] getFileNamesFromServer() {

		
		try {
			//Connecting to the server
			connect();
			//If the socket is is then the there is no connection
			if (socket == null) {
				throw new IOException();
			} else {
				//send the command
				output.writeUTF("list");

				//Receiving the number of files
				int numberOfFiles = input.readInt();
				//Making a array with the size, based on how many files there are
				String[] files = new String[numberOfFiles];
				
				//Sending the file names
				for (int i = 0; i < numberOfFiles; i++) {
					files[i] = input.readUTF();
				}
				//Terminating the connection
				disconnect();
				return files;
			}
		} catch (IOException e) {
			return null;
		}
	}

	public String getFileFromServer(String fileName) {

		try {
			// Connecting to server
			connect();
			
			//Sending command
			output.writeUTF("load");
			//Sending the file name
			output.writeUTF(fileName);

			//Making a buffer with the length of the file
			byte[] buffer = new byte[(int) input.readLong()]; // or 4096, or more

			input.read(buffer);
			
			//Making a file output stream  with a path
			FileOutputStream fileOutput = new FileOutputStream("src/dt062g/olpa1600/assignment8/client/xml/" + fileName);
			//Write the file
			fileOutput.write(buffer);
			
			//Making a string with the path
			String path = "src/dt062g/olpa1600/assignment8/client/xml/" + fileName;

			//Disconnect the connection
			disconnect();
			//Disconnecting the file output stream
			fileOutput.close();
			return path;

		} catch (IOException io) {
			System.err.println("Error when getting file from server");
			io.printStackTrace();
			return null;
		}
	}

	public boolean saveAsFileToServer(String localFile, String fileName) {
		try {
			// Connecting to server
			connect();
			// Sending the command
			output.writeUTF("save");

			// making a new file
			File file = new File(Client.DEFAULT_FOLDER + localFile);

			// sending the the file name
			output.writeUTF(fileName);

			// Checking if the file exists
			long size = -1;
			if (file.exists()) {
				size = file.length();
			}

			// Sending the file to the client
			output.writeLong(size);

			// Printing out the result
			if (size != -1) {
				System.out.println("Size of '" + localFile + "' is " + size + " bytes");
			} else {
				System.err.println("File '" + localFile + "' does not exist. Disconnecting!");
				return false;
			}

			System.out.print("Sending file to Server ...");

			// Reading the file from the input stream
			BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(file));

			// Making a buffer and writing the file to server
			int temp;
			byte[] buffer = new byte[8192];
			while ((temp = fileInput.read(buffer)) > 0) {
				output.write(buffer, 0, temp);
			}

			// Closing stream
			fileInput.close();

			// Disconnecting the connection
			disconnect();
			return true;
		} catch (IOException io) {
			io.printStackTrace();
			return false;
		}
	}

	public void saveFileToServer(String localFile) {
		saveAsFileToServer(localFile,localFile);
	}
}
