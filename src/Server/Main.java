import java.io.IOException;

import src.bin.*;


public static class Main implements ServerApplicationInterface{
	MessageQueue queue = new MessageQueue();
    MessageEntry entry = new MessageEntry(queue);
    
		try {
			ServerServer server = new ServerServer();
			
		} catch (IOException e) {


			e.printStackTrace();
		}
		
	}

	@Override
	public void handleMessage(Message message, String connectionId) {
		server.openConnection(connectionId);
		System.out.println(message.toString());
	}

}
