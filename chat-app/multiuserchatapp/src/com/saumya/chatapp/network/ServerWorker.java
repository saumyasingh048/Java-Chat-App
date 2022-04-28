package com.saumya.chatapp.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

// Thread == Worker
// Thread says, give me some work to do.
// As a result, we give, runnable.
// Runnable is an interface which says, implement my only abstract method ---> run()


public class ServerWorker extends Thread{
	private Socket clientSocket;
	private InputStream in;
	private OutputStream out;
	private Server server;

	public ServerWorker(Socket clientSocket, Server server) throws IOException {
		// TODO Auto-generated constructor stub
		this.clientSocket = clientSocket;
		this.server = server;
		in = clientSocket.getInputStream();
		out = clientSocket.getOutputStream();
		System.out.println("New Client Comes");
	}
	@Override
	public void run() {
		// To read the data, that client has sent.
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
		// NOTE: BufferedReader reads the data, line by line.
		String line;
		try {
		while(true) {
		//	Line has been read;		
			
			line = bufferedReader.readLine();
			System.out.println("Line:" + line);
			if (line.equalsIgnoreCase("quit")) {
				break;
			}
			// What to do in else case / condition ?
			// The below written line will send / write the received line of code back to the same client.
			// NOTE: This is NOT Broadcasting
//			out.write(line.getBytes());
			// Following is the process of broadcasting using for - each Loop.
			for (ServerWorker worker : server.workers) {
				line = line + "\n";
				worker.out.write(line.getBytes());
			}
		}
		// 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if (bufferedReader != null) {
				try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (clientSocket != null) {
				try {
					clientSocket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}





// This was merely a basic knowledge about threads that is useful to get know about the threads.

/*
public class ServerWorker implements Runnable {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Create a Job to be allotted to a thread.
		
		ServerWorker job = new ServerWorker();
		// Create a thread.
		Thread worker = new Thread(job);
		// Start the thread ---> Internally, It calls run() method, which assigns the job.
		worker.start();
		for (int i = 0; i < 5; i++) {
			System.out.println("Main thread" + Thread.currentThread());
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 5; i++) {
			go();
		}
		
	}

	private void go() {
		// TODO Auto-generated method stub
		System.out.println("Hello I am go().." + Thread.currentThread());
	}

}

*/
