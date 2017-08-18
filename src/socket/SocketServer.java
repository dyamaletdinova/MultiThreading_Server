package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * @author Diana Yamaletdinova
 *
 *all of the socket server functionality
 * Aug 16, 2017
 */

public class SocketServer {
	int portNum = 44444;
	ServerSocket serverSocket = null;
	
	@SuppressWarnings("unused")
	public void runServer() throws InterruptedException{
		//sets the server socket
		try {
			serverSocket = new ServerSocket(portNum);//creates a new socket that runs on our port
		} catch (IOException e) {
			System.out.println("Something went wrong: \n" + e.getMessage());
		}
		
		//to offer a multi-threaded env. - each time we accept the connection from a client, we want to put it in the different thread 
		//by creating a new socket
		//in this example i will accept every connection 
		while (true){//always will look for connections
			Socket clientSocket = null;
			try {
				clientSocket = serverSocket.accept();
				//new thread is created here
	
			} catch (IOException e) {
				if (!true){
					System.out.println("Can't accept the client connection + \n" + e.getMessage());
					System.out.println("Server Stopped.") ;
					return;
				}
				throw new RuntimeException("Error accepting client connection", e);
			}
			//processingDelay(1000);
			new Thread(new WorkerRunnable(clientSocket)).start();
			System.out.println("\n new thread is created \n");
			
		}
	}
	
	public static void processingDelay(int msec) throws InterruptedException {
		System.out.println("----------------Sleep for " + msec);
		Thread.sleep(msec);
	}
	
	 
}
