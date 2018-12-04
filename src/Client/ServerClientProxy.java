package src.Client;
import src.Client.*;
import src.bin.Message;
public class ServerClientProxy extends ServerProxy{
	

	private Socket clientSocket;
	private int port = 4444;
	private PrintWriter out;
	private BufferedReader in; 
	private String serverIp = ""; 
	
	public ClientServerProxy(ClientApplicationInterface clientApplication) {

		super(clientApplication);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void send(String message) {
		// TODO Auto-generated method stub
//		out.println(message);
//		String resp = in.readLine();
//		retunr resp;
		out = new PrintWriter(clientSocket.getOutputStream(message), true);
		
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

	public void openConnection(String ip, int port) {
		//socket eröffnen message an server 
		clientSocket = new Socket(ip, port);
	//	out = new PrintWriter(clientSocket.getOutputStream(), true);
		in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
		
	}
	public void closeConnection() {
		in.close();
		out.close();
		clientSocket.close();
		
	} 
}

