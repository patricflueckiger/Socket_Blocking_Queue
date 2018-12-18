package src.Client;

import src.bin.ClientMessageStub;
import src.bin.Message;

public class ClientApplicationStub implements ClientApplicationInterface{

    @Override
    public void handleMessage(Message message) {
        System.out.println("Message: "+ message);
    }
}
