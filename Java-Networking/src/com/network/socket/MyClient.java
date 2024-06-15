package com.network.socket;

import java.io.ObjectOutputStream;
import java.net.Socket;

public class MyClient {

	public static void main(String[] args) {
		
		try {
			
			// create a socket to connect to the server
			// Create a TCP/IP client socket
			Socket soc = new Socket("localhost",5555);
			 // send a message to the server
			ObjectOutputStream out = new ObjectOutputStream(soc.getOutputStream());
			out.writeUTF(" Hello Server");
			out.flush();
			
			// close the ObjectOutputStream
			out.close();
			
			// close the socket
			soc.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
