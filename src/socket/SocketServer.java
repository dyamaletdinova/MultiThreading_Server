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

		try {
			serverSocket = new ServerSocket(portNum);//creates a new socket that runs on these port
		} catch (IOException e) {
			System.out.println("The server with port " + portNum + " cannot be created");
		}
		
		//to offer a multi-threaded env. - each time we accept the connection from a client, we want to put it in the different thread 
		while (true){
			//always will look for connections
			Socket clientSocket = null;
			
			try {
				System.out.println("Server waiting for incoming messages");
				clientSocket = serverSocket.accept();	
			} catch (IOException e) {
				if (!true){
					System.out.println("Server Stopped. Can't accept the client connection") ;
					return;
				}
				throw new RuntimeException("Error accepting client's connection", e);
			}
			//create a new thread for each incoming request and pass it 'worker runnable' to handle the processing
			new Thread(new WorkerRunnable(clientSocket)).start();
		}
	} 
}
