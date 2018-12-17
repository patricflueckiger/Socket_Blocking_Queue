package src.Server;

import src.bin.ClientMessage;
import src.bin.ClientMessageStub;
import src.bin.Message;

public class ServerApplicationStub implements ServerApplicationInterface{
    @Override
    public void handleMessage(Message message, String connectionId) {
        ClientMessage clientMessage = (ClientMessage) message;
        System.out.println("From: "+ connectionId);
        System.out.println("Message: "+ clientMessage.getPlayerName());
    }
}
