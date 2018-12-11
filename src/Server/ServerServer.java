
package src.Server;
import src.bin.Message;

import java.net.*;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.io.*;
import java.util.function.Consumer;

public final class ServerServer extends Server {

    private static volatile ServerServer serverInstance;
	protected int port = 4444;
	protected String clientIp = "";
	private ServerSocket serverSocket;
	protected HashMap<String, Socket> sockets;
	ExecutorService executor = Executors.newFixedThreadPool(5);

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
		serverSocket = new ServerSocket(port);
		System.out.println("Server listening to port:"+port);
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
	
	public void openConnection(String connectionString) {

		try {
			sockets.put(connectionString, serverSocket.accept()); 
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
