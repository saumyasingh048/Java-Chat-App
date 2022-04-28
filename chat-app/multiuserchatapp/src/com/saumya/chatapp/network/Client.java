package com.saumya.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JTextArea;

import com.saumya.chatapp.utils.configReader;

public class Client {
	Socket socket;
	InputStream in;
	OutputStream out;
	JTextArea textArea;
	ClientWorker clientWorker;
	public Client(JTextArea textArea) throws UnknownHostException, IOException {
		int port = Integer.parseInt(configReader.getValue("PORT_NO"));
		// Client should be aware of the following 2 things,
		// to reach the right server over the Internet - 
		// 1. Server's Tower :- IP Address
		// 2. Server's Flat No. :- Port No.
		socket = new Socket(configReader.getValue("IP_ADDRESS"), port);
		in = socket.getInputStream();
		out = socket.getOutputStream();
		this.textArea = textArea;
		readMessage();
		/*
		System.out.println("Client joins in... / Client has come and is ready...");
		System.out.println("Write a message to the Server: ");
		Scanner scanner = new Scanner(System.in);
		String message = scanner.nextLine();
		// To write the data on the network
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(message.getBytes());
		System.out.println("Hurray!! Message has been successfully sent to the Server.");
		// Close the resource to avoid its leakage
		outputStream.close();
		socket.close();
		*/
	}
	public void sendMessage(String message) throws IOException {
		message = message + "\n";
		out.write(message.getBytes());
	}
	
	public void readMessage() throws IOException {
		clientWorker = new ClientWorker(in, textArea);
		clientWorker.start();	
	}
//	public static void main(String[] args) throws UnknownHostException, IOException {
//		Client client = new Client();
//	}
}
