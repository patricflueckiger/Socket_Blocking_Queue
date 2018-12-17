package src.Server;

import src.bin.ClientMessage;
import src.bin.Message;
import sun.util.resources.cldr.agq.CurrencyNames_agq;

import java.io.IOException;
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
	private ServerApplicationInterface messageHandler;
	private Socket cs;
	private ObjectInputStream is;
	private ObjectOutputStream os;

	public ClientThread(ServerSocket ss, String name, ServerApplicationInterface messageHandler)
	{
		this.ss = ss;
		this.threadName = name;
		this.connected = false;
		this.messageHandler =messageHandler;
		try {
			cs = ss.accept();
			is = new ObjectInputStream(cs.getInputStream());
			os = new ObjectOutputStream(cs.getOutputStream());
			this.connected = true;
			System.out.println("Verbindung zum ClientSocket wurde aufgebaut.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean isConnected() 
	{
		return this.connected;
	}
	
	public void run()
	{

		try {
			Message clientMessage = (Message) is.readObject();
			messageHandler.handleMessage(clientMessage, threadName);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public void sendMessage(String message)
	{
		try {
			os.writeObject(message);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void closeStreams(){
		try {
			is.close();
			os.close();
			cs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.connected = false;
		System.out.println("Verbindung wurde abgebaut ("+threadName+")");
	}
}
