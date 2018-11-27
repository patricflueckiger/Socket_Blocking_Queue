import java.io.IOException;


		try {
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
