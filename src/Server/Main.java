package src.Server;

import java.io.IOException;
import src.bin.*;


public class Main implements ServerApplicationInterface {
	static ServerServer server;
	public static void main(String[] args) {

		MessageQueue queue = new MessageQueue();
		MessageEntry entry = new MessageEntry(queue);
		// TODO Auto-generated method stub
		try {
			server = new ServerServer(this);
			server = new ServerServer(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	@Override
	public void handleMessage(Message message, String connectionId) {
		server.openConnection(connectionId);
		System.out.println(message.toString());
	}

}
