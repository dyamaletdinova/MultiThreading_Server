package socket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import model.Interest;

/**
 * 
 */

/**
 * @author Diana Yamaletdinova
 *
 * PaymentRunnable is designed to run in a thread, facilitating the obj being passed to a thread
 * Aug 16, 2017
 */
public class WorkerRunnable implements Runnable{
	
	protected Socket clientSocket = null;	
	private Interest interest; // passed to a thread to perform calculations

	public WorkerRunnable(Socket clientSocket) {
		this.clientSocket = clientSocket;//accepted connection stored in the object
	}
	
	@Override
	public void run() {
		//read the info from client and write it to the client
		//input from the client connection is gonna be stored in reader
		
		
		/* BufferedReader reads text from a character-input stream, 
		 * buffering characters so as to provide for the efficient reading of characters,lines and arrays
		 * BufferedReader can be "safely" shared between multiple threads, its synchronized 
		 * BufferedReader wraps an InputStreamReader which in turns wraps the socket's InputStream. 
		 * This adds extra functionality to the stream, because
		 * InputStreamReader only supports reading a char or a number of chars into an array. 
		 * BufferedReader's readLine()reads chars from the input stream and 'buffers' them until ending char is met
		 *  and than it returns this line as a string.
		 */
		
		//The Java runtime closes these resources automatically because they were created in the try-with-resources statement. 
		//The Java runtime closes these resources in reverse order that they were created.
		try (BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
				PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true)) {
			
			/* BufferedReader reads text from a character-input stream, 
			 * buffering characters so as to provide for the efficient reading of characters,lines and arrays
			 * BufferedReader can be "safely" shared between multiple threads, its synchronized 
			 * BufferedReader wraps an InputStreamReader which in turns wraps the socket's InputStream. 
			 * This adds extra functionality to the stream, because
			 * InputStreamReader only supports reading a char or a number of chars into an array. 
			 * BufferedReader's readLine()reads chars from the input stream and 'buffers' them until ending char is met
			 *  and than it returns this line as a string.
			 */
			//BufferedReader input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));//sent $ receive msg
			//formats stream to a text format for output
			//PrintWriter output = new PrintWriter(clientSocket.getOutputStream(), true);//gets the output to the printwriter

			
			if (input.readLine().equals("initialize")){
				String p, r;
				p = input.readLine();
				r = input.readLine();
				
				double principal = Double.parseDouble(p);
				double rate = Double.parseDouble(r);
				
				this.interest = new Interest(principal, rate);
				System.out.println("Client's data:  Principal is: " + p + " ; Rate is: " + r);
				output.println(interest.calvInvestmentValue());//calculate the values, and send them back
				output.println(interest.getInterest());//interest value 
				
			}
						
		} catch (IOException e) {
			
			System.out.println("something went wrong");
			e.printStackTrace();
		}
	}

}
