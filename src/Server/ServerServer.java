
package src.Server;
import src.bin.Message;

import java.net.*;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.io.*;
import java.util.function.Consumer;

public final class ServerServer extends Server implements ObserverInterface {

    private static volatile ServerServer serverInstance;
	protected int port = 4444;
	protected String clientIp = "";
	private ServerSocket serverSocket;
	protected HashMap<String, Socket> sockets;
	ExecutorService executor = Executors.newFixedThreadPool(5);
	BlockingQueue<TaskItem> queue = new LinkedBlockingDeque<>();
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
		//serverSocket = new ServerSocket(port);

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
			for(int i=0; i < maxClient; i++) {
				clients.add(new ClientThread(serverSocket, Integer.toString(i++), this));
				clients.get(i-1).run();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	
	private static Consumer<Socket> sendingTask(Message message, String connectionId){
        //Implement sending Task
		return null;
	}

		@Override
	public void update(Observable o, Object arg) {

	}
}
