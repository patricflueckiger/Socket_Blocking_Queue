package src.Server;

import src.bin.ClientMessage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.Observer;


public class ClientThread extends Thread
{

	private ServerSocket ss;
	private String threadName;
	private boolean connected; 
	private Observable observable;
	
	public ClientThread(ServerSocket ss, String name, Observer observer) 
	{
		this.ss = ss;
		this.threadName = name;
		this.observable = new Observable();
		this.observable.addObserver(observer);
		this.connected = false;
	}
	
	
	
	
	public boolean isConnected() 
	{
		return this.connected;
	}
	
	public void run()
	{
		this.threadName = Thread.currentThread().getName();
		System.out.println("Server wartet auf Verbindung ("+threadName+")");
		
		sendMessage("hello");
		
	}
	
	public void sendMessage(String message)
	{
		try {
			Socket cs = ss.accept(); 
		
			ObjectInputStream is = new ObjectInputStream(cs.getInputStream());
			ObjectOutputStream os = new ObjectOutputStream(cs.getOutputStream());
		
			this.connected = true;
			System.out.println("Verbindung zum ClientSocket wurde aufgebaut.");
		
			//os.writeObject(message);
			ClientMessage clientMessage = (ClientMessage) is.readObject();
			is.close();
			os.close();
			cs.close();

			observable.notifyObservers();

			this.connected = false;
			System.out.println("Verbindung wurde abgebaut ("+threadName+")");
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
	}
	
}
