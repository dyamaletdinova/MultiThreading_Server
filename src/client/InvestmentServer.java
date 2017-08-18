package client;

import socket.SocketServer;

/**
 * @author Diana Yamaletdinova
 *
 * Aug 16, 2017
 */
public class InvestmentServer {
	public static void main(String[] args) {
		SocketServer ss = new SocketServer();
		try {
			ss.runServer();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
