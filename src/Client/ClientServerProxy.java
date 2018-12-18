package src.Client;
import src.Client.*;
import src.bin.ClientMessage;
import src.bin.ClientMessageStub;
import src.bin.Message;

import java.io.*;
import java.net.Socket;

public class ClientServerProxy extends ServerProxy {

	private static volatile ClientServerProxy clientInstance;
	private Socket clientSocket;
	private int port = 4444;
	private PrintWriter out;
	private BufferedReader in;
	private String serverIp = "";
	ObjectInputStream is;
	ObjectOutputStream os;
	//constructor
	private ClientServerProxy (ClientApplicationInterface clientApplication) {

		super(clientApplication);
		// TODO Auto-generated constructor stub
	}
	//Singleton Design Pattern
	public static ClientServerProxy getInstance( ClientApplicationInterface clientApplication){

		if(clientInstance == null){
			synchronized (ClientServerProxy.class){
				clientInstance = new ClientServerProxy(clientApplication);
			}
		}
		return clientInstance;
	}

	public void send(Message message) {
		// TODO Auto-generated method stub
		try {
			os.writeObject(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void getMessagesInput() {
		Thread responseThread = new Thread() {

			ObjectInputStream anotherInput = is;
			@Override
			public void run() {
				while (true){
					try {
						Message clientMessage = (Message) anotherInput.readObject();
						clientApplicationInterface.handleMessage(clientMessage);
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		};
		responseThread.start();
	}

	public void openConnection(String ip, int port) {
		//socket er�ffnen message an server 
		Socket clientSocket = null;
		try {
			clientSocket = new Socket(ip, port);
			System.out.println("Connection geöffnet von Client");
			os = new ObjectOutputStream(clientSocket.getOutputStream());
			is = new ObjectInputStream(clientSocket.getInputStream());
			getMessagesInput();
		} catch (IOException e) {
			e.printStackTrace();
		}

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

