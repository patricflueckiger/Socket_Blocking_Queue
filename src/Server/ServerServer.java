
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

public class ServerServer extends Server {

	protected int port = 4444;
	protected String clientIp = "";
	private ServerSocket serverSocket;
	protected HashMap<String, Socket> sockets;
	ExecutorService executor = Executors.newFixedThreadPool(5);
	BlockingQueue<TaskItem> queue = new LinkedBlockingDeque<>();
	
	
	public ServerServer(ServerApplicationInterface serverApplication) throws IOException {
		super(serverApplication);
		serverSocket = new ServerSocket(port);
	}

	@Override
	public void send(Message message, String connectionId) {
		queue.add(new TaskItem(connectionId,sendingTask(message,connectionId)));
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
	
	private static Consumer<Socket> sendingTask(Message message, String connectionId){
		return null;
	}



}
