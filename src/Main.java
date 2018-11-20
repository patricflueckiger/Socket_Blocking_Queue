import java.io.IOException;

import Server.ServerApplicationInterface;
import Server.ServerServer;
import bin.Message;

public class Main implements ServerApplicationInterface{

	public void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerServer server = new ServerServer(this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void handleMessage(Message message, String connectionId) {
		// TODO Auto-generated method stub
		
	}

}
