package dt062g.olpa1600.assignment8.server;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread {

	private DataInputStream input;
	private DataOutputStream output;
	protected Socket socket;
	public static String DEFAULT_FOLDER = "src/dt062g/olpa1600/assignment8/server/xml";

	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {

		try {
			//Making input and outputs
			input = new DataInputStream(socket.getInputStream());
			output = new DataOutputStream(socket.getOutputStream());
			do {
				//Receiving the command
				String command = input.readUTF();
				//printing out what command was received and from where
				System.out.println("Command '" + command + "' received from " + socket.getInetAddress().getHostAddress());
				
				//Calling function based on the command
				switch (command) {
				case "list":
					list();
					break;
				case "load":
					load();
					break;
				case "save":
					save();
					break;
				default:
					break;
				}
			} while (input.available() > 0);
		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void list() {
		
		try {
			//Making a file, based on the path of the default folder
			File dir = new File(Server.DEFAULT_FOLDER);

			//Getting the files which end with .xml
			File[] files = dir.listFiles(new FilenameFilter() {
				public boolean accept(File dir, String name) {
					String lowercaseName = name.toLowerCase();
					if (lowercaseName.endsWith(".xml")) {
						return true;
					} else
						return false;
				}
			});
			//Write how many files were found
			output.writeInt(files.length);
			//Showing where the list of files are send to
			System.out.println("Sending list of files to " + socket.getInetAddress().getHostAddress());
			//Sending the file name to the client
			for (File f : files) {
				output.writeUTF(f.getName());
			}

		}

		catch (Exception e) {
			System.err.print("Error when searching for files");
		}

	}

	public void load() {
		
		try {
			// Get name of file to send
			String filename = input.readUTF();
			
			//Making sure that there is a file
			if (filename != null && filename.length() > 0) {
				
				//Making a new file based on the file path
				File file = new File("src/dt062g/olpa1600/assignment8/server/xml/" + filename);
				
				// Checking if the file exists
				long size = -1;
				if (file.exists()) {
					size = file.length();
				}

				// Sending the file to the client
				output.writeLong(size);

				// Printing out the result
				if (size != -1) {
					System.out.println("Size of '" + filename + "' is " + size + " bytes");
				} else {
					System.err.println("File '" + filename + "' does not exist");
					return;
				}

				//Printing out where the file is being sent
				System.out.print("Sending file to " + socket.getInetAddress().getHostAddress());

				// Reading the file from the input stream
				BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(file));

				//Making a buffer and writing the file to server
				int temp;
				byte[] buffer = new byte[8192];
				while ((temp = fileInput.read(buffer)) > 0) {
					output.write(buffer, 0, temp);
				}

				//Close the input stream
				fileInput.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("Could not send file! " + e.getMessage());
		}
	}

	private void save() {
		try {
			//Receiving the filename
			String filename = input.readUTF();
			
			//Making a buffer
			byte[] buffer = new byte[(int) input.readLong()];
			System.out.println("Loading file from client..");
			
			//Receiving the file
			input.read(buffer);
			
			//Printing out the size of the file
			System.out.println("Size of file: " + buffer.length);
			
			//Making a file output stream based on the default folder 
			FileOutputStream fout = new FileOutputStream(Server.DEFAULT_FOLDER + filename);
			//Write the file to the folder
			fout.write(buffer);
			fout.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
