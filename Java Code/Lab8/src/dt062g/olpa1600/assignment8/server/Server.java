/**
 * 
 */
package dt062g.olpa1600.assignment8.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author patur
 *
 */
public class Server extends Thread {

	public static String DEFAULT_FOLDER = "src/dt062g/olpa1600/assignment8/server/xml";

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {

		ServerSocket ss = null;
		try {
			if (args.length > 0) {
				ss = new ServerSocket(Integer.parseInt(args[0]));
				System.out.println("Server started on port " + ss.getLocalPort());
			} else {
				ss = new ServerSocket(10500);
				System.out.println("Server started on port " + ss.getLocalPort());
			}
		} catch (IOException e) {
			System.out.println("Couldn't open port");
		}
		while (true) {
			try {

				Socket s = ss.accept();

				System.out.println("New Client connected from " + s.getInetAddress().getHostAddress());
				new ClientHandler(s).start();
			} catch (IOException ioe) {
				System.out.println("Error when connecting to client " + ioe);
			}
		}

	}
}
