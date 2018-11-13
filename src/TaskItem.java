package network.server.gruppe2;

import java.net.Socket;
import java.util.function.Consumer;

import network.Message;

public class TaskItem {
	String connectionId;
	Consumer<Socket> function;
	
	public TaskItem(String connectionId, Consumer<Socket> function) {
		this.connectionId = connectionId;
		this.function = function;
	}

}
