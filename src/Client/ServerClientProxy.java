package src.Client;
import src.Client.*;
import src.bin.ClientMessage;
import src.bin.ClientMessageStub;
import src.bin.Message;

import java.io.*;
import java.net.Socket;

public class ServerClientProxy extends ServerProxy {
	

	private Socket clientSocket;
	private int port = 4444;
	private PrintWriter out;
	private BufferedReader in;
	private String serverIp = ""; 
	
	public ServerClientProxy (ClientApplicationInterface clientApplication) {

		super(clientApplication);
		// TODO Auto-generated constructor stub
	}


	public void send(Message message) {
		// TODO Auto-generated method stub
//		out.println(message);
//		String resp = in.readLine();
//		retunr resp;
		try {
			ObjectInputStream is = new ObjectInputStream(clientSocket.getInputStream());
			ObjectOutputStream os = new ObjectOutputStream(clientSocket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}


	}

	private void deliverResponseMessageToClient(Message responseMessage) {
		Thread responseThread = new Thread() {
			@Override
			public void run() {
				clientApplicationInterface.handleMessage(responseMessage);
			}
		};
		responseThread.start();
	}

	public void openConnection(String ip, int port) {
		//socket er�ffnen message an server 
		Socket clientSocket = null;
		try {
			clientSocket = new Socket(ip, port);
			ObjectOutputStream os = new ObjectOutputStream(clientSocket.getOutputStream());
			os.writeObject(new ClientMessageStub("playerOne"));
			//os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//	out = new PrintWriter(clientSocket.getOutputStream(), true);

	}
	public void closeConnection() {
		try {
			in.close();
			out.close();
			clientSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	} 
}

