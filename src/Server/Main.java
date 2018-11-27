import java.io.IOException;


public class Main implements ServerApplicationInterface{
		try {
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
