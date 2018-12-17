
package src.Client;


import src.Client.ClientApplicationInterface;
import src.bin.Message;

public class ServerProxy {
    ClientApplicationInterface clientApplicationInterface;
    public ServerProxy(ClientApplicationInterface clientApplicationInterface){
            this.clientApplicationInterface = clientApplicationInterface;
    }

    public void send(Message message) {
// sockets senden
    }
}
