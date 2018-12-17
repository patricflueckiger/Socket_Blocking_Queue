package src.Server;

import java.io.IOException;
import src.bin.*;


public class Main implements ServerApplicationInterface {
	static ServerServer server;
	public static void main(String[] args) {
		ServerApplicationStub serverApplicationStub = new ServerApplicationStub();
		// TODO Auto-generated method stub
		server = ServerServer.getInstance(serverApplicationStub);
		server.openConnection();
	}

	@Override
	public void handleMessage(Message message, String connectionId) {
		System.out.println(message.toString());
	}

}
