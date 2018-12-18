package src.Client;

import java.io.IOException;

import src.Server.ServerApplicationStub;
import src.bin.*;


public class Main implements ClientApplicationInterface {
    static ServerClientProxy server;
    public static void main(String[] args) {
        ClientApplicationStub clientStub = new ClientApplicationStub();
        // TODO Auto-generated method stub
        server = ServerClientProxy.getInstance(clientStub);
        server.openConnection("127.0.0.1",4444);
        ServerClientProxy server1= ServerClientProxy.getInstance(clientStub);
        ServerClientProxy server2 = ServerClientProxy.getInstance(clientStub);
        ServerClientProxy server3 = ServerClientProxy.getInstance(clientStub);
        server1.openConnection("127.0.0.1",4444);
        server2.openConnection("127.0.0.1",4444);
        server3.openConnection("127.0.0.1",4444);

    }

    @Override
    public void handleMessage(Message message) {

    }
}