package src.Server;

import java.io.IOException;
import src.bin.*;


public class Main implements ServerApplicationInterface {
	static ServerServer server;
	public static void main(String[] args) {

		MessageQueue queue = new MessageQueue();
		MessageEntry entry = new MessageEntry(queue);
		// TODO Auto-generated method stub
		server = ServerServer.getInstance(entry);

	}

	@Override
	public void handleMessage(Message message, String connectionId) {
		server.openConnection(connectionId);
		System.out.println(message.toString());
	}

}
