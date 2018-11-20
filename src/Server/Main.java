package Server;
import java.io.IOException;

import bin.Message;

public class Main implements ServerApplicationInterface{
	ServerServer server;
	public void main(String[] args) {
		// TODO Auto-generated method stub
		try {
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
