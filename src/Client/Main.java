package src.Client;

import java.io.IOException;

import src.Server.ServerApplicationStub;
import src.bin.*;


public class Main implements ClientApplicationInterface {
    static ServerClientProxy server;
    public static void main(String[] args) {
        ClientApplicationStub clientStub = new ClientApplicationStub();
        // TODO Auto-generated method stub
        server = new ServerClientProxy(clientStub);
        server.openConnection("127.0.0.1",4444);

    }

    @Override
    public void handleMessage(Message message) {

    }
}