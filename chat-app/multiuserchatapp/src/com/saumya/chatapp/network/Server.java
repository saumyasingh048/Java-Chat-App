package com.saumya.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.saumya.chatapp.utils.configReader;

public class Server {
	// ServerSocket enables you to create a server
	ServerSocket serverSocket;
	// Contains all the ClientSocket
	ArrayList<ServerWorker> workers = new ArrayList<ServerWorker>();
	
	// Multiple Client
	
	public Server() throws IOException {
		int port = Integer.parseInt(configReader.getValue("PORT_NO"));
		serverSocket = new ServerSocket(port);
		System.out.println("Server Started and Waiting for Clients to join...");
		handleMultipleClients();
	}
	 
	public void handleMultipleClients() throws IOException {
		/*
		 * Idea behind: while(true): welcoming all the customers to the restraunt
		 * as they are coming.
		 */
		while (true) {
			
			// Handshaking
			Socket clientSocket = serverSocket.accept();
			// We want to build connection with multiple clients, so put this whole 
			// block of code in while(true).
			// Per Client per Thread 
			ServerWorker serverWorker = new ServerWorker(clientSocket, this);
			// Adding serverWorker to the list of threads.
			workers.add(serverWorker);
			serverWorker.start();
		}
		
	}
	/*
	 * The below written logic, was good to create handshaking for a single Client - Server Architecture.
	 * But, we have to deal with multiple clients, therefore, we need to change it a bit.
	 */
	// Single Client
	/*
	public Server() throws IOException {
		int port = Integer.parseInt(configReader.getValue("PORT_NO"));
		serverSocket = new ServerSocket(port);
		System.out.println("Server Started and waiting for clients");
		// Handshaking
		Socket socket = serverSocket.accept();
		System.out.println("Client joins the server");
		// To read the data on the network
		InputStream inputStream = socket.getInputStream();
		// this feature has come from Java - 9 onwards, owing to which all the bytes can be read at once.
		byte[] arr = inputStream.readAllBytes();
		String message = new String(arr);
		System.out.println("Message Received: " + message);
		socket.close();
	}
	*/
	public static void main(String[] args) throws IOException {
		Server server = new Server();
	}
}
