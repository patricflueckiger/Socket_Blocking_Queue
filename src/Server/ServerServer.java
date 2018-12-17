
package src.Server;
import src.bin.Message;

import java.net.*;
import java.util.*;
import java.io.*;

public final class ServerServer extends Server {

    private static volatile ServerServer serverInstance;
	protected int port = 4444;
	protected String clientIp = "";
	private ServerSocket serverSocket;
	private int maxClient = 4;
	protected List<ClientThread> clients = new ArrayList<ClientThread>();


	//Singleton Design Pattern
	public static ServerServer getInstance(ServerApplicationInterface serverApplicationInterface){

	    if(serverInstance == null){
	        synchronized (ServerServer.class){
                try {
                    serverInstance = new ServerServer(serverApplicationInterface);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
	    return serverInstance;
    }

    //Constructor of Class
	private ServerServer(ServerApplicationInterface serverApplication) throws IOException {
		super(serverApplication);
	}

	@Override
	public void send(Message message, String connectionId) {
        System.out.println("Added message sending task to blocking queue.");
        System.out.println("Top:"+connectionId);
	}

	@Override
	public void broadcast(Message message) {
		// TODO Auto-generated method stub

	}
	
	public void openConnection() {
		
		try {
			ServerSocket serverSocket = new ServerSocket(port);
			System.out.println("Server listening to port:"+port);
			for(int i=clients.size(); i < maxClient;) {
				clients.add(new ClientThread(serverSocket, Integer.toString(i+1), serverApplication));
				clients.get(i).run();
				i++;
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void closeConnection() {
		for (ClientThread client:clients) {
			client.closeStreams();
		}
	}
}
