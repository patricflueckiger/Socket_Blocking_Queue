package src.Client;
import src.Client.*;
import src.bin.Message;
public class ServerClientProxy extends ServerProxy{
	
	public ServerClientProxy(ClientApplicationInterface clientApplication) {
		super(clientApplication);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(Message message) {
		// TODO Auto-generated method stub
		
	}
	private void deliverResponseMessageToClient(Message responseMessage) {
		Thread responseThread = new Thread() {
			@Override
			public void run() {
				clientApplication.handleMessage(responseMessage);
			}
		};
		responseThread.start();
	}

//	public void openConnection() {
//		//socket eröffnen message an server 
//		
//	}
//	public void closeConnection() {
//		
//	} 
}
