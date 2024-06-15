package com.network.socket;

import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
	public static void main(String[] args) {
		
		try {
			
			// Create a TCP/IP server socket
			ServerSocket sos = new ServerSocket(5555);
			Socket soc = sos.accept(); // establishes connection
			
			// receive a message from the server
			ObjectInputStream ois = new ObjectInputStream(soc.getInputStream());
			String str =(String) ois.readUTF();
			
			System.out.println("message"+str);
			
			// close the socket
			sos.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
