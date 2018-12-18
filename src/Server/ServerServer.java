
package src.Server;

import com.sun.org.apache.xml.internal.utils.StringToIntTable;
import com.sun.security.ntlm.Client;
import src.bin.Message;

import java.net.*;
import java.util.*;
import java.io.*;

//N1 G20: Sprechende Namen
//G30: Eine Methode soll nur etwas machen
public final class ServerServer extends Server {

    private static volatile ServerServer serverInstance;
    //G25 Zahlen durch Konstanten ersetzen.
    protected final int port = 4444;
    private int maxClient = 4;
    protected List<ClientThread> clients = new ArrayList<ClientThread>();


    //Singleton Design Pattern
    public static ServerServer getInstance(ServerApplicationInterface serverApplicationInterface) {

        if (serverInstance == null) {
            synchronized (ServerServer.class) {
                try {
                    serverInstance = new ServerServer(serverApplicationInterface);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return serverInstance;
    }

    //Constructor of Class
    private ServerServer(ServerApplicationInterface serverApplication) throws IOException {
        super(serverApplication);
    }

    @Override
    public void send(Message message, String connectionId) {
        ClientThread client = getClient(connectionId);
        if (client != null) client.sendMessage(message);
    }

    @Override
    public void broadcast(Message message) {
        for (ClientThread client : clients) {
            client.sendMessage(message);
        }
    }

    //G34 Methode soll nur eine Tiefe besitzen
    public void openConnection() {

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server listening to port:" + port);
            createConnectionWithClients(serverSocket);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    private void createConnectionWithClients(ServerSocket serverSocket) {
        for (int i = clients.size(); i < maxClient; ) {
            clients.add(new ClientThread(serverSocket, Integer.toString(i + 1), serverApplication));
            clients.get(i).start();
            i++;
        }
    }

    public void closeConnection() {
        for (ClientThread client : clients) {
            client.closeStreams();
        }
    }

    private ClientThread getClient(String clientId) {

        return clients
                .stream()
                .filter(x -> x.getName().equals(clientId))
                .findFirst()
                .orElse(null);

//        for (ClientThread client : clients) {
//            if (client.getName().equals(clientId)) return client;
//        }
//        return null;
    }
}
