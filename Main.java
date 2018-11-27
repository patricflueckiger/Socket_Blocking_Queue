
public class Main implements ClientApplicationInterface{
	
	
	@Override
	public void handleMessage(Message message, String connectionId) {
		ServerClientProxy.openConnection(connectionId);
		System.out.println(message.toString());
	}

}
