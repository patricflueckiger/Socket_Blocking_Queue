package src.Server;

import src.bin.Message;

public class ServerApplicationStub implements ServerApplicationInterface{
    @Override
    public void handleMessage(Message message, String connectionId) {
        System.out.println("From: "+ connectionId);
        System.out.println("Message: "+message);
    }
}
